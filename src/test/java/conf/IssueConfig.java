package conf;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)  //если FIRST, то берет данные из первого варианта,
                                           //если MERGE, то подтягивает из следующих, по необходимости
@Config.Sources({
        "classpath:project.properties",

})
public interface IssueConfig extends Config {



    @DefaultValue("login")
    @Key("login")
    String login();

    @DefaultValue("password")
    @Key("password")
    String password();

    @DefaultValue("selenoid.autotests.cloud")
    @Key("remote.browser.url")
    String selenoidUrl();


}
