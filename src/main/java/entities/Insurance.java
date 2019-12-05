package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author benjaminbajrami
 */
@Entity
@Table(name = "insurance")
public class Insurance implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "name", length = 255)
    private String name;
    private boolean insurance;
    private int price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Insurance(String name, boolean insurance, int price) {
        this.name = name;
        this.insurance = insurance;
        this.price = price;
    }

    public Insurance() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
