package test.controllers.services;

import java.util.List;

import test.models.entities.DVenta;
import test.models.entities.Kardex;

public interface IKardexService {
	public Kardex findOne(Integer id);
	public List<Kardex> findAll();
}
