package config;

import org.aeonbits.owner.Config;
import java.net.URL;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {
    @Key("login")
    String login();
    @Key("password")
    String password();

    @Key("remoteUrl")
    URL remoteUrl();

    @Key("remote.WebDriver")
    String getRemoteWebDriver();
}
