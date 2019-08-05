package test.controllers.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import test.model.dao.ArticuloDao;
import test.model.dao.MVentaDao;
import test.models.entities.DVenta;
import test.models.entities.MVenta;

@RequestScoped
public class MVentaImpl implements IMVenta {

	@Inject
	MVentaDao mVentaDao;
	
	@Override
	public MVenta findOne(Integer id) {
		return mVentaDao.findById(id);
	}

	@Override
	public List<MVenta> findAll() {
		return mVentaDao.getAll();
	}

	@Override
	public void updateMaster(Integer id, MVenta mventa) {
		mVentaDao.update(mventa);

	}

	@Override
	public void updateAll(Integer mId, MVenta mventa, List<DVenta> dventa) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAll(MVenta mventa, List<DVenta> dventa) {
		MVenta temp = mventa;
//		temp.setTblDVentas(dventa);
		
//		mVentaDao.update(temp);

	}

	@Override
	public void delete(Integer id) {
		mVentaDao.delete(id);

	}

}
