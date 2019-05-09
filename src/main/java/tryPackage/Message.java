package tryPackage;

/**
 * @author Kacper Staszek
 */
class Message {

  private String from;
  private String to;
  private String content;

  void setFrom(String username) {
    this.from=username;
  }

  void setContent(String content) {
    this.content=content;
  }

  void setTo(String to){
    this.to=to;
  }
}
