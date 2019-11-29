package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orderLines")
public class OrderLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderline_id")
    private int id;

    
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "car_on_orderline")
    private Car car;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    private Order order;

    
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "insurance_on_orderline")
    private Insurance insurance;

    @OneToOne(mappedBy = "orderline", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Location location;

    @OneToMany(
            mappedBy = "orderline",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Equipment> equipmentList = new ArrayList<>();

    @Column(name = "rental_period_start")
    private String rentalPeriodStart;
    @Column(name = "rental_period_end")
    private String rentalPeriodEnd;

    public OrderLine() {
    }

    public OrderLine(Car car, Insurance insurance, Location location, List<Equipment> equipmentList, String rentalPeriodStart, String rentalPeriodEnd) {
        this.car = car;
        this.insurance = insurance;
        this.location = location;
        this.equipmentList = equipmentList;
        this.rentalPeriodStart = rentalPeriodStart;
        this.rentalPeriodEnd = rentalPeriodEnd;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public String getRentalPeriodStart() {
        return rentalPeriodStart;
    }

    public void setRentalPeriodStart(String rentalPeriodStart) {
        this.rentalPeriodStart = rentalPeriodStart;
    }

    public String getRentalPeriodEnd() {
        return rentalPeriodEnd;
    }

    public void setRentalPeriodEnd(String rentalPeriodEnd) {
        this.rentalPeriodEnd = rentalPeriodEnd;
    }

}
