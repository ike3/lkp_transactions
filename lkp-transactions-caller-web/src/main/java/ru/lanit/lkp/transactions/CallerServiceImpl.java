package ru.lanit.lkp.transactions;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebParam;
import javax.jws.WebService;

import ru.lanit.lkp.transactions.ws.api.CallerService;

@WebService(serviceName = "CallerService",
        wsdlLocation = "/wsdl/CallerService.wsdl",
        endpointInterface = "ru.lanit.lkp.transactions.ws.api.CallerService",
        targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
public class CallerServiceImpl implements CallerService {

    @EJB
    Caller bean;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public String doSomething(@WebParam String parameter) {
        return bean.doSomething(parameter);
    }

}
