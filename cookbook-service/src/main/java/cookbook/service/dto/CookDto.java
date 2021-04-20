package cookbook.service.dto;

public class CookDto {

    private long id;
    private String username;
    private String password;

    public CookDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public CookDto(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }
}
