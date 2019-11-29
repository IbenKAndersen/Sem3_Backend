package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Kodebanditterne
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Order.deleteAllRows", query = "DELETE FROM Order"),
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o"),
})
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<OrderLine> ol;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date d;

    public Order() {
    }

    public Order(User user, List<OrderLine> ol, Date d) {
        this.user = user;
        this.ol = ol;
        this.d = d;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    
    
}
