package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Car_DTO;
import dto.Car_DTO_IN;
import facades.OrderFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author ndupo
 */
@Path("order")
public class OrderResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final OrderFacade FACADE =  OrderFacade.getOrderFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OrderResource
     */
    public OrderResource() {
    }

    /**
     * Retrieves representation of an instance of rest.OrderResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
//    @POST
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response addCar(String car1) {
//        Car_DTO_IN newCar = GSON.fromJson(car1, Car_DTO_IN.class);
//        Car_DTO car = FACADE.addCar(newCar);
//        return Response.ok(car).build();
//    }

    /**
     * PUT method for updating or creating an instance of OrderResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    /**
     * DELETE method for deleting an Order from the database
     * @param orderId
     * @return JSON
     */
    @Path("/{orderId}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String deleteOrder(@PathParam("orderId") String orderId) {
        return GSON.toJson(FACADE.cancelOrder((int) Integer.parseInt(orderId)));
    }
}
