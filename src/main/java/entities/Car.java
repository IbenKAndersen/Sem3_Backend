package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author benjaminbajrami
 */
@Entity
@Table(name = "cars")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "car_id", length = 25)
    private int carId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "car_make", length = 25)
    private String carMake;
    @Basic(optional = false)
    @NotNull
    @Column(name = "car_model", length = 30)
    private String carModel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "car_details", length = 255)
    private String carDetails;
    @OneToOne 
    private OrderLine orderlines;
    @OneToOne
    private Insurance insurance;
    @ManyToOne
    private Location location;
    @OneToMany
    private List<Equipment> equipment;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(String carDetails) {
        this.carDetails = carDetails;
    }

    public OrderLine getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(OrderLine orderlines) {
        this.orderlines = orderlines;
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

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + carId + ", carMake=" + carMake + ", carModel=" + carModel + ", carDetails=" + carDetails + ", orderlines=" + orderlines + ", insurance=" + insurance + ", location=" + location + ", equipment=" + equipment + '}';
    }

}
