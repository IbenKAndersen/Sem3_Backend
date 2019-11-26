package utils;

import entities.Car;
import entities.Order;
import entities.OrderLine;
import entities.Role;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mikkel For testing only!!!
 */
public class SetupTestUsers {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Create Cars Entities
        Car car1 = new Car();
        car1.setCarDetails("Some details...");

        Car car2 = new Car();
        car2.setCarDetails("Some details...");

        Car car3 = new Car();
        car3.setCarDetails("Some details...");

        //Create OrderLines Entities
        OrderLine orderline1 = new OrderLine();
        orderline1.setCar(car1);

        OrderLine orderline2 = new OrderLine();
        orderline2.setCar(car2);

        OrderLine orderline3 = new OrderLine();
        orderline3.setCar(car3);

        List<OrderLine> orderlines = new ArrayList();
        orderlines.add(orderline1);
        orderlines.add(orderline2);
        orderlines.add(orderline3);

        //Create Booking Entity
        Order order1 = new Order();
        order1.setOl(orderlines);
        em.persist(order1);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
        
    User user = new User("user", "test1");
    User admin = new User("admin", "test2");
    User both = new User("user_admin", "test3");

    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test1"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test"));
    System.out.println("Created TEST Users");
   
    }

}
