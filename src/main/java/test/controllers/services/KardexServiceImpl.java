package test.controllers.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import test.model.dao.KardexDao;
import test.model.dao.MCompraDao;
import test.models.entities.Kardex;

@RequestScoped
public class KardexServiceImpl implements IKardexService {

	@Inject
	KardexDao kardexDao;
	
	@Override
	public Kardex findOne(Integer id) {
		
		return kardexDao.findById(id);
	}

	@Override
	public List<Kardex> findAll() {
		return kardexDao.getAll();
	}

}
