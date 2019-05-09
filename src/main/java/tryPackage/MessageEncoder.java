package tryPackage;

import com.google.gson.Gson;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @author Kacper Staszek
 */
class MessageEncoder implements Encoder.Text<Message>{

  private static Gson gson = new Gson();

  @Override
  public String encode(Message message) throws EncodeException {
    return gson.toJson(message);
  }

  @Override
  public void init(EndpointConfig endpointConfig) {

  }

  @Override
  public void destroy() {

  }
}
