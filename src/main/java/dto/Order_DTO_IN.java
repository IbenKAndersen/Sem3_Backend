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
public class Order_DTO_IN {

    private int id;
    private User_DTO_IN user;
    private List<Orderline_DTO_IN> ol;
    private Orderline_DTO_IN orderline;
    private Date d;

    public Order_DTO_IN() {
    }

    public Order_DTO_IN(Order order) {
        this.id = order.getId();
        this.user = new User_DTO_IN(order.getUser());
        if (order.getOl() != null) {
            for (OrderLine ol : order.getOl()) {
                this.ol.add(new Orderline_DTO_IN(ol));
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

    public User_DTO_IN getUser() {
        return user;
    }

    public void setUser(User_DTO_IN user) {
        this.user = user;
    }

    public List<Orderline_DTO_IN> getOl() {
        return ol;
    }

    public void setOl(List<Orderline_DTO_IN> ol) {
        this.ol = ol;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public Orderline_DTO_IN getOrderline() {
        return orderline;
    }

    public void setOrderline(Orderline_DTO_IN orderline) {
        this.orderline = orderline;
    }
    
}
