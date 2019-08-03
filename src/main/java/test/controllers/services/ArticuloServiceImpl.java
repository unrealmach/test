package test.controllers.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import test.model.dao.ArticuloDao;
import test.model.dao.DVentaDao;
import test.models.entities.Articulo;
import test.models.entities.DVenta;

@RequestScoped
public class ArticuloServiceImpl implements IArticuloService {

	@Inject
	ArticuloDao articuloDao;
	
	@Override
	public Articulo findOne(Integer id) {
		return articuloDao.findById(id);
	}

	@Override
	public List<Articulo> findAll() {
		return articuloDao.getAll();
	}

	@Override
	public void update(Integer id, Articulo articulo) {
		Articulo articuloTemp = articuloDao.findById(id);
    	articuloTemp.setCodigo(articulo.getCodigo());
    	articuloTemp.setNombre(articulo.getNombre());
    	articuloTemp.setPrecioCompra(articulo.getPrecioCompra());
    	articuloTemp.setPrecioVenta(articulo.getPrecioVenta());
    	articuloTemp.setStock(articulo.getStock());
    	articuloDao.update(articuloTemp);

	}

	@Override
	public void save(Articulo articulo) {
		articuloDao.create(articulo);
		
	}
	@Override
	public void delete(Integer id) {
		articuloDao.delete(id);
		
	}
}
