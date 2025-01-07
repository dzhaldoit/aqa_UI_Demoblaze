package api.pojo.requests;

public class AuthRequest {

    private String token;

    public AuthRequest(String token) {
        this.token = token;
    }

    public AuthRequest() {
    }

    public String getToken() {
        return token;
    }
}
