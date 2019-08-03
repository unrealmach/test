package test.model.dao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.models.entities.Todo;



@Stateless
public class TodoDao {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Todo.findAll", test.models.entities.Todo.class).getResultList();
    }

    public Todo findById(Long id) {
        return em.find(Todo.class, id);
    }

    public void update(Todo todo) {
        em.merge(todo);
    }

    public void create(Todo todo) {
        em.persist(todo);
    }

    public void delete(Todo todo) {
        if (!em.contains(todo)) {
            todo = em.merge(todo);
        }

        em.remove(todo);
    }
}