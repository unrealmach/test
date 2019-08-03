package test.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.models.entities.DVenta;
import test.models.entities.MVenta;

@Stateless
public class DVentaDao {

	
	 @PersistenceContext(unitName = "restapi_PU")
	    EntityManager em;
	  
	  private Class<DVenta> _className = DVenta.class;
	  
	  
	  public List getAll() {
			return em.createNamedQuery("DVenta.findAll", _className).getResultList();
		}

		public DVenta findById(Long id) {
			return em.find(_className, id);
		}

		public void update(DVenta dVenta) {
			em.merge(dVenta);
		}

		public void create(DVenta dVenta) {
			em.persist(dVenta);
		}

		public void delete(DVenta dVenta) {
			if (!em.contains(dVenta)) {
				dVenta = em.merge(dVenta);
			}

			em.remove(dVenta);
		}
	 

}
