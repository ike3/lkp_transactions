package ru.lanit.lkp.transactions;

import javax.ejb.Local;

@Local
public interface Caller {
    String doSomething(String parameter);
}
