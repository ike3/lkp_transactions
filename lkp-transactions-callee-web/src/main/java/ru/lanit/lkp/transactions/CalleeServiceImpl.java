package ru.lanit.lkp.transactions;

import javax.ejb.*;
import javax.jws.*;

@WebService(name = "CalleeService",
        serviceName = "CalleeService",
        endpointInterface = "ru.lanit.lkp.transactions.CalleeService",
        targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Remote(CalleeService.class)
public class CalleeServiceImpl implements CalleeService {

    @EJB
    CalleeBean bean;

    @Override
    @WebMethod
    public String doSomething(@WebParam String parameter) {
        return bean.doSomething(parameter);
    }

}
