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
public class Orderline_DTO {

    private int id;
    private Car_DTO car;
    private Order_DTO order;
    private Insurance_DTO insurance;
    private Location_DTO location;
    private List<Equipment_DTO> equipment;
    private String rentalPeriodStart;
    private String rentalPeriodEnd;

    public Orderline_DTO() {
    }

    public Orderline_DTO(OrderLine ol) {
        this.car = new Car_DTO(ol.getCar());
        this.order = new Order_DTO(ol.getOrder());
        this.insurance = new Insurance_DTO(ol.getInsurance());
        this.location = new Location_DTO(ol.getLocation());
        if (ol.getEquipmentList() != null) {
            ol.getEquipmentList().forEach((equipment) -> {
                this.equipment.add(new Equipment_DTO(equipment));
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

    public Car_DTO getCar() {
        return car;
    }

    public void setCar(Car_DTO car) {
        this.car = car;
    }

    public Order_DTO getOrder() {
        return order;
    }

    public void setOrder(Order_DTO order) {
        this.order = order;
    }

    public Insurance_DTO getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance_DTO insurance) {
        this.insurance = insurance;
    }

    public Location_DTO getLocation() {
        return location;
    }

    public void setLocation(Location_DTO location) {
        this.location = location;
    }

    public List<Equipment_DTO> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment_DTO> equipment) {
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
