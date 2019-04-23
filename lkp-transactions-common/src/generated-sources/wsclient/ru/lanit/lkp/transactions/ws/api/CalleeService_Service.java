
package ru.lanit.lkp.transactions.ws.api;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "CalleeService", targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/", wsdlLocation = "wsdl/wsdl/CalleeService.wsdl")
public class CalleeService_Service
    extends Service
{

    private final static URL CALLEESERVICE_WSDL_LOCATION;
    private final static WebServiceException CALLEESERVICE_EXCEPTION;
    private final static QName CALLEESERVICE_QNAME = new QName("http://api.ws.transactions.lkp.lanit.ru/", "CalleeService");

    static {
        CALLEESERVICE_WSDL_LOCATION = ru.lanit.lkp.transactions.ws.api.CalleeService_Service.class.getClassLoader().getResource("wsdl/wsdl/CalleeService.wsdl");
        WebServiceException e = null;
        if (CALLEESERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'wsdl/wsdl/CalleeService.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        CALLEESERVICE_EXCEPTION = e;
    }

    public CalleeService_Service() {
        super(__getWsdlLocation(), CALLEESERVICE_QNAME);
    }

    public CalleeService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CALLEESERVICE_QNAME, features);
    }

    public CalleeService_Service(URL wsdlLocation) {
        super(wsdlLocation, CALLEESERVICE_QNAME);
    }

    public CalleeService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CALLEESERVICE_QNAME, features);
    }

    public CalleeService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalleeService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
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

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalleeService
     */
    @WebEndpoint(name = "CalleeServiceImplPort")
    public CalleeService getCalleeServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://api.ws.transactions.lkp.lanit.ru/", "CalleeServiceImplPort"), CalleeService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CALLEESERVICE_EXCEPTION!= null) {
            throw CALLEESERVICE_EXCEPTION;
        }
        return CALLEESERVICE_WSDL_LOCATION;
    }

}
