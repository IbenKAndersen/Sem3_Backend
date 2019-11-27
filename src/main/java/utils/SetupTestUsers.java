package utils;

import entities.Car;
import entities.Equipment;
import entities.CarMake;
import entities.CarModel;
import entities.Insurance;
import entities.Location;
import entities.Order;
import entities.OrderLine;
import entities.User;
import entities.Role;
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

        User user = new User("user", "test1");
        User admin = new User("admin", "test2");
        User both = new User("user_admin", "test3");

        if (admin.getUserPass().equals("test") || user.getUserPass().equals("test") || both.getUserPass().equals("test")) {
            throw new UnsupportedOperationException("You have not changed the passwords");
        }

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

        em.getTransaction().begin();

        //Create Car Brands Entities
        CarMake carMake1 = new CarMake();
        carMake1.setName("Porche");
        CarMake carMake2 = new CarMake();
        carMake2.setName("Ford");
        CarMake carMake3 = new CarMake();
        carMake3.setName("Honda");

        //Create Car Model Entities
        CarModel carModel1 = new CarModel();
        carModel1.setMake(carMake1);
        carModel1.setName("911");
        CarModel carModel2 = new CarModel();
        carModel2.setMake(carMake2);
        carModel2.setName("Focus");
        CarModel carModel3 = new CarModel();
        carModel3.setMake(carMake3);
        carModel3.setName("Civic");

        //Create Cars Entities
        Car car1 = new Car();
        car1.setCarMake(carMake1);
        car1.setCarModel(carModel1);
        car1.setCarDetails("Some details...");

        Car car2 = new Car();
        car2.setCarMake(carMake2);
        car2.setCarModel(carModel2);
        car2.setCarDetails("Some details...");

        Car car3 = new Car();
        car3.setCarMake(carMake3);
        car3.setCarModel(carModel3);
        car3.setCarDetails("Some details...");

        //Create Cars on Location 
        List<Car> carsOnLocation1 = new ArrayList();
        carsOnLocation1.add(car1);
        
        List<Car> carsOnLocation2 = new ArrayList();
        carsOnLocation2.add(car2);
        
        List<Car> carsOnLocation3 = new ArrayList();
        carsOnLocation3.add(car3);
        
        //Create Location Entities
        Location location1 = new Location();
        location1.setAddress("Some Address");
        location1.setCoord("Some Coordinates");
        location1.setCars_on_location(carsOnLocation1);
        
        Location location2 = new Location();
        location2.setAddress("Some Address");
        location2.setCoord("Some Coordinates");
        location2.setCars_on_location(carsOnLocation2);
        
        Location location3 = new Location();
        location3.setAddress("Some Address");
        location3.setCoord("Some Coordinates");
        location2.setCars_on_location(carsOnLocation3);

        // Set Cars on Location
        car1.setLocation(location1);
        car2.setLocation(location2);
        car3.setLocation(location3);

        //Create Insurance Entity
        Insurance insurance1 = new Insurance();
        insurance1.setInsurance(true);
        insurance1.setPrice(500);
        
        Insurance insurance2 = new Insurance();
        insurance2.setInsurance(false);
        insurance2.setPrice(500);
        
        Insurance insurance3 = new Insurance();
        insurance3.setInsurance(false);
        insurance3.setPrice(500);

        // Create Equipment Entity
        Equipment eq1 = new Equipment();
        eq1.setName("GPS");
        eq1.setPrice(100);
        
        //List of Equipment
        List<Equipment> eqPack = new  ArrayList();
        eqPack.add(eq1);
        
        //Create OrderLines Entities
        OrderLine orderline1 = new OrderLine();
        orderline1.setCar(car1);
        orderline1.setLocation(location1);
        orderline1.setInsurance(insurance1);
        orderline1.setEquipment(eqPack);
        orderline1.setRentalPeriodStart("2019-11-21T23:00:00.000Z");
        orderline1.setRentalPeriodEnd("2019-11-30T22:59:59.999Z");

        OrderLine orderline2 = new OrderLine();
        orderline2.setCar(car2);
        orderline2.setLocation(location2);
        orderline2.setInsurance(insurance2);
        orderline2.setEquipment(eqPack);
        orderline2.setRentalPeriodStart("2019-11-19T23:00:00.000Z");
        orderline2.setRentalPeriodEnd("2019-11-21T22:59:59.999Z");

        OrderLine orderline3 = new OrderLine();
        orderline3.setCar(car3);
        orderline3.setLocation(location3);
        orderline3.setInsurance(insurance3);
        orderline3.setEquipment(eqPack);
        orderline3.setRentalPeriodStart("2019-11-01T23:00:00.000Z");
        orderline3.setRentalPeriodEnd("2019-11-04T22:59:59.999Z");

        List<OrderLine> orderlines = new ArrayList();
        orderlines.add(orderline1);
        orderlines.add(orderline2);
        orderlines.add(orderline3);

        //Create Booking Entity
        Order order1 = new Order();
        order1.setOl(orderlines);
        order1.setUser(user);
        em.persist(order1);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
