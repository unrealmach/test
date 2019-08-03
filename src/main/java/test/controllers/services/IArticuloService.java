package test.controllers.services;

import java.util.List;

import test.models.entities.Articulo;

public interface IArticuloService {
	public Articulo findOne(Integer id);
	
	public List<Articulo> findAll();
	public void update(Integer id,Articulo art);
	public void save(Articulo art);
	public void delete(Integer id);
	
}
