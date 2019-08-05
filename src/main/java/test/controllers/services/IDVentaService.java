package test.controllers.services;

import java.util.List;

import test.models.entities.DVenta;
import test.models.entities.MVenta;

public interface IDVentaService {

	public DVenta findOne(Integer id);
	public List<DVenta> findAll();
	public void update(Integer id, DVenta mventa);
	public void save(DVenta dventa);
	
	public void saveListDVenta(List<DVenta> dventa);

	public void delete(Integer id);
}
