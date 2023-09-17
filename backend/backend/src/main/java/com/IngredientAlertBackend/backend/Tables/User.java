import javax.persistence.*;
import jakarta.persistence.*;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String auth0_id;

    // Other user-related fields if necessary

    // Getters and setters
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getAuth0_id() {
        return auth0_id;
    }

    public void setAuth0_id(String auth0_id) {
        this.auth0_id = auth0_id;
    }

    // Other getters and setters if necessary
}
