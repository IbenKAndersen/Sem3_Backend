/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Equipment;

/**
 *
 * @author ndupo
 */
public class Equipment_DTO {
    
    private int id;
    private String name;
    private int price;

    public Equipment_DTO() {
    }

    public Equipment_DTO(Equipment equipment) {
        this.id = equipment.getId();
        this.name = equipment.getName();
        this.price = equipment.getPrice();
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Equipment_DTO{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
    
    
    
}
