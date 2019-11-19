package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "orders")
    private User user;
    @ElementCollection
    private List<Orderline> orderLines = new ArrayList<Orderline>();
    @Basic
    private double totalCost = 0;
    @ManyToOne
    private Orderline ol;
    private Date date;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orderline getOl() {
        return ol;
    }

    public void setOl(Orderline ol) {
        this.ol = ol;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public List<Orderline> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<Orderline> orderLines) {
        this.orderLines = orderLines;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public void addOrderLine(Orderline orderLine) {
        getOrderLines().add(orderLine);
        orderLine.setLineNumber(getOrderLines().size());
        setTotalCost(getTotalCost() + orderLine.getCost());
    }
}
