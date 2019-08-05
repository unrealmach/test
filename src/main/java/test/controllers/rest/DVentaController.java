package test.controllers.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import test.controllers.services.DVentaServiceImpl;
import test.model.dao.DVentaDao;
import test.model.dao.MVentaDao;
import test.models.entities.DVenta;
import test.models.entities.MVenta;

@RequestScoped
@Path("dventa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DVentaController {
	
	@Inject
	DVentaServiceImpl dVentaServiceImpl;

	@GET
	public Response getAll() {
		return Response.ok(dVentaServiceImpl.findAll()).build();
	}
	

    @GET
    @Path("{id}")
    public Response getOne(@PathParam("id") Integer id) {
        return Response.ok(dVentaServiceImpl.findOne(id)).build();
    }

    @PUT
    @Path("{id}")
    public Response updateAll(@PathParam("id") Integer id,DVenta dVenta) {
    	dVentaServiceImpl.update(id,dVenta);
        return Response.ok().build();
    }
    
  
    @POST
    public Response create(List<DVenta> dventa) {
    	dVentaServiceImpl.saveListDVenta(dventa);
        return Response.ok().build();
    }

   
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
    	dVentaServiceImpl.delete(id);
        return Response.ok().build();
    }
	
}
