/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author ndupo
 */
@Entity
@Table(name = "location")
public class Location implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "location_id")
    private int id;
    @Column(name = "address")
    private String address;
    @Column(name = "coordinates")
    private String coord;
    @JoinTable(name = "cars_on_location", joinColumns = {
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")}, inverseJoinColumns = {
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")})
    @OneToMany
    private List<Car> cars = new ArrayList();

    public Location() {
    }

    public Location(String address, String coord) {
        this.address = address;
        this.coord = coord;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int getId() {
        return id;
    }
    
    
}
