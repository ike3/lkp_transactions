package ru.lanit.lkp.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ejb.*;
import javax.interceptor.Interceptors;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.transaction.*;

@Stateless
@Local
@Remote(CalleeService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@WebService(serviceName = "CallerService2",
//        wsdlLocation = "/wsdl/CallerService.wsdl",
        endpointInterface = "ru.lanit.lkp.transactions.CallerService",
        targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
@Resources({@Resource(name = "jdbc/ZakupkiDevDS", type = DataSource.class)})
public class CallerBeanImpl implements CallerService {

    @Autowired
    private SomeDao dao;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
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
