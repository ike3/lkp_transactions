package ru.lanit.lkp.transactions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SomeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void logJournal(String name) {
        Session s = sessionFactory.getCurrentSession();
        OperationJournal o = new OperationJournal();
        o.setName(name);
        s.saveOrUpdate(o);
        s.flush();
    }
}
