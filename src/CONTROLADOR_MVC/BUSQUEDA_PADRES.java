
package CONTROLADOR_MVC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author mikok
 */
public class BUSQUEDA_PADRES {
    Connection cn;
    public void cargartabla1(JTable tabla1, String cadena){
        DefaultTableModel modelo;
        String [] titulo = {"nombre_p","apellido_p","genero_p","dni_p","distrito_p","direccion_p","telefono_P"};
        modelo = new DefaultTableModel(null,titulo);
        
        String [] registros = new String[7];
        String sql = "SELECT * FROM agregar_padres WHERE CONCAT(nombre_p,' ', apellido_p,' ',genero_p,' ',dni_p,' ',distrito_p,' ',direccion_p,' ',telefono_p,' ') LIKE '%"+cadena+"%'";
        Conexion_DAO con = new Conexion_DAO();
        cn= con.conectar();
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                for(int i=0; i<7; i++)
                    registros[i]=rs.getString(i+1);
                modelo.addRow(registros);
                
            }
            tabla1.setModel(modelo);
            
        }  
     catch (SQLException ex){
         JOptionPane.showMessageDialog(null,"ERROR: "+ ex);
    
}
    
    }
}
    

