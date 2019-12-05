package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Car_DTO;
import dto.Equipment_DTO;
import dto.Insurance_DTO;
import dto.Location_DTO;
import entities.Car;
import entities.Equipment;
import entities.Insurance;
import entities.Location;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author ndupo
 */
@Path("all")
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
    public Response addCar(String car) {
        Car car1 = GSON.fromJson(car, Car.class);
        Car_DTO carFinal = new Car_DTO(FACADE.addCar(car1));
        return Response.ok(carFinal).build();
    }
    
    @Path("cars")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllCars() {
        List<Car> cars = FACADE.getAllCars();
        List<Car_DTO> cDtos = new ArrayList();
        
        cars.forEach((c) -> {
            cDtos.add(new Car_DTO(c));
        });
        return GSON.toJson(cDtos);
    }
    
    @Path("locations")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllLocations() {
        List<Location> locations = FACADE.getAllLocations();
        List<Location_DTO> lsDto = new ArrayList();
        
        locations.forEach((l) -> {
            lsDto.add(new Location_DTO(l));
        });
        return GSON.toJson(lsDto);
    }
    
        @Path("equipment")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllEquipment() {
        List<Equipment> equipment = FACADE.getAllEquipment();
        List<Equipment_DTO> esDto = new ArrayList();
        
        equipment.forEach((e) -> {
            esDto.add(new Equipment_DTO(e));
        });
        return GSON.toJson(esDto);
    }
    
            @Path("insurance")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getInsurance() {
        List<Insurance> insurance = FACADE.getInsurance();
        List<Insurance_DTO> iDto = new ArrayList();
        
        insurance.forEach((i) -> {
            iDto.add(new Insurance_DTO(i));
        });
        return GSON.toJson(iDto);
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
