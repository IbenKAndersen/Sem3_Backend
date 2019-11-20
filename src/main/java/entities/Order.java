package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mikkel
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @OneToMany
    private List<OrderLine> ol;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date d;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderLine> getOl() {
        return ol;
    }

    public void setOl(List<OrderLine> ol) {
        this.ol = ol;
    }

    public Date getDate() {
        return d;
    }

    public void setDate(Date d) {
        this.d = d;
    }
    
}
