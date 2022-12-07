
package CONTROLADOR_MVC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class BUSQUEDA_ALUMNOS {
    String nombrepro;
    int codigopro;
    String despro;
    int stockpro;
    int preciopro;

    public BUSQUEDA_ALUMNOS() {
    }

    public BUSQUEDA_ALUMNOS(String nombrepro, int codigopro, String despro, int stockpro, int preciopro) {
        this.nombrepro = nombrepro;
        this.codigopro = codigopro;
        this.despro = despro;
        this.stockpro = stockpro;
        this.preciopro = preciopro;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public int getCodigopro() {
        return codigopro;
    }

    public void setCodigopro(int codigopro) {
        this.codigopro = codigopro;
    }

    public String getDespro() {
        return despro;
    }

    public void setDespro(String despro) {
        this.despro = despro;
    }

    public int getStockpro() {
        return stockpro;
    }

    public void setStockpro(int stockpro) {
        this.stockpro = stockpro;
    }

    public double getPreciopro() {
        return preciopro;
    }

    public void setPreciopro(int preciopro) {
        this.preciopro = preciopro;
    }
    
    
    Connection cn;
    
    public void cargartabla(JTable tabla, String cadena){
        DefaultTableModel modelo;
        String [] titulo = {"nombre_a","apellido_a","genero_a","dni_a","distrito_a","direccion_a","telefono_a","año_lecitovo_a"};
        modelo = new DefaultTableModel(null,titulo);
        
        String [] registros = new String[8];
        String sql = "SELECT * FROM agregar_alumnos WHERE CONCAT(nombre_a,' ', apellido_a,' ',genero_a,' ',dni_a,' ',distrito_a,' ',telefono_a,' ',año_lecitovo_a,' ',dni_a,' ') LIKE '%"+cadena+"%'";
        Conexion_DAO con = new Conexion_DAO();
        cn= con.conectar();
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                for(int i=0; i<8; i++)
                    registros[i]=rs.getString(i+1);
                modelo.addRow(registros);
                
            }
            tabla.setModel(modelo);
            
        }  
     catch (SQLException ex){
         JOptionPane.showMessageDialog(null,"ERROR: "+ ex);
    
}
    
    }
}
