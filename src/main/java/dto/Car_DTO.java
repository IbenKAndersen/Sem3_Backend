/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Car;

/**
 *
 * @author ndupo
 */
public class Car_DTO {

    private int id;
    private String carDetails;
    private Orderline_DTO orderline;
    private CarMake_DTO make;
    private CarModel_DTO model;

    public Car_DTO() {
    }

    public Car_DTO(Car car) {
        this.id = car.getCarId();
        this.carDetails = car.getCarDetails();
        this.orderline = new Orderline_DTO(car.getOrderline());
        this.make = new CarMake_DTO(car.getCarMake());
        this.model = new CarModel_DTO(car.getCarModel());
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

    public Orderline_DTO getOrderline() {
        return orderline;
    }

    public void setOrderline(Orderline_DTO orderline) {
        this.orderline = orderline;
    }

    public CarMake_DTO getMake() {
        return make;
    }

    public void setMake(CarMake_DTO make) {
        this.make = make;
    }

    public CarModel_DTO getModel() {
        return model;
    }

    public void setModel(CarModel_DTO model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car_DTO{" + "id=" + id + ", carDetails=" + carDetails + ", orderline=" + orderline + ", make=" + make + ", model=" + model + '}';
    }
    
    

}