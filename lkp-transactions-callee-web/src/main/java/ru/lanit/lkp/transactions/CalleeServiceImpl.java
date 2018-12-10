package ru.lanit.lkp.transactions;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "CalleeService",
        serviceName = "CalleeService",
        endpointInterface = "ru.lanit.lkp.transactions.CalleeService",
        targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
public class CalleeServiceImpl implements CalleeService {

    @EJB
    CalleeBean bean;

    @Override
    @WebMethod
    public String doSomething(@WebParam String parameter) {
        return bean.doSomething(parameter);
    }

}
