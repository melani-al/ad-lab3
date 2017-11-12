/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client1;

/**
 *
 * @author Melani
 */
public class Client1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer id = 1;
        Integer date = 20170130;
        Integer res1 = booking(id, date);
        System.out.print("Result = " + res1);
        Integer res2 = booking(id, date);
        System.out.println("Result = " + res2);
    }

    private static Integer booking(java.lang.Integer idHotel, java.lang.Integer fecha) {
        hotelws.HotelWS_Service service = new hotelws.HotelWS_Service();
        hotelws.HotelWS port = service.getHotelWSPort();
        return port.booking(idHotel, fecha);
    }

    private static Integer freeRooms(java.lang.Integer idHotel, java.lang.Integer date) {
        hotelws.HotelWS_Service service = new hotelws.HotelWS_Service();
        hotelws.HotelWS port = service.getHotelWSPort();
        return port.freeRooms(idHotel, date);
    }
}
