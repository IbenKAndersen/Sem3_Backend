package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderlines")
public class Orderline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Orderline() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int qty;

    @OneToOne
    private Car car;

    @ManyToOne
    private Order order;

}
