package ru.lanit.lkp.transactions;

import javax.ejb.Local;

@Local
public interface Callee {
    String doSomething(String parameter);
}
