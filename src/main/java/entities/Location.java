/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.JoinTable;

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
    @joinColumn(name = "car_id", referenceColumnName = "car_id")},
    @joinColumn(name = "location_id", referenceColumnName = "location_id"})        )
    private List<Car> cars;
    
    
}
