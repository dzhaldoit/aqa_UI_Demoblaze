package api.pojo.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {

    @JsonProperty("Item")
    private Item item;

    public AuthResponse(Item item) {
        this.item = item;
    }

    public AuthResponse() {
    }

    public Item getItem() {
        return item;
    }
}