package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author benjaminbajrami
 */
@Entity
@Table(name = "insurance")
public class Insurance implements Serializable{

    private static final long serialVersionUID = 1L;
    private boolean insurance;
    private int price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    private OrderLine orderline;

    public Insurance(boolean insurance, int price, OrderLine orderline) {
        this.insurance = insurance;
        this.price = price;
        this.orderline = orderline;
    }

    public Insurance() {
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderLine getOrderline() {
        return orderline;
    }

    public void setOrderline(OrderLine orderline) {
        this.orderline = orderline;
    }
    
    
}
