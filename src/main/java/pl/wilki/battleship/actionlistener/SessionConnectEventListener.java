package pl.wilki.battleship.actionlistener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

/**
 * @author Kacper Staszek
 */

@Component
class SessionConnectEventListener implements ApplicationListener<SessionConnectedEvent> {

  @Override
  public void onApplicationEvent(SessionConnectedEvent sessionConnectedEvent) {

    System.out.println("New session is here!");
    System.out.println(sessionConnectedEvent.getSource());
    System.out.println(sessionConnectedEvent.getMessage().getHeaders().get("simpSessionId"));
  }
}
