package API;

import java.util.Objects;

public class Resp {
    public Resp(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    private Integer id;
    private String token;

    public Resp(){

    }

}
