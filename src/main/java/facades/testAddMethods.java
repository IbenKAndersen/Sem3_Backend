/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Car;
import entities.CarMake;
import entities.CarModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author ndupo
 */
public class testAddMethods {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.NONE);
    private static final OrderFacade FACADE =  OrderFacade.getOrderFacade(EMF);
    private static EntityManagerFactory emf;
    private static OrderFacade instance;

    public static OrderFacade getOrderFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new OrderFacade();
        }
        return instance;
    }
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        EntityManager em = emf.createEntityManager();

        System.out.println(FACADE.fetchCar(1));
        
        System.out.println(FACADE.getAllCars());
        
        CarMake carMake1 = new CarMake();
        carMake1.setName("Dodge");
        CarModel carModel1 = new CarModel();
        carModel1.setMake(carMake1);
        carModel1.setName("Gallant");
        CarModel carModel2 = new CarModel();
        carModel2.setMake(carMake1);
        carModel2.setName("Gallante");
        Car car1 = new Car();
        car1.setCarMake(carMake1);
        car1.setCarModel(carModel1);
        car1.setCarDetails("Some details...");
        Car car2 = new Car();
        car2.setCarMake(carMake1);
        car2.setCarModel(carModel1);
        car2.setCarDetails("Some details...");
        FACADE.addCar(car1);
        FACADE.addCar(car2);

        
    }
}
