package conf;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:${device}.properties")
public interface MobileConfig extends Config {
    @Key("mobile.platform.name")
    String platformName();

    @Key("mobile.platform.version")
    String platformVersion();

    @Key("mobile.device.name")
    String deviceName();

    @Key("mobile.app.location")
    URL appLocation();

}
