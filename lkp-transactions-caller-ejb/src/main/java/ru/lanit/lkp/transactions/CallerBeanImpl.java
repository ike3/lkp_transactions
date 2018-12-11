package ru.lanit.lkp.transactions;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local
public class CallerBeanImpl implements CallerBean {

    @Inject
    private SomeDao dao;

    @Override
    public String doSomething(String parameter) {
        dao.logJournal("Caller is doing something with " + parameter);
        return "done with " + parameter;
    }

}
