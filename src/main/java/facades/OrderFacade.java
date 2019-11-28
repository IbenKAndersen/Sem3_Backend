package facades;

import dto.Car_DTO;
import dto.Car_DTO_IN;
import dto.Order_DTO;
import dto.Order_DTO_IN;
import entities.Car;
import entities.CarMake;
import entities.CarModel;
import entities.Order;
import entities.OrderLine;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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

    public Order_DTO addOrder(Order_DTO_IN newOrder) {
        EntityManager em = getEntityManager();
        User user = new User(newOrder.getUser().getUserName(), newOrder.getUser().getUserPass());
        CarMake carMake = new CarMake(newOrder.getOrderline().getCar().getCarMake().getName(),
                                      newOrder.getOrderline().getCar().getCarMake().getCars_by_make(),
                                      newOrder.getOrderline().getCar().getCarMake().getModels_of_make());
        CarModel carModel = new CarModel(newOrder.getOrderline().getCar().getCarModel().getModel_of_car(), 
                                        carMake, newOrder);
        OrderLine orderline = new OrderLine(car, order, insurance, location, equipment, rentalPeriodStart, rentalPeriodEnd)
        List<OrderLine> orderlines = new ArrayList();
        orderlines.add(orderline);
        try {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
            return new Order_DTO(order);
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

}
