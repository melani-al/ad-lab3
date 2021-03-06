
package hotelws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HotelWS", targetNamespace = "http://hotelWS/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HotelWS {


    /**
     * 
     * @param date
     * @param idHotel
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "freeRooms", targetNamespace = "http://hotelWS/", className = "hotelws.FreeRooms")
    @ResponseWrapper(localName = "freeRoomsResponse", targetNamespace = "http://hotelWS/", className = "hotelws.FreeRoomsResponse")
    @Action(input = "http://hotelWS/HotelWS/freeRoomsRequest", output = "http://hotelWS/HotelWS/freeRoomsResponse")
    public Integer freeRooms(
        @WebParam(name = "id_hotel", targetNamespace = "")
        Integer idHotel,
        @WebParam(name = "date", targetNamespace = "")
        Integer date);

    /**
     * 
     * @param fecha
     * @param idHotel
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "booking", targetNamespace = "http://hotelWS/", className = "hotelws.Booking")
    @ResponseWrapper(localName = "bookingResponse", targetNamespace = "http://hotelWS/", className = "hotelws.BookingResponse")
    @Action(input = "http://hotelWS/HotelWS/bookingRequest", output = "http://hotelWS/HotelWS/bookingResponse")
    public Integer booking(
        @WebParam(name = "id_hotel", targetNamespace = "")
        Integer idHotel,
        @WebParam(name = "fecha", targetNamespace = "")
        Integer fecha);

}
