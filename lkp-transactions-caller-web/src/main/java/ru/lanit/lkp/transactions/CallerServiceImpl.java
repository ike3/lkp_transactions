package ru.lanit.lkp.transactions;

import javax.ejb.*;
import javax.jws.*;

@WebService(name = "CallerService",
        serviceName = "CallerService",
        wsdlLocation = "/wsdl/CallerService.wsdl",
        endpointInterface = "ru.lanit.lkp.transactions.CallerService",
        portName = "CallerServicePort",
        targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Remote(CalleeService.class)
public class CallerServiceImpl implements CallerService {

    @EJB
    Caller bean;

    @Override
    @WebMethod
    public String doSomething(@WebParam String parameter) {
        System.out.println("CALLER WEB SERVICE STARTED");
        String result = bean.doSomething(parameter);
        System.out.println("CALLER WEB SERVICE FINISHED");
        return result;
    }

}
