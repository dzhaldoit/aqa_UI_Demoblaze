package api;

import api.pojo.requests.AuthRequest;
import api.pojo.responses.AuthResponse;
import config.UrlConfings;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;

public class ApiHelpMethods {
    UrlConfings urlConfings = ConfigFactory.create(UrlConfings.class, System.getProperties());
    protected final String authCookieName = "tokenp_";

    /**
     * метод  получения токена авторизации через апи.
     * На вход передаются логин и пароль
     *
     * @param token
     * @return
     */
    public String authWithApi(String token) {
        Spec.install(urlConfings.getApiAuthUrl(), HttpStatus.SC_OK);
        AuthRequest body = new AuthRequest(token);
        AuthResponse response =
                RestAssured
                        .given()
                        .body(body)
                        .when()
                        .post()
                        .then().log().all()
                        .extract().as(AuthResponse.class);
        return response.getItem().getToken();
    }
}