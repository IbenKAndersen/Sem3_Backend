package facades;

import entities.Booking;
import utils.EMF_Creator;
import entities.Role;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class RentalFacadeTest {

    private static EntityManagerFactory EMF;
    private static RentalFacade FACADE;

    public RentalFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        EMF = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
        FACADE = RentalFacade.getRentalFacade(EMF);
    }

    @AfterAll
    public static void tearDownClass() {
        //Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = EMF.createEntityManager();

        try {
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
            Booking booking2 = new Booking();
            List<Booking> list = new ArrayList();
            list.add(booking1);
            list.add(booking2);
            user1.setBookings(list);
            booking1.setUser(user1);
            booking2.setUser(user1);
            em.persist(booking1);
            em.persist(booking2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
        //Drop-and-create strategy used.
    }
    
    @Test
    public void testGetAllBookings() {
        //Arrange
        int expResult = 2;
        //Act
        
        //int result = FACADE.
    }

}
