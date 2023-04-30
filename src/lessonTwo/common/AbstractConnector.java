package lessonTwo.common;

public abstract class AbstractConnector {

    private String host;
    private int port;

    abstract String ping();

    public AbstractConnector(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() {
        System.out.println("Abstract connector. connect. host:" + host + " port:" + port);
    }

    public void disconnect(String host) {
        System.out.println("Abstract connector. disconnect. host:" + host + " port:" + port);
    }
}
