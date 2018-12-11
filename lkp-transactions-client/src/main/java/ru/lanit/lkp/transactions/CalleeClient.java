package ru.lanit.lkp.transactions;

import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

@ApplicationScoped
public class CalleeClient {
    @Produces
    public CalleeService getService() {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/callee/CalleeService?wsdl");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        QName qname = new QName("http://api.ws.transactions.lkp.lanit.ru/", "CalleeService");
        Service service = Service.create(url, qname);
        return service.getPort(CalleeService.class);
    }

    public static void main(String[] args) {
        CalleeService port = new CalleeClient().getService();
        String ret = port.doSomething("param");
        System.err.println(ret);
    }
}
