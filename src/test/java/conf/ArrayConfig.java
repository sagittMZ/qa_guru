package conf;

import org.aeonbits.owner.Config;

import java.util.List;

public interface ArrayConfig extends Config {

    //@DefaultValue("apple; banana, orange") //for usual separator as ","
    @Separator(";")  // additional setting for unusual separator
    @DefaultValue("apple; banana; orange")
    List<String> fruits();
}
