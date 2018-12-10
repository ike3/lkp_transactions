package ru.lanit.lkp.transactions;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "CalleeService", targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
public interface CalleeService {
    @WebMethod
    String doSomething(@WebParam String parameter);
}
