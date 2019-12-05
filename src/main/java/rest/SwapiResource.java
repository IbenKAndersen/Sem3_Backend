package rest;

import facades.ApiFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Kodebanditterne
 */
@Path("swapi")
public class SwapiResource {

    private static final ApiFacade FACADE =  ApiFacade.getApiFacade();

    /**
     * Creates a new instance of SwapiResource
     */
    public SwapiResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "{\"msg\": \"Welcome to the Star Wars API!\"}";
    }

    @GET
    @Path("peoplelist")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonPeopleList() {
        String url = "https://swapi.co/api/";
        List<String> l = new ArrayList();
        l.add("people/1/");
        l.add("people/2/");
        l.add("people/3/");
        l.add("people/4/");
        l.add("people/5/");
        return FACADE.fetch(url, l).toString();
    }

    @GET
    @Path("planetlist")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonPlanetList() {
        String url = "https://swapi.co/api/";
        List<String> l = new ArrayList();
        l.add("planets/1/");
        l.add("planets/2/");
        l.add("planets/3/");
        l.add("planets/4/");
        l.add("planets/5/");
        return FACADE.fetch(url, l).toString();
    }

    @GET
    @Path("filmlist")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonStarshipList() {
        String url = "https://swapi.co/api/";
        List<String> l = new ArrayList();
        l.add("films/1/");
        l.add("films/2/");
        l.add("films/3/");
        l.add("films/4/");
        l.add("films/5/");
        return FACADE.fetch(url, l).toString();
    }

    @GET
    @Path("demoperson")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonPerson() {
        String url = "https://swapi.co/api/people/1";
        return FACADE.fetch(url);
    }

}
