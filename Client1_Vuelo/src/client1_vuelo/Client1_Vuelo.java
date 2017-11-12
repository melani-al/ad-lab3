/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client1_vuelo;

/**
 *
 * @author Melani
 */
public class Client1_Vuelo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int idV = 1;
            int date = 20171111;
            int result = consuleLibres(idV, date);
            System.out.println("Plazas libres en el vuelo = " + result);
            int result2 = reservaPlaza(idV, date);
            System.out.println("Reserva = " + result2);
            result = consuleLibres(idV, date);
            System.out.println("Plazas libres en el vuelo despues de reservar = " + result);
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    private static int consuleLibres(java.lang.Integer idVuelo, java.lang.Integer fecha) {
        org.me.vuelo.VueloWebService_Service service = new org.me.vuelo.VueloWebService_Service();
        org.me.vuelo.VueloWebService port = service.getVueloWebServicePort();
        return port.consuleLibres(idVuelo, fecha);
    }

    private static int reservaPlaza(java.lang.Integer idVuelo, java.lang.Integer fecha) {
        org.me.vuelo.VueloWebService_Service service = new org.me.vuelo.VueloWebService_Service();
        org.me.vuelo.VueloWebService port = service.getVueloWebServicePort();
        return port.reservaPlaza(idVuelo, fecha);
    }
    
}
