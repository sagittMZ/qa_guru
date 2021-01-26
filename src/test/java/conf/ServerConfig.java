package conf;

import org.aeonbits.owner.Config;

import java.util.List;

public interface ServerConfig extends Config {

    @ConverterClass(ServerConverter.class)
    @DefaultValue("google.com:4444, yandex.ru:4444")
    List<Server> getServers();
}
