/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Insurance;

/**
 *
 * @author ndupo
 */
public class Insurance_DTO_IN {
    
    private boolean insured;
    private int price;
    private String name;
    
    public Insurance_DTO_IN(Insurance insurance) {
        this.insured = insurance.isInsurance();
        this.price = insurance.getPrice();
        this.name = insurance.getName();
    }

    public Insurance_DTO_IN() {
    }

    public boolean isInsured() {
        return insured;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Insurance_DTO_IN{" + "insured=" + insured + ", price=" + price + ", name=" + name + '}';
    }

    
}
