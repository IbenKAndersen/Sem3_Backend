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
public class Location_DTO {

    private int id;
    private String address, coord;

    public Location_DTO(Location location) {
        this.id = location.getId();
        this.address = location.getAddress();
        this.coord = location.getCoord();
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
}
