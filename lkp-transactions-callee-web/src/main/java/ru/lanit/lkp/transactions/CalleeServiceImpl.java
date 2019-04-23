package ru.lanit.lkp.transactions;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebParam;
import javax.jws.WebService;

import ru.lanit.lkp.transactions.ws.api.CalleeService;

@WebService(serviceName = "CalleeService",
		wsdlLocation = "/wsdl/CalleeService.wsdl",
        endpointInterface = "ru.lanit.lkp.transactions.ws.api.CalleeService",
        targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
public class CalleeServiceImpl implements CalleeService {

    @EJB
    Callee bean;

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public String doSomething(@WebParam String parameter) {
        return bean.doSomething(parameter);
    }

}
