package ru.lanit.lkp.transactions;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/callee/CalleeService?wsdl");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        QName qname = new QName("http://api.ws.transactions.lkp.lanit.ru/", "CalleeService");
        Service service = Service.create(url, qname);
        CalleeService port = service.getPort(CalleeService.class);

        String ret = port.doSomething("param");
        System.err.println(ret);
    }
}
