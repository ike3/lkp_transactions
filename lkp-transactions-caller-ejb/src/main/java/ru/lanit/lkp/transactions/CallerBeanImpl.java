package ru.lanit.lkp.transactions;

import java.util.Arrays;

import javax.ejb.*;
import javax.inject.Inject;

@Stateless
@Local
@TransactionAttribute
public class CallerBeanImpl implements CallerBean {

    @Inject
    private SomeDao dao;

    @Inject
    private CalleeService callee;

    @Override
    public String doSomething(String parameter) {
        dao.logJournal("Caller is doing something with " + parameter);
        callee.doSomething(parameter);

        if (Arrays.asList("error", "caller_error").contains(parameter)) {
            throw new RuntimeException("Error occured in caller");
        }

        return "done with " + parameter;
    }

}
