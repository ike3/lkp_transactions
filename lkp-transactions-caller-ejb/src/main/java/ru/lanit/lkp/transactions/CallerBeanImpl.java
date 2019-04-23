package ru.lanit.lkp.transactions;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import ru.lanit.lkp.transactions.ws.api.CalleeService;

@Stateless(name = "CallerBeanImpl")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@Resources({@Resource(name = "jdbc/ZakupkiDevDS", type = DataSource.class)})
public class CallerBeanImpl implements Caller {

    @Autowired
    private SomeDao dao;

    @Override
    public String doSomething(String parameter) {
        dao.logJournal("Caller is doing something with " + parameter);

        CalleeService callee = new CalleeClient().getService();
        callee.doSomething(parameter);

        if (Arrays.asList("error", "caller_error").contains(parameter)) {
            throw new RuntimeException("Error occured in caller");
        }

        return "done with " + parameter;
    }

}
