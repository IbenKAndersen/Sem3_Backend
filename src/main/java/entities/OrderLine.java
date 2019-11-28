package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orderLines")
public class OrderLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderline_id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @OneToOne(mappedBy = "orderline")
    private Order order;
            
    @OneToOne(fetch = FetchType.LAZY, 
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "insurance_on_orderline")
    private Insurance insurance;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Location location;
    @JoinTable(name = "equipment_on_orderline",
            joinColumns = {
                @JoinColumn(name = "orderline_id", referencedColumnName = "orderline_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "equipment_id", referencedColumnName = "equipment_id")})
    @OneToMany(
        
        cascade = CascadeType.PERSIST,
        orphanRemoval = true
    )
    private List<Equipment> equipmentList;
    private Equipment equipment;
    
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

    public OrderLine(Car car, Order order, Insurance insurance, Location location, List<Equipment> equipment, String rentalPeriodStart, String rentalPeriodEnd) {
        this.car = car;
        this.order = order;
        this.insurance = insurance;
        this.location = location;
        this.equipmentList = equipment;
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

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    
    
    

}
