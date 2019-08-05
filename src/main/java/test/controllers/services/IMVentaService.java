package test.controllers.services;

import java.util.List;

import test.models.entities.DCompra;
import test.models.entities.DVenta;
import test.models.entities.MCompra;
import test.models.entities.MVenta;

public interface IMVentaService {

public MVenta findOne(Integer id);
	
	public List<MVenta> findAll();
	public void updateMaster(Integer id,MVenta mventa);
	public void updateAll(Integer mId, MVenta mventa, List<DVenta> dventa);
	public void saveAll(MVenta mventa, List<DVenta> dventa);
	public void delete(Integer id);
	
}
