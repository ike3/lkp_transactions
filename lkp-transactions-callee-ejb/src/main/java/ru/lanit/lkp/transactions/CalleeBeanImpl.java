package ru.lanit.lkp.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ejb.*;
import javax.interceptor.Interceptors;
import javax.sql.DataSource;

@Stateless(name = "CalleeBeanImpl")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@Resources({@Resource(name = "jdbc/ZakupkiDevDS", type = DataSource.class)})
public class CalleeBeanImpl implements Callee {

    @Autowired
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
