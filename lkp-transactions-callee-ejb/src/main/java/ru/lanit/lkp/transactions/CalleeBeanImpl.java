package ru.lanit.lkp.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ejb.*;
import javax.interceptor.Interceptors;
import javax.jws.WebService;
import javax.sql.DataSource;

@Stateless
@Local
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@WebService(serviceName = "CalleeService2",
//        wsdlLocation = "/wsdl/CalleeService.wsdl",
        endpointInterface = "ru.lanit.lkp.transactions.CalleeService",
        targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
@Resources({@Resource(name = "jdbc/ZakupkiDevDS", type = DataSource.class)})
public class CalleeBeanImpl implements CalleeService {

    @Autowired
    private SomeDao dao;

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public String doSomething(String parameter) {
        dao.logJournal("Callee is doing something with " + parameter);

        if (Arrays.asList("error", "callee_error").contains(parameter)) {
            throw new RuntimeException("Error occured in callee");
        }

        return "done with " + parameter;
    }

}
