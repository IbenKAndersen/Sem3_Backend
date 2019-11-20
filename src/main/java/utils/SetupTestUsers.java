package utils;

import entities.Booking;
import entities.User;
import entities.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * 
 * @author mikkel
 * For testing only!!!
 */
public class SetupTestUsers {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        //Create Role Entity
        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        em.persist(userRole);
        em.persist(adminRole);
        
        //Create User Entity
        User user1 = new User();
        user1.setUserName("Benni");
        user1.setUserPass("test1");
        user1.addRole(userRole);
        em.persist(user1);
        
        User admin1 = new User();
        admin1.setUserName("Nick");
        admin1.setUserPass("test2");
        admin1.addRole(adminRole);
        em.persist(admin1);
        
        //Create Booking Entity
        Booking booking1 = new Booking();
        booking1.setUser(user1);
        em.persist(booking1);
        
        em.getTransaction().commit();
        
        
        Booking found = (Booking) em.find(Booking.class, 1);
        System.out.println("------------------------------");
        System.out.println(found.getUser().getUserName());
        System.out.println("------------------------------");
        
        em.close();
        emf.close();
        
    }

}
