package utils;

import entities.Car;
import entities.Booking;
import entities.Location;
import entities.OrderLine;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * 
 * @author mikkel
 * For testing only!!!
 */
public class SetupTestUsers {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        //Create Location Entity
        Location location1 = new Location();
        location1.setAddress("Mikkel Kornvalles er en idiotvej 123 ");
        location1.setCoord("237164.213215");
        em.persist(location1);
        
        
        //Create Cars Entities
//        Car car1 = new Car();
//        car1.setCarDetails("Some details...");
//        
//        Car car2 = new Car();
//        car2.setCarDetails("Some details...");
        
        Car car3 = new Car();
        car3.setCarDetails("Some details...");
        car3.setCarId(1);
        car3.setCarMake("BMW");
        car3.setCarModel("X5");
        car3.setTotalprice(100);
        car3.setLocation(location1);
        em.persist(car3);
        
        
        //Create OrderLines Entities
//        OrderLine orderline1 = new OrderLine();
//        orderline1.setCar(car1);
//        
//        OrderLine orderline2 = new OrderLine();
//        orderline2.setCar(car2);
        
        OrderLine orderline3 = new OrderLine();
        orderline3.setCar(car3);
        
        List<OrderLine> orderlines = new ArrayList();
//        orderlines.add(orderline1);
//        orderlines.add(orderline2);
        orderlines.add(orderline3);
        
        //Create Booking Entity
        Booking order1 = new Booking();
        order1.setOl(orderlines);
        
        em.persist(order1);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
