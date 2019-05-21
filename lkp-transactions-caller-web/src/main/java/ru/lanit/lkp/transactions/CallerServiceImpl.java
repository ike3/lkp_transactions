package ru.lanit.lkp.transactions;

import javax.ejb.*;
import javax.jws.*;

@WebService(serviceName = "CallerService",
        wsdlLocation = "/wsdl/CallerService.wsdl",
        endpointInterface = "ru.lanit.lkp.transactions.CallerService",
        targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Remote(CalleeService.class)
public class CallerServiceImpl implements CallerService {

    @EJB
    Caller bean;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public String doSomething(@WebParam String parameter) {
        return bean.doSomething(parameter);
    }

}
