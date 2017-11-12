/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.vuelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Celina
 */
@WebService(serviceName = "VueloWebService")
@Stateless()
public class VueloWebService {


    /**
     * Web service operation
     * @param id_vuelo
     * @param fecha
     * @return 
     */
    @WebMethod(operationName = "consule_libres")
    public int consule_libres(@WebParam(name = "id_vuelo") int id_vuelo, @WebParam(name = "fecha") int fecha) {
        Connection connection = null;
        Integer ret = 0;
        try                        
        {            
          // load the sqlite-JDBC driver using the current class loader
            Class.forName("org.sqlite.JDBC"); 
            connection = DriverManager.getConnection("jdbc:sqlite:/Users/Celina/Documents/00 Documentos - Celinas MacBook Air/Uni/5.Auslandssemester/AD/Ejercisios/ad-lab3/dblab3");
            //connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Melani\\Desktop\\FIB\\TI\\AD\\lab3-ad\\dblab3");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            
            String query = "select * from vuelo_fecha where id_vuelo= ? and fecha = ?";
           
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id_vuelo);
            pstmt.setInt(2, fecha);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                System.out.println("hello");
                ret = rs.getInt("num_plazas_max") - rs.getInt("num_plazas_ocupadas");
            }
        }
        catch(SQLException | ClassNotFoundException e)
        {
          System.err.println(e.getMessage());
        }   
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }   
        return ret;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reserva_plaza")
    public int reserva_plaza(@WebParam(name = "id_vuelo") int id_vuelo, @WebParam(name = "fecha") int fecha) {
        Connection connection = null;
        Integer ret = -1;
        try                        
        {            
          // load the sqlite-JDBC driver using the current class loader
            Class.forName("org.sqlite.JDBC"); 
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Melani\\Desktop\\FIB\\TI\\AD\\lab3-ad\\dblab3");
            //connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Melani\\Desktop\\FIB\\TI\\AD\\lab3-ad\\dblab3");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            
            String query = "select * from vuelo_fecha where id_hotel= ? and fecha = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id_vuelo);
            pstmt.setInt(2, fecha);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                if ((rs.getInt("num_plazas_max") - rs.getInt("num_plazas_ocupadas")) > 0) {
                    ret = rs.getInt("num_plaza_ocupadas") + 1;
                    PreparedStatement ps = connection.prepareStatement("update hotel_fecha set num_plaza_ocupadas = num_plaza_ocupadas +1 where id_hotel= ?");
                    ps.setInt(1, id_vuelo);
                    ps.executeUpdate();
                }else{
                    ret = -1;
                }
            }
        }
        catch(SQLException | ClassNotFoundException e)
        {
          System.err.println(e.getMessage());
        }   
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }   
        return ret;
    
    }
}
