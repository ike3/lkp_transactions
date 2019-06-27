package ru.lanit.lkp.transactions;

import java.util.Arrays;

import javax.ejb.*;
import javax.inject.Inject;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CallerBeanImpl implements Caller {

    @Inject
    private SomeDao dao;

    @Inject
    private CalleeService callee;
    //private CalleeNonTransactionalProxy callee;

    @Override
    public String doSomething(String parameter) {
        System.out.println("CALLER EJB STARTED");

        dao.logJournal("Caller is doing something with " + parameter);
        callee.doSomething(parameter);

        if (Arrays.asList("error", "caller_error").contains(parameter)) {
            System.out.println("CALLER EJB THROWS ERROR");
            throw new RuntimeException("Error occured in caller");
        }

        System.out.println("CALLER EJB FINISHED");
        return "done with " + parameter;
    }

}
