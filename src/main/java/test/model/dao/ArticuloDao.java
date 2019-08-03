package test.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.models.entities.Articulo;
import test.models.entities.MVenta;


@Stateless
public class ArticuloDao {

	 @PersistenceContext(unitName = "restapi_PU")
	    EntityManager em;
	  
	  private Class<Articulo> _className = Articulo.class;
	
	  public List getAll() {
			return em.createNamedQuery("Articulo.findAll", _className).getResultList();
		}

		public Articulo findById(Long id) {
			return em.find(_className, id);
		}

		public void update(Articulo articulo) {
			em.merge(articulo);
		}

		public void create(Articulo articulo) {
			em.persist(articulo);
		}

		public void delete(Articulo articulo) {
			if (!em.contains(articulo)) {
				articulo = em.merge(articulo);
			}

			em.remove(articulo);
		}
	 

}
