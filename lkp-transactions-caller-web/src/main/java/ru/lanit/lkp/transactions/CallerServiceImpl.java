package ru.lanit.lkp.transactions;

import javax.ejb.*;
import javax.jws.*;

@WebService(name = "CallerService",
        serviceName = "CallerService",
        wsdlLocation = "/wsdl/CallerService.wsdl",
        endpointInterface = "ru.lanit.lkp.transactions.CallerService",
        targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Remote(CalleeService.class)
public class CallerServiceImpl implements CallerService {

    @EJB
    Caller bean;

    @Override
    @WebMethod
    public String doSomething(@WebParam String parameter) {
        return bean.doSomething(parameter);
    }

}
