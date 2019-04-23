package ru.lanit.lkp.transactions;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.BindingProvider;

import ru.lanit.lkp.transactions.ws.api.CallerService;
import ru.lanit.lkp.transactions.ws.api.CallerService_Service;

public class CallerClient {
    public CallerService getService() {
        URL url = null;
        try {
            url = new URL("http://localhost:9082/caller/CallerService/wsdl/CallerService.wsdl");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        CallerService_Service serv = new CallerService_Service();
        CallerService port = serv.getCallerServiceImplPort();
//        QName qname = new QName("http://api.ws.transactions.lkp.lanit.ru/", "CallerService");
//        Service service = Service.create(url, qname);
//        CallerService port = service.getPort(CallerService.class);

        String endpointURL = "http://localhost:9082/caller/CallerService";
        BindingProvider bp = (BindingProvider)port;
        //bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);

        return port;
    }

    public static void main(String[] args) {
        CallerService port = new CallerClient().getService();
        String ret = port.doSomething("param");
        System.err.println(ret);
    }
}
