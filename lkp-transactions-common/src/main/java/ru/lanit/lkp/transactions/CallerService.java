package ru.lanit.lkp.transactions;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "CallerService", targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
public interface CallerService {
    @WebMethod
    String doSomething(@WebParam String parameter);
}
