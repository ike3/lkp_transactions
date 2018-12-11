package ru.lanit.lkp.transactions;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local
public class CalleeBeanImpl implements CalleeBean {

    @Inject
    private SomeDao dao;

    @Override
    public String doSomething(String parameter) {
        dao.logJournal("Callee is doing with " + parameter);
        return "done with " + parameter;
    }

}
