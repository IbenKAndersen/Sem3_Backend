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
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mikkel For testing only!!!
 */
public class SetupTestUsers {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.DROP_AND_CREATE);
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
        CarMake carMake4 = new CarMake();
        carMake4.setName("Mitsubishi");
        CarMake carMake5 = new CarMake();
        carMake5.setName("Dodge");
        CarMake carMake6 = new CarMake();
        carMake6.setName("Aston Martin");

        //Create Car Model Entities
        CarModel carModel1 = new CarModel();
//        carModel1.setMake(carMake1);
        carModel1.setName("911");
        CarModel carModel2 = new CarModel();
//        carModel2.setMake(carMake2);
        carModel2.setName("Focus");
        CarModel carModel3 = new CarModel();
//        carModel3.setMake(carMake3);
        carModel3.setName("Civic");
        CarModel carModel4 = new CarModel();
//        carModel1.setMake(carMake1);
        carModel4.setName("Gallant");
        CarModel carModel5 = new CarModel();
//        carModel1.setMake(carMake1);
        carModel5.setName("Charger");
        CarModel carModel6 = new CarModel();
//        carModel1.setMake(carMake1);
        carModel6.setName("Wrom wrom");

        //Create Cars Entities
        Car car1 = new Car();
        car1.setCarMake(carMake1);
        car1.setCarModel(carModel1);
        car1.setCarDetails("Not family friendly");

        Car car2 = new Car();
        car2.setCarMake(carMake2);
        car2.setCarModel(carModel2);
        car2.setCarDetails("Family friendly");

        Car car3 = new Car();
        car3.setCarMake(carMake3);
        car3.setCarModel(carModel3);
        car3.setCarDetails("Family friendly");

        Car car4 = new Car();
        car4.setCarMake(carMake4);
        car4.setCarModel(carModel4);
        car4.setCarDetails("Family friendly");

        Car car5 = new Car();
        car5.setCarMake(carMake5);
        car5.setCarModel(carModel5);
        car5.setCarDetails("Not family friendly");

        Car car6 = new Car();
        car6.setCarMake(carMake6);
        car6.setCarModel(carModel6);
        car6.setCarDetails("Not family friendly");

        //Create Location Entities
        Location location1 = new Location();
        location1.setAddress("Københavns Lufthavn");
        location1.setCoord("55.629953, 12.637484");

        Location location2 = new Location();
        location2.setAddress("Copenhagen Central Station");
        location2.setCoord("55.672388, 12.563445");

        Location location3 = new Location();
        location3.setAddress("Malmoe centrum");
        location3.setCoord("55.608510, 12.999255");

        Location location4 = new Location();
        location4.setAddress("Lyngby");
        location4.setCoord("55.768400, 12.504070");

        Location location5 = new Location();
        location5.setAddress("Vanløse Storcenter");
        location5.setCoord("55.691541, 12.480927");

        Location location6 = new Location();
        location6.setAddress("Frederiksberg have");
        location6.setCoord("55.675132, 12.519569");

        // Set Cars on Location
        car1.setLocation(location1);
        car2.setLocation(location2);
        car3.setLocation(location3);
        car4.setLocation(location4);
        car5.setLocation(location5);
        car6.setLocation(location6);

        //Create Insurance Entity
        Insurance insurance1 = new Insurance();
        insurance1.setInsurance(true);
        insurance1.setPrice(500);

        Insurance insurance2 = new Insurance();
        insurance2.setInsurance(false);
        insurance2.setPrice(0);

        // Create Equipment Entity
        Equipment eq1 = new Equipment();
        eq1.setName("GPS");
        eq1.setPrice(100);

        Equipment eq2 = new Equipment();
        eq2.setName("Child Seat");
        eq2.setPrice(50);

        Equipment eq3 = new Equipment();
        eq3.setName("Apple CarPlay");
        eq3.setPrice(200);

        Equipment eq4 = new Equipment();
        eq4.setName("Entertainment System");
        eq4.setPrice(200);

        Equipment eq5 = new Equipment();
        eq5.setName("Cooler");
        eq5.setPrice(50);

        Equipment eq6 = new Equipment();
        eq6.setName("WiFi");
        eq6.setPrice(100);

        Equipment eq7 = new Equipment();
        eq7.setName("Extra Driver");
        eq7.setPrice(500);

        Equipment eq8 = new Equipment();
        eq8.setName("BroBizz");
        eq8.setPrice(50);

        Equipment eq9 = new Equipment();
        eq9.setName("Triple A");
        eq9.setPrice(50);

        em.persist(car1);
        em.persist(car2);
        em.persist(car3);
        em.persist(car5);
        em.persist(car6);
        em.persist(eq1);
        em.persist(eq2);
        em.persist(eq3);
        em.persist(eq4);
        em.persist(eq5);
        em.persist(eq6);
        em.persist(eq7);
        em.persist(eq8);
        em.persist(eq9);
        em.persist(location1);
        em.persist(location2);
        em.persist(location3);
        em.persist(location4);
        em.persist(location5);
        em.persist(location6);
        em.persist(insurance1);
        em.persist(insurance2);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
