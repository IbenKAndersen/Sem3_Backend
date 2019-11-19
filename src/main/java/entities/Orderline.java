package entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class Orderline implements Serializable {
    @Basic
    private int lineNumber;
    @OneToOne
    private Car car;

    public Orderline(Car car) {
        this.car = car;
    }
    
    public Orderline() {
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
