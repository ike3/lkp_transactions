package ru.lanit.lkp.transactions;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local
public class CallerBeanImpl implements CallerBean {

    @Inject
    private SomeDao dao;

    @Inject
    private CalleeService callee;

    @Override
    public String doSomething(String parameter) {
        callee.doSomething(parameter);

        dao.logJournal("Caller is doing something with " + parameter);
        return "done with " + parameter;
    }

}
