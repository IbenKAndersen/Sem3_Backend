package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
    
        @OneToMany(
        mappedBy = "location",
        cascade = CascadeType.PERSIST,
        orphanRemoval = true
    )
    private List<Car> cars_on_location = new ArrayList();

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

    public List<Car> getCars_on_location() {
        return cars_on_location;
    }

    public void setCars_on_location(List<Car> cars_on_location) {
        this.cars_on_location = cars_on_location;
    }

    public int getId() {
        return id;
    }

}
