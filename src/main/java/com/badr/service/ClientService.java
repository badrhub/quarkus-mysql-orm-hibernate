package com.badr.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import com.badr.models.Client;

@Path("clients")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ClientService {

    @Inject
    EntityManager em ;

    @GET
    @Path("{code}")
    public Client getOne(@PathParam("code") Integer code ){
        Client c = em.find(Client.class, code);
        if(c == null){
            throw new WebApplicationException("le client avec le code " + code + " pas trouve" , 404);
        }
        return c;
    }

    @GET
    public List<Client> getAll(){
        return em.createQuery("select c from Client c",Client.class).getResultList();
    }

    @POST
    @Transactional
    public Response addClient(Client c){
      em.persist(c);
      return Response.ok(c).status(201).build();
    }

    @Path("{code}")
    @PUT
    @Transactional
    public Response updateClient(@PathParam("code") Integer code , Client nc){
        Client c = em.find(Client.class, code);
        if(c == null){
            throw new WebApplicationException("le client avec le code " + code + " pas trouve" , 404);
        }
        c.setNom(nc.getNom());
        c.setTel(nc.getTel());
        return Response.ok(c).status(204).build();
    }

    @Path("{code}")
    @DELETE
    @Transactional
    public Response deleteClient(@PathParam("code") Integer code){
        Client c = em.find(Client.class, code);
        if(c == null){
            throw new WebApplicationException("le client avec le code " + code + " pas trouve" , 404);
        }
        em.remove(c);
        return Response.status(204).build(); 
    }
}