package lessonTwo.common;

public interface IConnector {
    void connect(String host);
    void disconnect(String host);
    void pause(String host);

    void dropAll();
}
