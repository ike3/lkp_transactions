package ru.lanit.lkp.transactions;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class SomeDao {
    @PersistenceContext
    private EntityManager em;

    public void logJournal(String name) {
        OperationJournal o = new OperationJournal();
        o.setName(name);
        em.persist(o);
    }
}
