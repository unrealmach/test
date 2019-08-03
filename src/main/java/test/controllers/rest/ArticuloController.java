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

import test.model.dao.ArticuloDao;
import test.models.entities.Articulo;
import test.models.entities.Todo;

@RequestScoped
@Path("articulos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArticuloController {

	@Inject
	ArticuloDao articuloDao;

	@GET
	public Response getAll() {
		return Response.ok(articuloDao.getAll()).build();
	}
	

    @GET
    @Path("{id}")
    public Response getOne(@PathParam("id") Long id) {
        Articulo todo = articuloDao.findById(id);
        return Response.ok(todo).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Articulo articulo) {
    	Articulo articuloTemp = articuloDao.findById(id);
    	articuloTemp.setCodigo(articulo.getCodigo());
    	articuloTemp.setNombre(articulo.getNombre());
    	articuloTemp.setPrecioCompra(articulo.getPrecioCompra());
    	articuloTemp.setPrecioVenta(articulo.getPrecioVenta());
    	articuloTemp.setStock(articulo.getStock());
    	   
    	articuloDao.update(articuloTemp);

        return Response.ok().build();
    }

    @POST
    public Response create(Articulo articulo) {
        articuloDao.create(articulo);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Articulo articulo = articuloDao.findById(id);
        
        articuloDao.delete(articulo);

        return Response.ok().build();
    }
}
