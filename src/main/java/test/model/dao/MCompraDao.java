package test.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.models.entities.DCompra;
import test.models.entities.MCompra;
import test.models.entities.MVenta;

@Stateless
public class MCompraDao {
	
	 @PersistenceContext(unitName = "restapi_PU")
	    EntityManager em;
	  
	  private Class<MCompra> _className = MCompra.class;
	  
	  public List getAll() {
			return em.createNamedQuery("MCompra.findAll", _className).getResultList();
		}

		public MCompra findById(Integer id) {
			return em.find(_className, id);
		}

		public void update(MCompra mcompra) {
			em.merge(mcompra);
		}
		
		public void updateAll(MCompra mcompra,List<DCompra> dCompra ) {
			//TODO: update masterDetail
//			em.merge(mcompra);
		}
	

		public void create(MCompra mcompra) {
			em.persist(mcompra);
		}

		public void delete(Integer id) {
			MCompra mcompra =this.findById(id);
			
			if (!em.contains(mcompra)) {
				mcompra = em.merge(mcompra);
			}

			em.remove(mcompra);
		}
	 

}
