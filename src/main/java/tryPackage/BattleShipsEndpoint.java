package tryPackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


/**
 * @author Kacper Staszek
 */
@ServerEndpoint(value = "/battleship/kacpi",
    decoders = MessageDecoder.class,
    encoders = MessageEncoder.class)
class BattleShipsEndpoint {
  private Session session;
  private static Set<BattleShipsEndpoint> chatEndpoints
      = new CopyOnWriteArraySet<>();
  private static HashMap<String, String> users = new HashMap<>();
  private AtomicInteger numberOfPlayers = new AtomicInteger(0);

  @OnOpen
  public void onOpen( Session session,
      @PathParam("username") String username) throws IOException, EncodeException {
    System.out.println(numberOfPlayers.incrementAndGet());
    // Get session and WebSocket connection
    this.session = session;
    chatEndpoints.add(this);
    users.put(session.getId(), username);

    Message message = new Message();
    message.setFrom(username);
    message.setContent("Connected!");
    broadcast(message);
  }

  @OnMessage
  public void onMessage(Session session, Message message) throws IOException, EncodeException {
    // Handle new messages
    message.setFrom(users.get(session.getId()));
    broadcast(message);
  }

  @OnClose
  public void onClose(Session session) throws IOException, EncodeException {
    // WebSocket connection closes
    chatEndpoints.remove(this);
    Message message = new Message();
    message.setFrom(users.get(session.getId()));
    message.setContent("Disconnected!");
    broadcast(message);
  }

  private static void broadcast(Message message)
      throws IOException, EncodeException {

    chatEndpoints.forEach(endpoint -> {
      synchronized (endpoint) {
        try {
          endpoint.session.getBasicRemote().
              sendObject(message);
        } catch (IOException | EncodeException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @OnError
  public void onError(Session session, Throwable throwable) {
    // Do error handling here
  }
}
