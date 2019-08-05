package test.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.models.entities.Kardex;

@Stateless
public class KardexDao {

	@PersistenceContext(unitName = "restapi_PU")
	EntityManager em;

	private Class<Kardex> _className = Kardex.class;

	public List getAll() {
		return em.createNamedQuery("Kardex.findAll", _className).getResultList();
	}

	public Kardex findById(Integer id) {
		return em.find(_className, id);
	}

	public void update(Kardex kardex) {
		em.merge(kardex);
	}

	public void create(Kardex kardex) {
		em.persist(kardex);
	}

	public void delete(Kardex kardex) {
		if (!em.contains(kardex)) {
			kardex = em.merge(kardex);
		}

		em.remove(kardex);
	}

}
