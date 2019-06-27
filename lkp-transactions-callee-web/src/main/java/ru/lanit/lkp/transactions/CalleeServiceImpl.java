package ru.lanit.lkp.transactions;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "CalleeService",
        serviceName = "CalleeService",
        wsdlLocation = "/wsdl/CalleeService.wsdl",
        portName = "CalleeServicePort",
        endpointInterface = "ru.lanit.lkp.transactions.CalleeService",
        targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CalleeServiceImpl implements CalleeService {

    @EJB
    Callee bean;

    @Override
    @WebMethod
    public String doSomething(@WebParam String parameter) {
        System.out.println("CALLEE WEB SERVICE STARTED");
        String result = bean.doSomething(parameter);
        System.out.println("CALLEE WEB SERVICE FINISHED");
        return result;
    }

}
