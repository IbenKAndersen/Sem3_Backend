/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Car_DTO;
import dto.Car_DTO_IN;
import dto.Order_DTO;
import entities.Order;
import facades.OrderFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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
    
        private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/SEM3",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final OrderFacade FACADE =  OrderFacade.getFacadeExample(EMF);
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
    
        @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addCar(String car1) {
            Car_DTO_IN newCar = GSON.fromJson(car1, Car_DTO_IN.class);
        Car_DTO car = FACADE.addCar(newCar);
        return Response.ok(car).build();
    }

    /**
     * PUT method for updating or creating an instance of OrderResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
