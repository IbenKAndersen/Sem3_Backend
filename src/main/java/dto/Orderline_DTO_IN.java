/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Equipment;
import entities.OrderLine;
import java.util.List;

/**
 *
 * @author ndupo
 */
public class Orderline_DTO_IN {

    private int id;
    private Car_DTO_IN car;
    private Order_DTO_IN order;
    private Insurance_DTO_IN insurance;
    private Location_DTO_IN location;
    private List<Equipment_DTO_IN> equipment;
    private String rentalPeriodStart;
    private String rentalPeriodEnd;

    public Orderline_DTO_IN() {
    }

    public Orderline_DTO_IN(OrderLine ol) {
        this.car = new Car_DTO_IN(ol.getCar());
        this.order = new Order_DTO_IN(ol.getOrder());
        this.insurance = new Insurance_DTO_IN(ol.getInsurance());
        this.location = new Location_DTO_IN(ol.getLocation());
        if (ol.getEquipmentList() != null) {
            ol.getEquipmentList().forEach((equipment) -> {
                this.equipment.add(new Equipment_DTO_IN(equipment));
            });
        }
        this.rentalPeriodStart = ol.getRentalPeriodStart();
        this.rentalPeriodEnd = ol.getRentalPeriodEnd();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car_DTO_IN getCar() {
        return car;
    }

    public void setCar(Car_DTO_IN car) {
        this.car = car;
    }

    public Order_DTO_IN getOrder() {
        return order;
    }

    public void setOrder(Order_DTO_IN order) {
        this.order = order;
    }

    public Insurance_DTO_IN getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance_DTO_IN insurance) {
        this.insurance = insurance;
    }

    public Location_DTO_IN getLocation() {
        return location;
    }

    public void setLocation(Location_DTO_IN location) {
        this.location = location;
    }

    public List<Equipment_DTO_IN> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment_DTO_IN> equipment) {
        this.equipment = equipment;
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
