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
public class Insurance_DTO {
    
    private int id;
    private String name;
    private boolean insured;
    private int price;

    public Insurance_DTO(Insurance insurance) {
        this.id = insurance.getId();
        this.insured = insurance.isInsurance();
        this.price = insurance.getPrice();
        this.name = insurance.getName();
    }

    public Insurance_DTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public boolean isInsured() {
        return insured;
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
        return "Insurance_DTO{" + "name=" + name + ", insured=" + insured + ", price=" + price + '}';
    }
        
}
