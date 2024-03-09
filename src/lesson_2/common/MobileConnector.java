package lesson_2.common;

public class MobileConnector extends AbstractConnector {

    private String provider;

    public MobileConnector(String provider, String host, int port) {
        super(host, port);
        this.provider = provider;
    }

    @Override
    String ping() {
        System.out.println("PONG!");
        return "Pong from mobile!";
    }

    @Override
    public void connect() {
        String provider = this.provider;
        callToProvider(provider);
        System.out.println("Call to provider");
        System.out.println("Connecting!");
    }

    @Override
    public void disconnect(String host) {
        super.disconnect(host);
    }

    public String getProvider() {
        return provider;
    }

    public void callToProvider(String provider) {
        // todo: some action
    }
}
