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

import test.controllers.services.MVentaImpl;
import test.model.dao.ArticuloDao;
import test.model.dao.DVentaDao;
import test.model.dao.MVentaDao;
import test.models.entities.Articulo;
import test.models.entities.DVenta;
import test.models.entities.MVenta;

@RequestScoped
@Path("mventa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MVentaController {

	@Inject 
	MVentaImpl  mVentaImpl;

	@GET
	public Response getAll() {
		return Response.ok(mVentaImpl.findAll()).build();
	}
	

    @GET
    @Path("{id}")
    public Response getOne(@PathParam("id") Integer id) {
        return Response.ok(mVentaImpl.findOne(id)).build();
    }

    @PUT
    @Path("{id}")
    public Response updateAll(@PathParam("id") Integer id, MVenta mVenta,List<DVenta> dVenta) {
    	mVentaImpl.updateAll(id,mVenta, dVenta);
        return Response.ok().build();
    }

    @POST
    public Response create(MVenta mventa, List<DVenta> dventa) {
    	mVentaImpl.saveAll(mventa, dventa);
        return Response.ok().build();
    }

   
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        mVentaImpl.delete(id);
        return Response.ok().build();
    }
}
