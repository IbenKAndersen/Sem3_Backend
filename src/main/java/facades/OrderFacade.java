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

    public Order addOrder1(Order order) {
        EntityManager em = getEntityManager();

        List<OrderLine> orderslines = order.getOl();
        for (OrderLine ordersline : orderslines) {
            OrderLine orderLine = new OrderLine(ordersline.getCar(),
                    ordersline.getInsurance(),
                    ordersline.getLocation(),
                    ordersline.getEquipmentList(),
                    ordersline.getRentalPeriodStart(),
                    ordersline.getRentalPeriodEnd());
            orderslines.add(orderLine);
            Order finalOrder = new Order(order.getUser(), orderslines, order.getD());
            try {
                em.getTransaction().begin();
                em.persist(orderslines);
                em.persist(finalOrder);
                em.getTransaction().commit();
                return finalOrder;
            } catch (Exception e) {
                em.getTransaction().rollback();
                return null;
            } finally {
                em.close();
            }
        }
        return null;

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

//    public void addCar(Car car) {
//        EntityManager em = getEntityManager();
//
//        try {   
//            if(car.getCarModel().getName() = em.find(Car.class, car) ){
//                
//            }
//            
//
//        } catch(Exception e)  {
//            System.out.println(e.getMessage());
//        }
//    }

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
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
