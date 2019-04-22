
package ru.lanit.lkp.transactions;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "CalleeService", targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
public interface CalleeService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "doSomething", targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/", className = "ru.lanit.lkp.transactions.DoSomething")
    @ResponseWrapper(localName = "doSomethingResponse", targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/", className = "ru.lanit.lkp.transactions.DoSomethingResponse")
    public String doSomething(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
