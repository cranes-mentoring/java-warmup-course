package lesson_2.common;

public interface IConnector {
    void connect(String host);
    void disconnect(String host);
    void pause(String host);

    void dropAll();
}
