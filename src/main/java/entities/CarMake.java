/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ndupo
 */
@Entity
@Table(name = "car_make")
public class CarMake implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "make_id")
    private int id;
    
    
    @Column(name = "make_name")
    private String name;
    
    @OneToMany(
        mappedBy = "carMake",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Car> cars_by_make = new ArrayList();
    
//    @OneToMany(mappedBy = "make",
//        cascade = CascadeType.ALL,
//        orphanRemoval = true)
//    private List<CarModel> models_of_make = new ArrayList();
    

    public CarMake() {
    }

    public CarMake(String name, List<Car> cars_by_make) {
        this.name = name;
        this.cars_by_make = cars_by_make;
    }

//    public CarMake(String name, List<Car> cars_by_make, List<CarModel> models_of_make) {
//        this.name = name;
//        this.cars_by_make = cars_by_make;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars_by_make() {
        return cars_by_make;
    }

    public void setCars_by_make(List<Car> cars_by_make) {
        this.cars_by_make = cars_by_make;
    }
//
//    public List<CarModel> getModels_of_make() {
//        return models_of_make;
//    }
//
//    public void setModels_of_make(List<CarModel> models_of_make) {
//        this.models_of_make = models_of_make;
//    }

}
