
package ru.lanit.lkp.transactions;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;

@WebServiceClient(name = "CallerService", targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/", wsdlLocation = "/wsdl/CallerService.wsdl")
public class CallerService_Service
    extends Service
{

    private final static URL CALLERSERVICE_WSDL_LOCATION;
    private final static WebServiceException CALLERSERVICE_EXCEPTION;
    private final static QName CALLERSERVICE_QNAME = new QName("http://api.ws.transactions.lkp.lanit.ru/", "CallerService");

    static {
        CALLERSERVICE_WSDL_LOCATION = ru.lanit.lkp.transactions.CallerService_Service.class.getResource("/wsdl/CallerService.wsdl");
        WebServiceException e = null;
        if (CALLERSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find '/wsdl/CallerService.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        CALLERSERVICE_EXCEPTION = e;
    }

    public CallerService_Service() {
        super(__getWsdlLocation(), CALLERSERVICE_QNAME);
    }

    public CallerService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns CallerService
     */
    @WebEndpoint(name = "CallerServiceImplPort")
    public CallerService getCallerServiceImplPort() {
        return super.getPort(new QName("http://api.ws.transactions.lkp.lanit.ru/", "CallerServiceImplPort"), CallerService.class);
    }

    private static URL __getWsdlLocation() {
        if (CALLERSERVICE_EXCEPTION!= null) {
            throw CALLERSERVICE_EXCEPTION;
        }
        return CALLERSERVICE_WSDL_LOCATION;
    }

}
