package entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class Orderline implements Serializable {
    @Basic
    private int lineNumber;
    @OneToOne(cascade={CascadeType.PERSIST})
    private Equipment equipment;
    @Basic
    private double cost = 0;

    public Orderline(Equipment equipment, double cost) {
        this.equipment = equipment;
        this.cost = cost;
    }

    public Orderline() {
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Equipment getProduct() {
        return equipment;
    }

    public void setProduct(Equipment product) {
        this.equipment = product;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
