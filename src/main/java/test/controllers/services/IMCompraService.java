package test.controllers.services;

import java.util.List;

import test.models.entities.DCompra;
import test.models.entities.MCompra;

public interface IMCompraService {

	
public MCompra findOne(Integer id);
	
	public List<MCompra> findAll();
	public void updateMaster(Integer id,MCompra mCompra);
	public void updateAll(Integer mId, MCompra mCompra, List<DCompra> dCompra);
	public void saveAll(MCompra mCompra, List<DCompra> dCompra);
	public void delete(Integer id);
}
