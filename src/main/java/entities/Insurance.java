package entities;
/**
 * @author benjaminbajrami
 */

public class Insurance {

    private boolean insurance;
    private int price;

    public Insurance(boolean insurance, int price) {
        this.insurance = insurance;
        this.price = price;
    }

    public Insurance() {
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

    @Override
    public String toString() {
        return "Insurance{" +
                "insurance=" + insurance +
                ", price=" + price +
                '}';
    }
}
