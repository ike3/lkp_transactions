package ru.lanit.lkp.transactions;

import javax.ejb.*;
import javax.inject.Inject;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class CalleeNonTransactionalProxyImpl implements CalleeNonTransactionalProxy {

    @Inject
    private CalleeService callee;

    @Override
    public String doSomething(String parameter) {
        System.out.println("CALLEE NON-TRANSACTIONAL PROXY STARTED");

        callee.doSomething(parameter);

        System.out.println("CALLEE NON-TRANSACTIONAL PROXY FINISHED");
        return "done with " + parameter;
    }

}
