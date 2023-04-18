package dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import static dao.EntityManagerAdmin.getEntityManager;

public class ImpIDAO implements IDAO{
    @Override
    public <U> List<U> findAll(Class<U> Uclass, String nameQuery) {
        final EntityManager em = getEntityManager();
        TypedQuery <U> query =em.createNamedQuery(nameQuery, Uclass);
        return query.getResultList();
    }

    @Override
    public <U> void create(U entity) {
        final EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public <U> void delete(U entity) {
            final EntityManager em = getEntityManager();
            try {
                em.getTransaction().begin();
                em.remove(entity);
                em.getTransaction().commit();
            } catch(Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            }
        }

    @Override
    public <U> void update(U entity) {
        final EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
