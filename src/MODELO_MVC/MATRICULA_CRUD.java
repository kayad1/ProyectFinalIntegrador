
package MODELO_MVC;

import CONTROLADOR_MVC.Conexion_DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MATRICULA_CRUD {
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;
    
     public int GuardarMatricula(int codigo_m,String nombre_a_m,String apellido_a_m,int dni_a_m,String grado_electivo_m,String estado_m,String nombre_p_m, String nombre_m_m) throws SQLException{
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_guardarmatricula = ("INSERT INTO matricula (codigo_m,nombre_a_m,apellido_a_m,dni_a_m,grado_electivo_m,estado_m,nombre_p_m,nombre_m_m) VALUES (?,?,?,?,?,?,?,?)");
        
        try {
            conexion =  Conexion_DAO.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardarmatricula);
            sentencia_preparada.setInt(1,codigo_m);
            sentencia_preparada.setString(2,nombre_a_m);
            sentencia_preparada.setString(3,apellido_a_m);
            sentencia_preparada.setInt(4,dni_a_m);
            sentencia_preparada.setString(5,grado_electivo_m);
            sentencia_preparada.setString(6,estado_m);
            sentencia_preparada.setString(7,nombre_p_m);
            sentencia_preparada.setString(8,nombre_m_m);
           
            
            
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion.close();
        }
        catch (Exception e){
            System.out.println(e);
        }    
        return resultado;
        
    
     }
      
        public int eliminarventa( int CODIGO,String PRODUCTO,String DESCRIPCION,int CANTIDAD, int PRECIO,String NOMBREAPELLIDO,int DNIRUC,int NUMERO, String CORREO) throws SQLException{
        int resultado3 = 0;
        Connection conexion = null;
        
        String sentencia_eliminarventa = ("DELETE FROM matricula WHERE DNIRUC=?");
        
        try {
            conexion =  Conexion_DAO.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_eliminarventa);
            sentencia_preparada.setInt(1,DNIRUC);
         
          
            resultado3 = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion.close();
        }
        catch (Exception e){
            System.out.println(e);
        }    
        return resultado3;
        
        
    }
     public int updateventa(int CANTIDAD, String PRODUCTO) throws SQLException{
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_updateventa = ("UPDATE matricula SET CANTIDAD=? where PRODUCTO=?");
        
        try {
            conexion =  Conexion_DAO.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_updateventa);
            sentencia_preparada.setInt(1,CANTIDAD);
            sentencia_preparada.setString(2,PRODUCTO);
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion.close();
        }
        catch (Exception e){
            System.out.println(e);
        }    
        return resultado;
        
    
}
    
}
