package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remoteauth.properties"
})
public interface RemoteConfig extends Config {

    @Key("remoteUser")
    String getUser();

    @Key("remotePass")
    String getPass();
}