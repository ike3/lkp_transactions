package ru.lanit.lkp.transactions;

import java.net.MalformedURLException;
import java.net.URL;

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
public class CalleeClient {
    public CalleeService getService() {
        URL url = null;
        try {
            url = new URL("http://localhost:9082/callee/CalleeService/wsdl/CalleeService.wsdl");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        //CalleeService_Service serv = new CalleeService_Service();
        //CalleeService port = serv.getCalleeServiceImplPort();
        QName qname = new QName("http://api.ws.transactions.lkp.lanit.ru/", "CalleeService");
        Service service = Service.create(url, qname);
        CalleeService port = service.getPort(CalleeService.class);

        String endpointURL = "http://localhost:9082/callee/CalleeService";
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
