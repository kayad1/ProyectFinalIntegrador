
package MODELO_MVC;

import CONTROLADOR_MVC.Conexion_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PADRES_CRUD {
    
     public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;
    
          public int guardar_padres (String nombre_p, String apellido_p, String genero_p, int dni_p, String distrito_p,String direccion_p,int telefono_p) throws SQLException{
        int resultado2 = 0;
        Connection conexion = null;
        
        String sentencia_GuardarPadres = ("INSERT INTO agregar_padres (nombre_p,apellido_p,genero_p,dni_p,distrito_p,direccion_p,telefono_p) VALUES (?,?,?,?,?,?,?)");
        
        try {
            conexion =  Conexion_DAO.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_GuardarPadres);
            sentencia_preparada.setString(1,nombre_p);
            sentencia_preparada.setString(2,apellido_p);
            sentencia_preparada.setString(3,genero_p);
            sentencia_preparada.setInt(4,dni_p);
            sentencia_preparada.setString(5,distrito_p);
            sentencia_preparada.setString(6,direccion_p);
            sentencia_preparada.setInt(7,telefono_p);
            
            
            resultado2 = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion.close();
        }
        catch (SQLException e){
            System.out.println(e);
        }    
        return resultado2;
        
        
    }
    
     
     public int updatecli(String nombre_apellido,int Dni, int telefono,String correo) throws SQLException{
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_updatecli = ("UPDATE agregar_padres SET nombre_apellido=?,Dni=?,telefono=?,correo=? where Dni=?");
        
        try {
            conexion =  Conexion_DAO.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_updatecli);
            sentencia_preparada.setString(1,nombre_apellido);
            sentencia_preparada.setInt(2,Dni);
            sentencia_preparada.setInt(3,telefono);
            sentencia_preparada.setString(4,correo);
            sentencia_preparada.setInt(5,Dni);
            
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion.close();
        }
        catch (SQLException e){
            System.out.println(e);
        }    
        return resultado;
        
        
    }
     
     public int eliminarcli(String nombre_apellido,int Dni, int telefono,String correo) throws SQLException{
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_eliminarcli = ("DELETE FROM agregar_padres WHERE nombre_apellido=?");
        
        try {
            conexion =  Conexion_DAO.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_eliminarcli);
            sentencia_preparada.setString(1,nombre_apellido);
          
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion.close();
        }
        catch (SQLException e){
            System.out.println(e);
        }    
        return resultado;
        
        
    }
     
        
    
    
    
}
