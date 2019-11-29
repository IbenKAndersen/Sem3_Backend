package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author benjaminbajrami
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Car.getById", query = "SELECT c FROM Car c WHERE c.carId LIKE :id")
})
@Table(name = "cars")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "car_id", length = 255)
    private int carId;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cars_by_make")
    private CarMake carMake;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "model_of_car")
    private CarModel carModel;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "car_details", length = 255)
    private String carDetails;
    
    @ManyToOne
    @JoinColumn(name = "car_On_Location")
    private Location location;

    public Car() {
    }

    public Car(CarMake carMake, CarModel carModel, String carDetails, OrderLine orderline) {
        this.carMake = carMake;
        this.carModel = carModel;
        this.carDetails = carDetails;
    }

    public Car(CarMake carMake, CarModel carModel, String carDetails) {
        this.carMake = carMake;
        this.carModel = carModel;
        this.carDetails = carDetails;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }


    public String getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(String carDetails) {
        this.carDetails = carDetails;
    }

    public CarMake getCarMake() {
        return carMake;
    }

    public void setCarMake(CarMake carMake) {
        this.carMake = carMake;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    
}
