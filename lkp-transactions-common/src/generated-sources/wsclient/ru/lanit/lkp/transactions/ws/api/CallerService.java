
package ru.lanit.lkp.transactions.ws.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "CallerService", targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CallerService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "doSomething", targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/", className = "ru.lanit.lkp.transactions.ws.api.DoSomething")
    @ResponseWrapper(localName = "doSomethingResponse", targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/", className = "ru.lanit.lkp.transactions.ws.api.DoSomethingResponse")
    public String doSomething(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
