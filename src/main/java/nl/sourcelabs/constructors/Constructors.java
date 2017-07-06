package nl.sourcelabs.constructors;

public class Constructors {

    public static void main(String[] args) {
        // Create the simplest instance of serverconfig, using the default for port, which was built-in manually
        final JavaServerConfig serverConfig = new JavaServerConfig("127.0.0.1");

        // Create a serverconfig with both host and port
        final JavaServerConfig serverConfig1 = new JavaServerConfig("127.0.0.1", 80);

        // Change the mutable server port, only possible after defining an accessor manually
        serverConfig.setPort(1000);
    }
}

/**
 * Implementation similar to the one in Kotlin. Mutable port, telescoping constructor
 */
class JavaServerConfig {

    private final String hostname;
    private int port = 80;

    public JavaServerConfig(final String hostname, final int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public JavaServerConfig(final String hostname) {
        this.hostname = hostname;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(final int port) {
        this.port = port;
    }
}
