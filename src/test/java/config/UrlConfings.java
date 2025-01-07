package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:url.properties"
})
public interface UrlConfings extends Config {

    @Key("apiAuthUrl")
    String getApiAuthUrl();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("remoteUrl")
    String getRemoteUrl();
}