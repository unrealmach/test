package test.controllers.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import test.model.dao.DVentaDao;
import test.models.entities.DVenta;

@RequestScoped
public class DVentaServiceImpl implements IDVentaService {

	@Inject
	DVentaDao dVentaDao;
	
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
	public void saveListDVenta(List<DVenta> dventa) {
		
		//TODO: add transaction
		for (DVenta dVenta2 : dventa) {
			dVentaDao.create(dVenta2);
		}
		

	}

	@Override
	public void delete(Integer id) {
		dVentaDao.delete(id);

	}

}
