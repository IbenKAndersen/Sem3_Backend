/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import entities.Location;

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
    private Orderline orderlines;
    @OneToOne
    private Insurance insurance;
    @ManyToOne
    private Location location;
    @OneToMany
    private Equipment equipment;
    //TO-DO: create classes and relationships
    
    

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

    public Orderline getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(Orderline orderlines) {
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

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + carId + ", carMake=" + carMake + ", carModel=" + carModel + ", carDetails=" + carDetails + ", orderlines=" + orderlines + ", insurance=" + insurance + ", location=" + location + ", equipment=" + equipment + '}';
    }

}
