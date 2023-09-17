import javax.persistence.*;
import jakarta.persistence.*;
import java.sql.Timestamp;
@Entity
public class UserHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private java.sql.Timestamp scan_timestamp;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public java.sql.Timestamp getScan_timestamp() {
        return scan_timestamp;
    }

    public void setScan_timestamp(java.sql.Timestamp scan_timestamp) {
        this.scan_timestamp = scan_timestamp;
    }
}
