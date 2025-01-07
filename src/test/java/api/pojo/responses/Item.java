package api.pojo.responses;

public class Item {
    private Integer expiration;
    private String token;
    private String username;

    public Item(Integer expiration, String token, String username) {
        this.expiration = expiration;
        this.token = token;
        this.username = username;
    }

    public Item() {
    }

    public Integer getExpiration() {
        return expiration;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }
}