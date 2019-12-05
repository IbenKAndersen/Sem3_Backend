package utils;

import entities.Car;
import entities.Equipment;
import entities.CarMake;
import entities.CarModel;
import entities.Insurance;
import entities.Location;
import entities.User;
import entities.Role;
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
        CarMake carMakePorsche = new CarMake();
        carMakePorsche.setName("Porsche");
        
        CarMake carMakeFord = new CarMake();
        carMakeFord.setName("Ford");
        
        CarMake carMakeHonda = new CarMake();
        carMakeHonda.setName("Honda");
        
        CarMake carMakeMitsubishi = new CarMake();
        carMakeMitsubishi.setName("Mitsubishi");
        
        CarMake carMakeDodge = new CarMake();
        carMakeDodge.setName("Dodge");
        
        CarMake carMakeAstonMartin = new CarMake();
        carMakeAstonMartin.setName("Aston Martin");
        
        CarMake carMakeTesla = new CarMake();
        carMakeTesla.setName("Tesla");
        
        CarMake carMakeToyota = new CarMake();
        carMakeToyota.setName("Toyota");

        //Create Car Model Entities
        // Porsche Models
        CarModel s911 = new CarModel();
        s911.setName("911");
        CarModel boxster = new CarModel();
        boxster.setName("Boxster");
        CarModel panamera = new CarModel();
        panamera.setName("Panamera");
        CarModel cayman = new CarModel();
        cayman.setName("Cayman");
        
        // Ford Models
        CarModel focus = new CarModel();
        focus.setName("Focus");
        CarModel mondeo = new CarModel();
        mondeo.setName("Mondeo");
        CarModel f50 = new CarModel();
        f50.setName("F50");
        
        // Honda Models
        CarModel civic = new CarModel();
        civic.setName("Civic");
        CarModel jazz = new CarModel();
        jazz.setName("Jazz");
        CarModel s2000 = new CarModel();
        s2000.setName("s2000");
        CarModel nsx = new CarModel();
        nsx.setName("NSX");
        
        // Mitsubishi Models
        CarModel gallant = new CarModel();
        gallant.setName("Gallant");
        CarModel evolution = new CarModel();
        evolution.setName("Evolution");
        
        // Dodge Models
        CarModel charger = new CarModel();
        charger.setName("Charger");
        CarModel challenger = new CarModel();
        challenger.setName("Challenger");
        CarModel viper = new CarModel();
        viper.setName("Viper");
        CarModel dart = new CarModel();
        dart.setName("Dart");
        
        // Aston Martin Models
        CarModel db11 = new CarModel();
        db11.setName("DB11");
        CarModel vantage = new CarModel();
        vantage.setName("Vantage");
        CarModel valkyrie = new CarModel();
        valkyrie.setName("Valkyrie");
        
        // Tesla Models
        CarModel model_S = new CarModel();
        model_S.setName("Model S");
        CarModel model_X = new CarModel();
        model_X.setName("Model X");
        CarModel Model_3 = new CarModel();
        Model_3.setName("Model 3");
        CarModel cybertruck = new CarModel();
        cybertruck.setName("Cybertruck");
        
        // Toyota
        CarModel corolla = new CarModel();
        corolla.setName("Corolla");
        CarModel prius = new CarModel();
        prius.setName("Prius");
        CarModel c_hr = new CarModel();
        c_hr.setName("C-HR");
        CarModel aygo = new CarModel();
        aygo.setName("Aygo");
        //Create Cars Entities
        
        // Porsche Collection
        Car car1 = new Car();
        car1.setCarMake(carMakePorsche);
        car1.setCarModel(boxster);
        car1.setCarDetails("Not family friendly");

        Car car2 = new Car();
        car2.setCarMake(carMakePorsche);
        car2.setCarModel(cayman);
        car2.setCarDetails("Not family friendly");
        
        Car car3 = new Car();
        car3.setCarMake(carMakePorsche);
        car3.setCarModel(panamera);
        car3.setCarDetails("Family friendly");
        
        Car car4 = new Car();
        car4.setCarMake(carMakePorsche);
        car4.setCarModel(s911);
        car4.setCarDetails("Not family friendly");

        // Ford Collection
        Car car5 = new Car();
        car5.setCarMake(carMakeFord);
        car5.setCarModel(mondeo);
        car5.setCarDetails("Family friendly");

        Car car6 = new Car();
        car6.setCarMake(carMakeFord);
        car6.setCarModel(focus);
        car6.setCarDetails("Family friendly");
        
        Car car7 = new Car();
        car7.setCarMake(carMakeFord);
        car7.setCarModel(f50);
        car7.setCarDetails("Family friendly");

        // Honda Collection
        Car car8 = new Car();
        car8.setCarMake(carMakeHonda);
        car8.setCarModel(s2000);
        car8.setCarDetails("Not family friendly");
        
        Car car9 = new Car();
        car9.setCarMake(carMakeHonda);
        car9.setCarModel(jazz);
        car9.setCarDetails("Family friendly");
        
        Car car10 = new Car();
        car10.setCarMake(carMakeHonda);
        car10.setCarModel(civic);
        car10.setCarDetails("Family friendly");
        
        Car car11 = new Car();
        car11.setCarMake(carMakeHonda);
        car11.setCarModel(nsx);
        car11.setCarDetails("Not family friendly");
        
        // Dodge Collection
        Car car12 = new Car();
        car12.setCarMake(carMakeDodge);
        car12.setCarModel(dart);
        car12.setCarDetails("Family friendly");
        
        Car car13 = new Car();
        car13.setCarMake(carMakeDodge);
        car13.setCarModel(challenger);
        car13.setCarDetails("Not family friendly");

        Car car14 = new Car();
        car14.setCarMake(carMakeDodge);
        car14.setCarModel(charger);
        car14.setCarDetails("Family friendly");
        
        Car car15 = new Car();
        car15.setCarMake(carMakeDodge);
        car15.setCarModel(viper);
        car15.setCarDetails("Not family friendly");
        
        // Aston Martin
        Car car16 = new Car();
        car16.setCarMake(carMakeAstonMartin);
        car16.setCarModel(valkyrie);
        car16.setCarDetails("Not family friendly");
        
        Car car17 = new Car();
        car17.setCarMake(carMakeAstonMartin);
        car17.setCarModel(vantage);
        car17.setCarDetails("Not family friendly");
        
        Car car18 = new Car();
        car18.setCarMake(carMakeAstonMartin);
        car18.setCarModel(db11);
        car18.setCarDetails("Family friendly");
        
        // Tesla Collection
        Car car19 = new Car();
        car19.setCarMake(carMakeTesla);
        car19.setCarModel(Model_3);
        car19.setCarDetails("Family friendly");
        
        Car car20 = new Car();
        car20.setCarMake(carMakeTesla);
        car20.setCarModel(model_S);
        car20.setCarDetails("Family friendly");
        
        Car car21 = new Car();
        car21.setCarMake(carMakeTesla);
        car21.setCarModel(model_X);
        car21.setCarDetails("Family friendly");
        
        Car car22 = new Car();
        car22.setCarMake(carMakeTesla);
        car22.setCarModel(cybertruck);
        car22.setCarDetails("Family friendly");
        
        // Toyota Collection
        Car car23 = new Car();
        car23.setCarMake(carMakeToyota);
        car23.setCarModel(aygo);
        car23.setCarDetails("Semi family friendly");
        
        Car car24 = new Car();
        car24.setCarMake(carMakeToyota);
        car24.setCarModel(corolla);
        car24.setCarDetails("Family friendly");
        
        Car car25 = new Car();
        car25.setCarMake(carMakeToyota);
        car25.setCarModel(prius);
        car25.setCarDetails("Family friendly");
        
        Car car26 = new Car();
        car26.setCarMake(carMakeToyota);
        car26.setCarModel(c_hr);
        car26.setCarDetails("Family friendly");
        

        //Create Location Entities
        Location location1 = new Location();
        location1.setAddress("Copenhagen Airport T2");
        location1.setCoord("55.629953, 12.637484");

        Location location2 = new Location();
        location2.setAddress("Copenhagen Central Station");
        location2.setCoord("55.672388, 12.563445");

        Location location3 = new Location();
        location3.setAddress("Malmø Midtown");
        location3.setCoord("55.608510, 12.999255");

        Location location4 = new Location();
        location4.setAddress("Kongens Lyngby City Hall");
        location4.setCoord("55.768400, 12.504070");

        Location location5 = new Location();
        location5.setAddress("Vanløse Mall");
        location5.setCoord("55.691541, 12.480927");

        Location location6 = new Location();
        location6.setAddress("Frederiksberg Garden");
        location6.setCoord("55.675132, 12.519569");
        
        Location location7 = new Location();
        location7.setAddress("Stockholm Central Station");
        location7.setCoord("59.331215, 18.058206");
        
        Location location8 = new Location();
        location8.setAddress("Helsinki Mall");
        location8.setCoord("60.170562, 24.942227");
        
        Location location9 = new Location();
        location9.setAddress("London Marble Arch");
        location9.setCoord("51.513212, -0.160321");
        
        Location location10 = new Location();
        location10.setAddress("London Westminster");
        location10.setCoord("51.497039, -0.138996");
        
        Location location11 = new Location();
        location11.setAddress("Dublin Smithfield");
        location11.setCoord("53.346629, -6.280353");
        
        Location location12 = new Location();
        location12.setAddress("Billund Airport P1");
        location12.setCoord("55.747767, 9.143861");
        
        Location location13 = new Location();
        location13.setAddress("Billund Resort LEGOLAND");
        location13.setCoord("55.737208, 9.124908");

        Location location14 = new Location();
        location14.setAddress("Bornholm Aakirkeby");
        location14.setCoord("55.075613, 14.918001");
        
        Location location15 = new Location();
        location15.setAddress("Odense Midtown");
        location15.setCoord("55.393893, 10.383769");
        
        Location location16 = new Location();
        location16.setAddress("Flensburg Tarup");
        location16.setCoord("54.782299, 9.470083");
         
        Location location17 = new Location();
        location17.setAddress("Hamborg Überseeallee");
        location17.setCoord("53.541509, 9.997682");
        
        Location location18 = new Location();
        location18.setAddress("Hamborg Airport");
        location18.setCoord("53.634785, 10.006212");
        
        Location location19 = new Location();
        location19.setAddress("Berlin Alexanderplatz");
        location19.setCoord("52.522959, 13.414774");
        
        Location location20 = new Location();
        location20.setAddress("Oslo Central Station");
        location20.setCoord("59.910816, 10.749853");
        
        // Set Cars on Location
        car1.setLocation(location1);
        car2.setLocation(location2);
        car3.setLocation(location3);
        car4.setLocation(location4);
        car5.setLocation(location5);
        car6.setLocation(location7);
        car7.setLocation(location8);
        car8.setLocation(location6);
        car9.setLocation(location10);
        car10.setLocation(location11);
        car11.setLocation(location12);
        car12.setLocation(location13);
        car13.setLocation(location9);
        car14.setLocation(location14);
        car15.setLocation(location15);
        car16.setLocation(location16);
        car17.setLocation(location17);
        car18.setLocation(location18);
        car19.setLocation(location9);
        car20.setLocation(location19);
        car21.setLocation(location20);
        car22.setLocation(location18);
        car23.setLocation(location19);
        car24.setLocation(location16);
        car25.setLocation(location11);
        car26.setLocation(location3);

        //Create Insurance Entity
        Insurance standardInsurance = new Insurance();
        standardInsurance.setInsurance(true);
        standardInsurance.setPrice(500);
        standardInsurance.setName("Standard Insurance Package");

        Insurance insurance2 = new Insurance();
        insurance2.setInsurance(false);
        insurance2.setPrice(0);
        insurance2.setName("No insurance");
        
        Insurance insurancePlus = new Insurance();
        insurancePlus.setInsurance(true);
        insurancePlus.setPrice(750);
        insurancePlus.setName("Insurance+ Package");
        
        Insurance insuranceMax = new Insurance();
        insuranceMax.setInsurance(true);
        insuranceMax.setPrice(1000);
        insuranceMax.setName("Insurance Max");

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
        em.persist(car4);
        em.persist(car5);
        em.persist(car6);
        em.persist(car7);
        em.persist(car8);
        em.persist(car9);
        em.persist(car10);
        em.persist(car11);
        em.persist(car12);
        em.persist(car13);
        em.persist(car14);
        em.persist(car15);
        em.persist(car16);
        em.persist(car17);
        em.persist(car18);
        em.persist(car19);
        em.persist(car20);
        em.persist(car21);
        em.persist(car22);
        em.persist(car23);
        em.persist(car24);
        em.persist(car25);
        em.persist(car26);
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
        em.persist(location7);
        em.persist(location8);
        em.persist(location9);
        em.persist(location10);
        em.persist(location11);
        em.persist(location12);
        em.persist(location13);
        em.persist(location14);
        em.persist(location15);
        em.persist(location16);
        em.persist(location17);
        em.persist(location18);
        em.persist(location19);
        em.persist(location20);
        em.persist(insuranceMax);
        em.persist(insurance2);
        em.persist(insurancePlus);
        em.persist(standardInsurance);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
