package ru.lanit.lkp.transactions;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class CalleeBeanImpl implements CalleeBean {

    @Override
    public String doSomething(String parameter) {
        return "done with " + parameter;
    }

}
