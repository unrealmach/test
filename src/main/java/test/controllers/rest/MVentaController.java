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
	MVentaDao mVentaDao;
	
	@Inject 
	DVentaService  dVentaService;

	@GET
	public Response getAll() {
		DVenta dventa  = dVentaService.findOne(1);
//		System.out.print(dventa.toString());
		return Response.ok(mVentaDao.getAll()).build();
	}
	

    @GET
    @Path("{id}")
    public Response getOne(@PathParam("id") Long id) {
        MVenta mventa = mVentaDao.findById(id);
        return Response.ok(mventa).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, MVenta mVenta,DVenta[] dVenta) {
    	MVenta mVentaTemp = mVentaDao.findById(id);
    	
    	//check if articulo stock puede hacer la venta y no queda en 0
    	mVentaTemp.setFecha(mVenta.getFecha());
    	   //todo hacer la actualizacion en cascada
    	mVentaDao.update(mVentaTemp);

        return Response.ok().build();
    }

//    @POST
//    public Response create(Articulo articulo) {
//        mVentaDao.create(articulo);
//        return Response.ok().build();
//    }
//
//    @DELETE
//    @Path("{id}")
//    public Response delete(@PathParam("id") Long id) {
//        Articulo articulo = mVentaDao.findById(id);
//        
//        mVentaDao.delete(articulo);
//
//        return Response.ok().build();
//    }
}
