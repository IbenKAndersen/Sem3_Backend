/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ndupo
 */
@Entity
@Table(name = "car_model")
public class CarModel implements Serializable {

        @OneToMany(mappedBy = "carModel",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Car> model_of_car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "make_of_model")
    private CarMake make;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "model_id")
    private int id;

    @Column(name = "name")
    private String name;

    public CarModel() {
    }

    public CarModel(List<Car> model_of_car, CarMake make, String name) {
        this.model_of_car = model_of_car;
        this.make = make;
        this.name = name;
    }

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

    public List<Car> getModel_of_car() {
        return model_of_car;
    }

    public void setModel_of_car(List<Car> model_of_car) {
        this.model_of_car = model_of_car;
    }

    public CarMake getMake() {
        return make;
    }

    public void setMake(CarMake make) {
        this.make = make;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarModel)) {
            return false;
        }
        CarModel other = (CarModel) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CarModel[ id=" + id + " ]";
    }

}
