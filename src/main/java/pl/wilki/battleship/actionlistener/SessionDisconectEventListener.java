package pl.wilki.battleship.actionlistener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * @author Kacper Staszek
 */
@Component
class SessionDisconectEventListener implements ApplicationListener<SessionDisconnectEvent> {

  @Override
  public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
    System.out.println("Client disconnected");
    System.out.println(sessionDisconnectEvent.getSessionId());
  }
}
