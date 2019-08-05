package test.controllers.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import test.model.dao.ArticuloDao;
import test.model.dao.DVentaDao;
import test.model.dao.KardexDao;
import test.models.entities.Articulo;
import test.models.entities.DVenta;
import test.models.entities.Kardex;
import test.resources.utils.JPADefines.TipoMovimientoEnum;

@RequestScoped
public class DVentaServiceImpl implements IDVentaService {

	@Inject
	DVentaDao dVentaDao;
	
	@Inject
	ArticuloDao articuloDao;
	
	@Inject
	KardexDao  kardexDao;
	
	@Override
	public DVenta findOne(Integer id) {
		return dVentaDao.findById(id);
	}

	@Override
	public List<DVenta> findAll() {
		return dVentaDao.getAll();
	}

	@Override
	public void update(Integer id, DVenta dVenta) {
		dVentaDao.update(dVenta);
	}

	@Override
	public void save(DVenta dventa) {
		dVentaDao.create(dventa);
	}

	@Override
	public void saveListDVenta(List<DVenta> dventa) throws Exception {
		
		for (DVenta dVenta2 : dventa) {
			Articulo artD = articuloDao.findById(dVenta2.getTblArticulo().getId());
			Integer tmpStock = artD.getStock();
			tmpStock -=dVenta2.getCantidad();
			if (tmpStock < 0) 
				throw new Exception("Stock Insuficiente");
			else 
				kardexDao.create(new Kardex(dVenta2.getCantidad(), 
						dventa.get(0).getTblMVenta().getFecha() , 
						TipoMovimientoEnum.SALIDA,tmpStock , dVenta2.getTblArticulo()));
			
			
			dVentaDao.create(dVenta2);
		}
		

	}

	@Override
	public void delete(Integer id) {
		dVentaDao.delete(id);

	}

}
