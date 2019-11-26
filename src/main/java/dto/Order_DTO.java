/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Order;
import entities.OrderLine;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ndupo
 */
public class Order_DTO {

    private int id;
    private User_DTO user;
    private List<Orderline_DTO> ol;
    private Date d;

    public Order_DTO() {
    }

    public Order_DTO(Order order) {
        this.id = order.getId();
        this.user = new User_DTO(order.getUser());
        if (order.getOl() != null) {
            for (OrderLine ol : order.getOl()) {
                this.ol.add(new Orderline_DTO(ol));
            }
        }
        this.d = order.getD();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User_DTO getUser() {
        return user;
    }

    public void setUser(User_DTO user) {
        this.user = user;
    }

    public List<Orderline_DTO> getOl() {
        return ol;
    }

    public void setOl(List<Orderline_DTO> ol) {
        this.ol = ol;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Order_DTO{" + "id=" + id + ", user=" + user + ", ol=" + ol + ", d=" + d + '}';
    }
    
    
}
