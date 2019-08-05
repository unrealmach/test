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

import test.controllers.services.MCompraServiceImpl;
import test.controllers.services.MVentaServiceImpl;
import test.model.dao.ArticuloDao;
import test.model.dao.DVentaDao;
import test.model.dao.MVentaDao;
import test.models.entities.Articulo;
import test.models.entities.DCompra;
import test.models.entities.DVenta;
import test.models.entities.MCompra;
import test.models.entities.MVenta;

@RequestScoped
@Path("mcompra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MCompraController {

	@Inject 
	MCompraServiceImpl  mCompraServiceImpl;

	@GET
	public Response getAll() {
		return Response.ok(mCompraServiceImpl.findAll()).build();
	}
	

    @GET
    @Path("{id}")
    public Response getOne(@PathParam("id") Integer id) {
        return Response.ok(mCompraServiceImpl.findOne(id)).build();
    }

    @PUT
    @Path("{id}")
    public Response updateAll(@PathParam("id") Integer id, MCompra mCompra,List<DCompra> dCompra) {
    	mCompraServiceImpl.updateAll(id,mCompra, dCompra);
        return Response.ok().build();
    }

    @POST
    public Response create(MCompra mCompra, List<DCompra> dCompra) {
    	mCompraServiceImpl.saveAll(mCompra, dCompra);
        return Response.ok().build();
    }

   
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        mCompraServiceImpl.delete(id);
        return Response.ok().build();
    }
}
