package test.controllers.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import test.model.dao.MCompraDao;
import test.models.entities.DCompra;
import test.models.entities.MCompra;

@RequestScoped
public class MCompraServiceImpl implements IMCompraService {

	@Inject
	MCompraDao mCompraDao;
	
	@Override
	public MCompra findOne(Integer id) {
		return mCompraDao.findById(id);
	}

	@Override
	public List<MCompra> findAll() {
		return mCompraDao.getAll();
	}

	@Override
	public void updateMaster(Integer id, MCompra mCompra) {
		mCompraDao.update(mCompra);

	}

	@Override
	public void updateAll(Integer mId, MCompra mCompra, List<DCompra> dCompra) {
		//TODO: falta implementar en dao
		mCompraDao.updateAll(mCompra,dCompra);
	}

	@Override
	public void saveAll(MCompra mCompra, List<DCompra> dCompra) {
		MCompra tmpMcompra = mCompra;
//		tmpMcompra.setTblDCompras(dCompra);
	
		mCompraDao.create(mCompra);
	}

	@Override
	public void delete(Integer id) {
		mCompraDao.delete(id);

	}

}
