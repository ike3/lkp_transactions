package ru.lanit.lkp.transactions;

import java.util.Arrays;

import javax.ejb.*;
import javax.inject.Inject;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CalleeBeanImpl implements CalleeBean {

    @Inject
    private SomeDao dao;

    @Override
    public String doSomething(String parameter) {
        dao.logJournal("Callee is doing something with " + parameter);

        if (Arrays.asList("error", "callee_error").contains(parameter)) {
            throw new RuntimeException("Error occured in callee");
        }

        return "done with " + parameter;
    }

}
