
package hotelws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HotelWS", targetNamespace = "http://hotelWS/", wsdlLocation = "http://localhost:8080/HotelWS/HotelWS?wsdl")
public class HotelWS_Service
    extends Service
{

    private final static URL HOTELWS_WSDL_LOCATION;
    private final static WebServiceException HOTELWS_EXCEPTION;
    private final static QName HOTELWS_QNAME = new QName("http://hotelWS/", "HotelWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/HotelWS/HotelWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HOTELWS_WSDL_LOCATION = url;
        HOTELWS_EXCEPTION = e;
    }

    public HotelWS_Service() {
        super(__getWsdlLocation(), HOTELWS_QNAME);
    }

    public HotelWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), HOTELWS_QNAME, features);
    }

    public HotelWS_Service(URL wsdlLocation) {
        super(wsdlLocation, HOTELWS_QNAME);
    }

    public HotelWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HOTELWS_QNAME, features);
    }

    public HotelWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HotelWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HotelWS
     */
    @WebEndpoint(name = "HotelWSPort")
    public HotelWS getHotelWSPort() {
        return super.getPort(new QName("http://hotelWS/", "HotelWSPort"), HotelWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HotelWS
     */
    @WebEndpoint(name = "HotelWSPort")
    public HotelWS getHotelWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://hotelWS/", "HotelWSPort"), HotelWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HOTELWS_EXCEPTION!= null) {
            throw HOTELWS_EXCEPTION;
        }
        return HOTELWS_WSDL_LOCATION;
    }

}
