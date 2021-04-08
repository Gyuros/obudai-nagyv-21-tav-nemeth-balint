package cookbook.domain;

import java.util.Objects;

public abstract class User implements Identifiable {

    private long id;
    private final String username;
    private final String password;

    protected User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    protected User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", id, username, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
