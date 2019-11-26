/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Car;
import entities.Equipment;
import java.util.List;

/**
 *
 * @author ndupo
 */
public class Car_DTO_IN {

    private int id;
    private String carDetails;
    private Orderline_DTO_IN orderline;
    private CarMake_DTO_IN make;
    private CarModel_DTO_IN model;

    public Car_DTO_IN() {
    }

    public Car_DTO_IN(Car car) {
        this.id = car.getCarId();
        this.carDetails = car.getCarDetails();
        this.orderline = new Orderline_DTO_IN(car.getOrderline());
        this.make = new CarMake_DTO_IN(car.getCarMake());
        this.model = new CarModel_DTO_IN(car.getCarModel());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(String carDetails) {
        this.carDetails = carDetails;
    }

    public Orderline_DTO_IN getOrderline() {
        return orderline;
    }

    public void setOrderline(Orderline_DTO_IN orderline) {
        this.orderline = orderline;
    }

    public CarMake_DTO_IN getMake() {
        return make;
    }

    public void setMake(CarMake_DTO_IN make) {
        this.make = make;
    }

    public CarModel_DTO_IN getModel() {
        return model;
    }

    public void setModel(CarModel_DTO_IN model) {
        this.model = model;
    }

    

    @Override
    public String toString() {
        return "Car_DTO{" + "id=" + id + ", carDetails=" + carDetails + ", orderline=" + orderline + ", make=" + make + ", model=" + model + '}';
    }
    
    

}
