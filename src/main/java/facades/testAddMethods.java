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
    
//    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
//    private static final OrderFacade FACADE =  OrderFacade.getOrderFacade(EMF);
//    private static EntityManagerFactory emf;
//    private static OrderFacade instance;
//
//    public static OrderFacade getOrderFacade(EntityManagerFactory _emf) {
//        if (instance == null) {
//            emf = _emf;
//            instance = new OrderFacade();
//        }
//        return instance;
//    }
//    
//    public static void main(String[] args) {
//            
//        
//        CarMake carMake1 = new CarMake();
//        carMake1.setName("Porche");
//        CarModel carModel1 = new CarModel();
//        carModel1.setMake(carMake1);
//        carModel1.setName("911");
//        Car car = new Car(carMake1, carModel1, "test.....");
//        FACADE.addCar(car);
//        
//    }
}
