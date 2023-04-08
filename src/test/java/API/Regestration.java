package API;

public class Regestration {
    private Integer id;
    private String token;

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public Regestration(Integer id, String token) {
        this.id = id;
        this.token = token;
    }
}
