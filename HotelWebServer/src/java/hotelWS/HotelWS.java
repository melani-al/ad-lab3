/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelWS;

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
 * @author Melani
 */
@WebService(serviceName = "HotelWS")
@Stateless()
public class HotelWS {


    /**
     * Web service operation
     * @param id_hotel
     * @param date
     * @return 
     */
    @WebMethod(operationName = "freeRooms")
    public Integer freeRooms(@WebParam(name = "id_hotel") Integer id_hotel, @WebParam(name = "date") Integer date) {
        Connection connection = null;
        Integer ret = 0;
        try                        
        {            
          // load the sqlite-JDBC driver using the current class loader
            Class.forName("org.sqlite.JDBC"); 
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Melani\\Desktop\\FIB\\TI\\AD\\LAB3\\dblab3");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            
            String query = "select * from hotel_fecha where id_hotel= ? and fecha = ?";
           
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id_hotel);
            pstmt.setInt(2, date);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                System.out.println("hello");
                ret = rs.getInt("num_hab_libres");
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
     * @param id_hotel
     * @param fecha
     * @return 
     */
    @WebMethod(operationName = "booking")
    public Integer booking(@WebParam(name = "id_hotel") Integer id_hotel, @WebParam(name = "fecha") Integer fecha) {
        Connection connection = null;
        Integer ret = -1;
        try                        
        {            
          // load the sqlite-JDBC driver using the current class loader
            Class.forName("org.sqlite.JDBC"); 
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Melani\\Desktop\\FIB\\TI\\AD\\LAB3\\dblab3");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            
            String query = "select * from hotel_fecha where id_hotel= ? and fecha = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id_hotel);
            pstmt.setInt(2, fecha);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                if (rs.getInt("num_hab_libres") > 0) {
                    ret = rs.getInt("num_hab_ocupadas") + 1;
                    PreparedStatement ps = connection.prepareStatement("update hotel_fecha set num_hab_ocupadas = num_hab_ocupadas +1 where id_hotel= ?");
                    ps.setInt(1, id_hotel);
                    ps.executeUpdate();
                    PreparedStatement ps2 = connection.prepareStatement("update hotel_fecha set num_hab_libres = num_hab_libres -1 where id_hotel= ?");
                    ps2.setInt(1, id_hotel);
                    ps2.executeUpdate();
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
