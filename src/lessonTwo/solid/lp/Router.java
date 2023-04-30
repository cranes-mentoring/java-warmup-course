package lessonTwo.solid.lp;

public class Router {

    Connector connector;

    public Router(Connector connector) {
        this.connector = connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }
}
