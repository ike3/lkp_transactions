package ru.lanit.lkp.transactions;

import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

/**

http {

    upstream CalleeService_cluster {
        # Важно - здесь нельзя писать localhost,
        # иначе придется ждать по минуте на каждый запрос из-за бага ngnix
        server 127.0.0.1:8081;
        server 127.0.0.1:8082;
    }

    server {

        location /callee/CalleeService {
            proxy_pass http://CalleeService_cluster;
            proxy_cache off;
        }
    }


    http://localhost:8080/caller/call?name=caller_error

}

 */
@ApplicationScoped
public class CalleeClient {
    @Produces
    public CalleeService getService() {
        URL url = null;
        try {
            url = new URL("http://callee:8080/callee/CalleeService?wsdl");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        QName qname = new QName("http://api.ws.transactions.lkp.lanit.ru/", "CalleeService");
        Service service = Service.create(url, qname);
        CalleeService port = service.getPort(CalleeService.class);

        String endpointURL = "http://callee:8080/callee/CalleeService";
        BindingProvider bp = (BindingProvider)port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);

        return port;
    }

    public static void main(String[] args) {
        CalleeService port = new CalleeClient().getService();
        String ret = port.doSomething("param");
        System.err.println(ret);
    }
}
