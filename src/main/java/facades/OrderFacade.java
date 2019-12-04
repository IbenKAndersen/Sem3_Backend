package facades;

import dto.Car_DTO;
import dto.Car_DTO_IN;
import dto.Order_DTO;
import dto.Order_DTO_IN;
import entities.Car;
import entities.CarMake;
import entities.CarModel;
import entities.Equipment;
import entities.Insurance;
import entities.Location;
import entities.Order;
import entities.OrderLine;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author ndupo
 */
public class OrderFacade {

    private static EntityManagerFactory emf;
    private static OrderFacade instance;

    public static OrderFacade getOrderFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new OrderFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public OrderFacade() {
    }

//    List<Person> query = em.createNamedQuery("Person.getByName").setParameter("firstName", firstName).getResultList();
//            List<PersonDTO_OUT> result = new ArrayList();
//            for (Person person : query) {
//                result.add(new PersonDTO_OUT(person));
//            }
//            return result;
//            
    public Car fetchCar(int car_id) {
        EntityManager em = getEntityManager();
        Car car = (Car) em.find(Car.class, car_id);
        try {
            if (car.getCarId() == car_id) {
                System.out.println("Fetching car from database...");
                System.out.println(car.toString());
                return car;

            } else {
                System.out.println("Car doesn't exist in database...");
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Order fetchOrder(int order_id) {
        EntityManager em = getEntityManager();
        Order order = (Order) em.find(Order.class, order_id);
        try {
            if (order.getId() == order_id) {
                System.out.println("Fetching order from database...");
                System.out.println(order.toString());
                return order;

            } else {
                System.out.println("Order doesn't exist in database...");
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Car addCar(Car car) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean cancelOrder(int orderId) {
        EntityManager em = getEntityManager();
        Order order = (Order) em.find(Order.class, orderId);
        try {
            em.getTransaction().begin();
            em.remove(order);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<Order> getAllOrders() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o", Order.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Car> getAllCars() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Car> query = em.createQuery("SELECT c FROM Car c", Car.class);
            System.out.println("Fetching list of cars from database...");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Location> getAllLocations() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Location> query = em.createQuery("SELECT l FROM Location l", Location.class);
            System.out.println("Fetching list of locations from database...");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Equipment> getAllEquipment() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Equipment> query = em.createQuery("SELECT e FROM Equipment e", Equipment.class);
            System.out.println("Fetching list of Equipment from database...");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Insurance> getInsurance() {
               EntityManager em = getEntityManager();
        try {
            TypedQuery<Insurance> query = em.createQuery("SELECT i FROM Insurance i", Insurance.class);
            System.out.println("Fetching list of insurances from database...");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
