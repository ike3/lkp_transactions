package ru.lanit.lkp.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ejb.*;
import javax.interceptor.Interceptors;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.transaction.*;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@Resources({@Resource(name = "jdbc/ZakupkiDevDS", type = DataSource.class)})
public class CallerBeanImpl implements Caller {

    @Autowired
    private SomeDao dao;

    private CalleeService callee = new CalleeClient().getService();

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
