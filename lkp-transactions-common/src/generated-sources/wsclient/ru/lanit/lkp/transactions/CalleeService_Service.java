
package ru.lanit.lkp.transactions;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;

@WebServiceClient(name = "CalleeService", targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/", wsdlLocation = "/wsdl/CalleeService.wsdl")
public class CalleeService_Service
    extends Service
{

    private final static URL CALLEESERVICE_WSDL_LOCATION;
    private final static WebServiceException CALLEESERVICE_EXCEPTION;
    private final static QName CALLEESERVICE_QNAME = new QName("http://api.ws.transactions.lkp.lanit.ru/", "CalleeService");

    static {
        CALLEESERVICE_WSDL_LOCATION = ru.lanit.lkp.transactions.CalleeService_Service.class.getResource("/wsdl/CalleeService.wsdl");
        WebServiceException e = null;
        if (CALLEESERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find '/wsdl/CalleeService.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        CALLEESERVICE_EXCEPTION = e;
    }

    public CalleeService_Service() {
        super(__getWsdlLocation(), CALLEESERVICE_QNAME);
    }

    public CalleeService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns CalleeService
     */
    @WebEndpoint(name = "CalleeServiceImplPort")
    public CalleeService getCalleeServiceImplPort() {
        return super.getPort(new QName("http://api.ws.transactions.lkp.lanit.ru/", "CalleeServiceImplPort"), CalleeService.class);
    }

    private static URL __getWsdlLocation() {
        if (CALLEESERVICE_EXCEPTION!= null) {
            throw CALLEESERVICE_EXCEPTION;
        }
        return CALLEESERVICE_WSDL_LOCATION;
    }

}
