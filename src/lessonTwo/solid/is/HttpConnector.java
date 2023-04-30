package lessonTwo.solid.is;

public interface HttpConnector extends Connector {

    void setAddress(String host);
    void setPost(int port);
}
