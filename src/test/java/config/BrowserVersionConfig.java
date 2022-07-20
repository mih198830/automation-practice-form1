package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browserVersions.properties")
public interface BrowserVersionConfig extends Config {
    @Key("browserVersions")
    @DefaultValue("103.0")
    String chromeVersion100();
    String chromeVersion101();
    String chromeVersion102();
    String chromeVersion103();
}
