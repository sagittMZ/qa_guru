package tests;

import conf.Server;
import conf.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;


public class ServerTests {

    @Test
    public void testServer(){
        ServerConfig config = ConfigFactory.newInstance().create(ServerConfig.class);

        for (Server server: config.getServers()) {
            System.out.println(server.host);
            System.out.println(server.port);
        }

    }
}
