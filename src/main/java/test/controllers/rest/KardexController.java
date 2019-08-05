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

import test.controllers.services.KardexServiceImpl;
import test.controllers.services.MVentaServiceImpl;
import test.model.dao.ArticuloDao;
import test.model.dao.DVentaDao;
import test.model.dao.MVentaDao;
import test.models.entities.Articulo;
import test.models.entities.DVenta;
import test.models.entities.MVenta;

@RequestScoped
@Path("kardex")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KardexController {

	@Inject 
	KardexServiceImpl  kardexServiceImpl;

	@GET
	public Response getAll() {
		return Response.ok(kardexServiceImpl.findAll()).build();
	}
	
    @GET
    @Path("{id}")
    public Response getOne(@PathParam("id") Integer id) {
        return Response.ok(kardexServiceImpl.findOne(id)).build();
    }

}
