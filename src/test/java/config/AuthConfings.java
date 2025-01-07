package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})
public interface AuthConfings extends Config {
    @Key("token")
    String getToken();

    @Key("username")
    String getUsername();

    @Key("password")
    String getPassword();
}