package test.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import test.models.entities.MVenta;

@Stateless
public class MVentaDao {
	
	 @PersistenceContext(unitName = "restapi_PU")
	    EntityManager em;
	  
	  private Class<MVenta> _className = MVenta.class;
	  
	  public List getAll() {
			return em.createNamedQuery("MVenta.findAll", _className).getResultList();
		}

		public MVenta findById(Long id) {
			return em.find(_className, id);
		}

		public void update(MVenta mVenta) {
			em.merge(mVenta);
		}

		public void create(MVenta mVenta) {
			em.persist(mVenta);
		}

		public void delete(MVenta mVenta) {
			if (!em.contains(mVenta)) {
				mVenta = em.merge(mVenta);
			}

			em.remove(mVenta);
		}
	 

}
