<%-- 
    Document   : index
    Created on : 12-nov-2017, 21:01:40
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
        <h1>Gestor de vuelos:</h1>
        <h2>Plazas libres:</h2>
            <%-- start web service invocation --%><hr/>
            <%
                try {
                    org.me.vuelo.VueloWebService_Service service = new org.me.vuelo.VueloWebService_Service();
                    org.me.vuelo.VueloWebService port = service.getVueloWebServicePort();
                     // TODO initialize WS operation arguments here
                    java.lang.Integer idVuelo = Integer.valueOf(1);
                    java.lang.Integer fecha = Integer.valueOf(20171111);
                    // TODO process result here
                    int result = port.consuleLibres(idVuelo, fecha);
                    out.println("Result = "+result);
                } catch (Exception ex) {
                    out.println("exception" + ex);
                }
            %>
            <%-- end web service invocation --%><hr/>

            <h2>Reserva:</h2>
            <%-- start web service invocation --%><hr/>
             <%
                 try {
                     org.me.vuelo.VueloWebService_Service service = new org.me.vuelo.VueloWebService_Service();
                     org.me.vuelo.VueloWebService port = service.getVueloWebServicePort();
                      // TODO initialize WS operation arguments here
                     java.lang.Integer idVuelo = Integer.valueOf(1);
                     java.lang.Integer fecha = Integer.valueOf(20171111);
                     // TODO process result here
                     int result = port.reservaPlaza(idVuelo, fecha);
                     out.println("Result = "+result);
                 } catch (Exception ex) {
                     out.println("exception" + ex);
                 }
             %>
             <%-- end web service invocation --%><hr/>
 
            <h2>Plazas libres despues de reservar:</h2>
            <%-- start web service invocation --%><hr/>
            <%
                try {
                    org.me.vuelo.VueloWebService_Service service = new org.me.vuelo.VueloWebService_Service();
                    org.me.vuelo.VueloWebService port = service.getVueloWebServicePort();
                     // TODO initialize WS operation arguments here
                    java.lang.Integer idVuelo = Integer.valueOf(1);
                    java.lang.Integer fecha = Integer.valueOf(20171111);
                    // TODO process result here
                    int result = port.consuleLibres(idVuelo, fecha);
                    out.println("Result = "+result);
                } catch (Exception ex) {
                    out.println("exception" + ex);
                }
            %>
            <%-- end web service invocation --%><hr/>
             
    </body>
</html>
