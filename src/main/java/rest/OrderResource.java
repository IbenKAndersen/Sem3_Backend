package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Car_DTO;
import dto.Car_DTO_IN;
import dto.Order_DTO;
import entities.Order;
import facades.OrderFacade;
import java.util.ArrayList;
import java.util.List;
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

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addOrder(String order) {
        Order newOrder = GSON.fromJson(order, Order.class);
        Order_DTO finalOrder = new Order_DTO(FACADE.addOrder1(newOrder));
        return Response.ok(finalOrder).build();
    }
    
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll() {
        List<Order> order = FACADE.getAllOrders();
        List<Order_DTO> odto = new ArrayList();
        
        for(Order o : order) {
        odto.add(new Order_DTO(o));
        }
        return GSON.toJson(odto);
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
