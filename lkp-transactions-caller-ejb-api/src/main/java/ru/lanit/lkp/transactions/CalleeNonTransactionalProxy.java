package ru.lanit.lkp.transactions;

import javax.ejb.Local;

@Local
public interface CalleeNonTransactionalProxy {
    String doSomething(String parameter);
}
