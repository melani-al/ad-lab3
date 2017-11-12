<%-- 
    Document   : index
    Created on : 11-nov-2017, 20:43:05
    Author     : Melani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Conecting to the server application:</h1>
        <h2>Habitaciones libres:</h2>
        
                <%-- start web service invocation --%><hr/>
        <%
            try {
                hotelws.HotelWS_Service service = new hotelws.HotelWS_Service();
                hotelws.HotelWS port = service.getHotelWSPort();
                 //initialize WS operation arguments here
                java.lang.Integer idHotel = Integer.valueOf(1);
                java.lang.Integer date = Integer.valueOf(20170130);
                //process result here
                java.lang.Integer result = port.freeRooms(idHotel, date);
                out.println("Result = "+result);
            } catch (Exception ex) {
                out.println("exception" + ex);
            }
        %>
        <%-- end web service invocation --%><hr/>

        <h2>Habitaciones ocupadas despues de reservar:</h2>
        
            <%-- start web service invocation --%><hr/>
                  
            <%
                try {
                    hotelws.HotelWS_Service service = new hotelws.HotelWS_Service();
                    hotelws.HotelWS port = service.getHotelWSPort();
                     //initialize WS operation arguments here
                    java.lang.Integer idHotel = Integer.valueOf(1);
                    java.lang.Integer fecha = Integer.valueOf(20170130);
                    //process result here
                    java.lang.Integer result = port.booking(idHotel, fecha);
                    out.println("Result = "+result);
                } catch (Exception ex) {
                    out.println("exception" + ex);
                }
            %>
            <%-- end web service invocation --%><hr/>
        
        <h2>Habitaciones libres despues de reservar:</h2>
        
                <%-- start web service invocation --%><hr/>
        <%
            try {
                hotelws.HotelWS_Service service = new hotelws.HotelWS_Service();
                hotelws.HotelWS port = service.getHotelWSPort();
                 //initialize WS operation arguments here
                java.lang.Integer idHotel = Integer.valueOf(1);
                java.lang.Integer date = Integer.valueOf(20170130);
                //process result here
                java.lang.Integer result = port.freeRooms(idHotel, date);
                out.println("Result = "+result);
            } catch (Exception ex) {
                out.println("exception" + ex);
            }
        %>
        <%-- end web service invocation --%><hr/>
        
    </body>
</html>
