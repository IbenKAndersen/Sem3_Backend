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

    public List<Order_DTO> getAllorders() {
        EntityManager em = getEntityManager();
        try {
            List<Order> orders = em.createNamedQuery("orders.findAll").getResultList();
            List<Order_DTO> result = new ArrayList();
            orders.forEach((order) -> {
                result.add(new Order_DTO(order));
            });
            return result;
        } finally {
            em.close();
        }
    }

    public Order addOrder1(Order order) {
        EntityManager em = getEntityManager();

        User user = new User(order.getUser().getUserName(), order.getUser().getUserPass());
        CarMake carMake = new CarMake(order.getOrderline().getCar().getCarMake().getName(),
                order.getOrderline().getCar().getCarMake().getCars_by_make(),
                order.getOrderline().getCar().getCarMake().getModels_of_make());
        CarModel carModel = new CarModel(order.getOrderline().getCar().getCarModel().getModel_of_car(),
                carMake, order.getOrderline().getCar().getCarModel().getName());
        Car car = new Car(carMake, carModel, order.getOrderline().getCar().getCarDetails());
        Location location = new Location(order.getOrderline().getLocation().getAddress(), order.getOrderline().getLocation().getCoord());
        Insurance insurance = new Insurance(order.getOrderline().getInsurance().isInsurance(), order.getOrderline().getInsurance().getPrice());
        Equipment equipment = new Equipment(order.getOrderline().getEquipment().getName(), order.getOrderline().getEquipment().getPrice());
        List<Equipment> equipmentList = new ArrayList(order.getOrderline().getEquipmentList());
        equipmentList.add(equipment);
        OrderLine orderLine = new OrderLine(car, insurance, location, equipmentList, order.getOrderline().getRentalPeriodStart(), order.getOrderline().getRentalPeriodEnd());
        List<OrderLine> ol = new ArrayList(order.getOl());
        ol.add(orderLine);
        Order finalOrder = new Order(user, ol, order.getD());
        try {
            em.getTransaction().begin();
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
}
