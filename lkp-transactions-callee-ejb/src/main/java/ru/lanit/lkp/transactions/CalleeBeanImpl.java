package ru.lanit.lkp.transactions;

import java.util.Arrays;

import javax.ejb.*;
import javax.inject.Inject;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CalleeBeanImpl implements Callee {

    @Inject
    private SomeDao dao;

    @Override
    public String doSomething(String parameter) {
        System.out.println("CALLEE EJB STARTED");
        dao.logJournal("Callee is doing something with " + parameter);

        if (Arrays.asList("error", "callee_error").contains(parameter)) {
            System.out.println("CALLEE EJB THROWS ERROR");
            throw new RuntimeException("Error occured in callee");
        }

        System.out.println("CALLEE EJB FINISHED");
        return "done with " + parameter;
    }

}
