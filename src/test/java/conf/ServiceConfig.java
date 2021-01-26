package conf;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)  //если FIRST, то берет данные из первого варианта,
                                           //если MERGE, то подтягивает из следующих, по необходимости
@Config.Sources({
        "classpath:default.properties",

})
public interface ServiceConfig extends Config {

    @Key("service.name")
    String name();

    @DefaultValue("http://web.${service.name}.company.com")
    @Key("service.base.url")
    String webUrl();

    @DefaultValue("http://db.${service.name}.company.com")
    @Key("service.db.url")
    String dbUrl();

    @DefaultValue("http://api.${service.name}.company.com")
    @Key("service.api.url")
    String apiUrl();

}
