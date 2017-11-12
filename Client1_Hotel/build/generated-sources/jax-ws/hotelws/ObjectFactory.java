
package hotelws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hotelws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FreeRooms_QNAME = new QName("http://hotelWS/", "freeRooms");
    private final static QName _FreeRoomsResponse_QNAME = new QName("http://hotelWS/", "freeRoomsResponse");
    private final static QName _Booking_QNAME = new QName("http://hotelWS/", "booking");
    private final static QName _BookingResponse_QNAME = new QName("http://hotelWS/", "bookingResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hotelws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Booking }
     * 
     */
    public Booking createBooking() {
        return new Booking();
    }

    /**
     * Create an instance of {@link BookingResponse }
     * 
     */
    public BookingResponse createBookingResponse() {
        return new BookingResponse();
    }

    /**
     * Create an instance of {@link FreeRooms }
     * 
     */
    public FreeRooms createFreeRooms() {
        return new FreeRooms();
    }

    /**
     * Create an instance of {@link FreeRoomsResponse }
     * 
     */
    public FreeRoomsResponse createFreeRoomsResponse() {
        return new FreeRoomsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FreeRooms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWS/", name = "freeRooms")
    public JAXBElement<FreeRooms> createFreeRooms(FreeRooms value) {
        return new JAXBElement<FreeRooms>(_FreeRooms_QNAME, FreeRooms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FreeRoomsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWS/", name = "freeRoomsResponse")
    public JAXBElement<FreeRoomsResponse> createFreeRoomsResponse(FreeRoomsResponse value) {
        return new JAXBElement<FreeRoomsResponse>(_FreeRoomsResponse_QNAME, FreeRoomsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Booking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWS/", name = "booking")
    public JAXBElement<Booking> createBooking(Booking value) {
        return new JAXBElement<Booking>(_Booking_QNAME, Booking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWS/", name = "bookingResponse")
    public JAXBElement<BookingResponse> createBookingResponse(BookingResponse value) {
        return new JAXBElement<BookingResponse>(_BookingResponse_QNAME, BookingResponse.class, null, value);
    }

}
