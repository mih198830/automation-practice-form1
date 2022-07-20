package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browserType.properties")
public interface BrowserTypeConfig extends Config {
    @Key("browserType")
    @DefaultValue("CHROME")
    String CHROME();
    String FIREFOX();
}
