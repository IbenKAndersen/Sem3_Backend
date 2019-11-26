package facades;

import entities.Booking;
import entities.RenameMe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Kodebanditterne
 */
public class RentalFacade {

    private static RentalFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private RentalFacade(){}
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade.
     */
    public static RentalFacade getRentalFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RentalFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    private Booking MakeBooking() {
        EntityManager em = getEntityManager();
        
        
        return null;
    }
    
}
