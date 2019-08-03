package test.controllers.rest;

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

import test.controllers.services.ArticuloServiceImpl;
import test.model.dao.ArticuloDao;
import test.models.entities.Articulo;

@RequestScoped
@Path("articulos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArticuloController {

	@Inject
	ArticuloDao articuloDao;
	
	@Inject
	ArticuloServiceImpl articuloService;

	@GET
	public Response getAll() {
		return Response.ok(articuloService.findAll()).build();
	}
	

    @GET
    @Path("{id}")
    public Response getOne(@PathParam("id") Integer id) {
        Articulo articulo = articuloService.findOne(id);
        return Response.ok(articulo).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Integer id, Articulo articulo) {
    	articuloService.update(id,articulo);
        return Response.ok().build();
    }

    @POST
    public Response create(Articulo articulo) {
    	articuloService.save(articulo);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        articuloService.delete(id);

        return Response.ok().build();
    }
}
