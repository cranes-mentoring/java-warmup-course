package lesson_2.common;

public class OfficeConnector extends AbstractConnector {
    public OfficeConnector(String host, int port) {
        super(host, port);
    }

    @Override
    String ping() {
        System.out.println("PONG!");
        return "Pong from office!";
    }

    @Override
    public void connect() {
        var manager = findManager();
        var room = findRoom(manager);
        System.out.println("OfficeConnector, own connect. room:" + room);
    }

    @Override
    public void disconnect(String host) {
        System.out.println("OfficeConnector, own disconnect");
    }

    private String findManager() {
        return "Office manager";
    }

    private String findRoom(String manager) {
        System.out.println("Manager:" + manager + "is trying to find the room");
        return "Room - 1.";
    }
}
