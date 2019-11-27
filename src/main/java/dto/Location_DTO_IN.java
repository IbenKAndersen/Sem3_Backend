/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Car;
import entities.Location;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ndupo
 */
public class Location_DTO_IN {

    private int id;
    private String address, coord;
    private List<Car_DTO_IN> cars_on_location = new ArrayList();

    public Location_DTO_IN(Location location) {
        this.id = location.getId();
        this.address = location.getAddress();
        this.coord = location.getCoord();
        if (location.getCars_on_location() != null) {
            for (Car car : location.getCars_on_location()) {
                this.cars_on_location.add(new Car_DTO_IN(car));
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoord() {
        return coord;
    }

    public void setCoord(String coord) {
        this.coord = coord;
    }

    public List<Car_DTO_IN> getCars_on_location() {
        return cars_on_location;
    }

    public void setCars_on_location(List<Car_DTO_IN> cars_on_location) {
        this.cars_on_location = cars_on_location;
    }
    
    

}
