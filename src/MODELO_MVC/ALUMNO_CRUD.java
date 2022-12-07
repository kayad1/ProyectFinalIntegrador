
package MODELO_MVC;

import CONTROLADOR_MVC.Conexion_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ALUMNO_CRUD {
    
     public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;
    
          public int guardar_alumno(String nombre_a, String apellido_a, String genero_a, int dni_a, String distrito_a,String direccion_a,int telefono_a,String año_lecitovo_a) throws SQLException{
        int resultado2 = 0;
        Connection conexion = null;
        
        String sentencia_GuardarAlumno = ("INSERT INTO agregar_alumnos (nombre_a,apellido_a,genero_a,dni_a,distrito_a,direccion_a,telefono_a,año_lecitovo_a) VALUES (?,?,?,?,?,?,?,?)");
        
        try {
            conexion =  Conexion_DAO.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_GuardarAlumno);
            sentencia_preparada.setString(1,nombre_a);
            sentencia_preparada.setString(2,apellido_a);
            sentencia_preparada.setString(3,genero_a);
            sentencia_preparada.setInt(4,dni_a);
            sentencia_preparada.setString(5,distrito_a);
            sentencia_preparada.setString(6,direccion_a);
            sentencia_preparada.setInt(7,telefono_a);
            sentencia_preparada.setString(8,año_lecitovo_a);
            
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
        
        String sentencia_updatecli = ("UPDATE agregar_alumnos SET nombre_apellido=?,Dni=?,telefono=?,correo=? where Dni=?");
        
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
        
        String sentencia_eliminarcli = ("DELETE FROM agregar_alumnos WHERE nombre_apellido=?");
        
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

    

