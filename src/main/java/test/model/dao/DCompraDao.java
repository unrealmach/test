package test.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.models.entities.DCompra;
import test.models.entities.DVenta;
import test.models.entities.MVenta;

@Stateless
public class DCompraDao {

	
	 @PersistenceContext(unitName = "restapi_PU")
	    EntityManager em;
	  
	  private Class<DCompra> _className = DCompra.class;
	  
	  
	  public List getAll() {
			return em.createNamedQuery("DVenta.findAll", _className).getResultList();
		}

		public DCompra findById(Integer id) {
			return em.find(_className, id);
		}

		public void update(DCompra dCompra) {
			em.merge(dCompra);
		}

		public void create(DCompra dCompra) {
			em.persist(dCompra);
		}

		public void delete(Integer id) {
			DCompra dCompra = em.find(_className, id);
			em.remove(dCompra);
		}
	 

}
