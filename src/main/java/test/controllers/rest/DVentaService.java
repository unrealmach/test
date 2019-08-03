package test.controllers.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import test.model.dao.DVentaDao;
import test.model.dao.MVentaDao;
import test.models.entities.DVenta;

@RequestScoped
public class DVentaService {
	@Inject
	DVentaDao dVentaDao;
	
	public DVenta findOne(Integer id) {
		return dVentaDao.findById(id);
	}
	
}
