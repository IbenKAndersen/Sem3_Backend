package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderLines")
public class OrderLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Car car;

    @ManyToOne
    private Booking order;
    
    public OrderLine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Booking getOrder() {
        return order;
    }

    public void setOrder(Booking order) {
        this.order = order;
    }
    
}
