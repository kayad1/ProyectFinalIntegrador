/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista_MVC;

import CONTROLADOR_MVC.Conexion_DAO;
import static java.awt.SystemColor.control;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import CONTROLADOR_MVC.BUSQUEDA_ALUMNOS;
import CONTROLADOR_MVC.BUSQUEDA_PADRES;
import java.sql.DriverManager;
import MODELO_MVC.ALUMNO_CRUD;

import MODELO_MVC.MATRICULA_CRUD;
import MODELO_MVC.PADRES_CRUD;
import java.sql.Date;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



        



public class VISTA_FORMULARIO extends javax.swing.JFrame{
    
    
    public static String url = "jdbc:mysql://localhost/login_bd";
    public static String usuario = "root";
    public static String pass = "12345";
    public static String clase = "com.mysql.jdbc.Driver";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName(clase);
            conexion = DriverManager.getConnection(url, usuario, pass);
            System.out.println("conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println(e);
        }
        return conexion;
    }
    
    
    String[] cabecera = {"CODIGO","DESCIPCION","CANTIDAD","PRECIO UNITARIO","PRECIO TOTAL"};
    String [][] cuerpo = {};
    DefaultTableModel modLista = new DefaultTableModel(cuerpo, cabecera);
    
    
    
     
    
            
   
    

    public VISTA_FORMULARIO() {
        
        initComponents();
        
       
        this.setLocationRelativeTo(null);
        cargarTablacli();
       
        cargartabla("");
        cargartabla1("");
        CargarTablaMatricula();
        limpiarprecio();
        limpiarta();
        CargarTablaAlumno();
        CargarTablaPadres();
        Limpiar_tabla_alumnos();
    }
    
 
    
    ALUMNO_CRUD alumno_crud = new ALUMNO_CRUD();
    PADRES_CRUD padres_crud = new PADRES_CRUD();
    MATRICULA_CRUD matricula_crud = new MATRICULA_CRUD();
   
    
    
    private void Limpiar_tabla_alumnos(){
        txt_nombre_a.setText("");
        txt_apellido_a.setText("");
        
        combo_genero_a.setSelectedItem("");
        txt_dni_a.setText("");
        combo_distrito_a.setSelectedItem("");
        txt_direccion_a.setText("");
        txt_telefono_a.setText("");
        combo_año_electivo_a.setSelectedItem("");     
    }
    private void limpiarpro(){
    
    }
    private void limpiarventa(){
        
        jTextField1.setText("");
        txtStock.setText("");
        nombre_alumno.setText("");
        apellido_alumno.setText("");
     
        
    }
    private void LimpiarClientesJalados(){
        txtclientedatos.setText("");
        nombre_padre_m.setText("");
        txtnumero.setText("");
    
    }
    private void limpiarboleta(){
        txtproductoventa.setText("");
        txtcodigo10.setText("");
        apellido_alumno.setText("");
        txtcantidad1.setText("");
        txtprecio1.setText("");
        txtclientedatos1.setText("");
        txtdni2.setText("");
        txtdni1.setText("");
        txtprecio3.setText("");
    }
    private void limpiarproductos(){
        
    }           
       private void limpiarprecio(){
     
        
    }   
       
        private void limpiarta(){
        int filas=modLista.getRowCount();
        for (int i=0; 1<filas ; i++){
            modLista.removeRow(0);
        }        
        
    }
    
    
       
       
    
    void cargartabla(String cad){
        BUSQUEDA_ALUMNOS c = new BUSQUEDA_ALUMNOS();
        c.cargartabla(table_buscar_alumnos1, cad);
    }
 
    
 
       private void CargarTablaAlumno(){
        
      
        DefaultTableModel modeloTablaAlumno = (DefaultTableModel) table_alumno.getModel();
        modeloTablaAlumno .setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        
        try{
            
            Connection con = Conexion_DAO.conectar();
            ps = con.prepareStatement("SELECT nombre_a,apellido_a,genero_a,dni_a,distrito_a,direccion_a,telefono_a,año_lecitovo_a FROM agregar_alumnos");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            
            while (rs.next()){
                Object[] fila = new Object [columnas];
                for(int indice = 0; indice<columnas; indice++){
                    fila[indice]=rs.getObject(indice +1);
                }
                modeloTablaAlumno.addRow(fila);
            }
        } catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
       
          void cargartabla1(String cad){
        BUSQUEDA_PADRES c = new BUSQUEDA_PADRES();
        c.cargartabla1(table_buscar_padres, cad);
    }
   
          
    
     
          private void CargarTablaPadres(){
        
      
        DefaultTableModel modeloTablaAlumno = (DefaultTableModel) table_padres.getModel();
        modeloTablaAlumno .setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        
        try{
            
            Connection con = Conexion_DAO.conectar();
            ps = con.prepareStatement("SELECT nombre_p,apellido_p,genero_p,dni_p,distrito_p,direccion_p,telefono_p FROM agregar_padres");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            
            while (rs.next()){
                Object[] fila = new Object [columnas];
                for(int indice = 0; indice<columnas; indice++){
                    fila[indice]=rs.getObject(indice +1);
                }
                modeloTablaAlumno.addRow(fila);
            }
        } catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
          
         private void CargarTablaMatricula(){
        
      
        DefaultTableModel modeloTablaAlumno = (DefaultTableModel) tabla_matricula.getModel();
        modeloTablaAlumno .setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        
        try{
            
            Connection con = Conexion_DAO.conectar();
            ps = con.prepareStatement("SELECT codigo_m,nombre_a_m,apellido_a_m,dni_a_m,	grado_electivo_m,estado_m,nombre_p_m,nombre_m_m FROM matricula");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            
            while (rs.next()){
                Object[] fila = new Object [columnas];
                for(int indice = 0; indice<columnas; indice++){
                    fila[indice]=rs.getObject(indice +1);
                }
                modeloTablaAlumno.addRow(fila);
            }
        } catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
     
     
    
  
        
    private void cargarTablacli(){
        
        
        DefaultTableModel modeloTablacli = (DefaultTableModel) table_alumno.getModel();
        modeloTablacli.setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        
        try{
            
            Connection con = Conexion_DAO.conectar();
            ps = con.prepareStatement("SELECT codigo_m,nombre_a_m,apellido_a_m,dni_a_m,	grado_electivo_m,estado_m,nombre_p_m,nombre_m_m FROM matricula");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            
            while (rs.next()){
                Object[] fila = new Object [columnas];
                for(int indice = 0; indice<columnas; indice++){
                    fila[indice]=rs.getObject(indice +1);
                }
                modeloTablacli.addRow(fila);
            }
        } catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGenerarVenta1 = new javax.swing.JButton();
        btnsalir3 = new javax.swing.JButton();
        txtsuma2 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        contenedor = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        txtclientedatos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnEliminarventa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        apellido_alumno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_matricula = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnregresar10 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nombre_padre_m = new javax.swing.JTextField();
        txtnumero = new javax.swing.JTextField();
        nombre_alumno = new javax.swing.JTextField();
        txtcodigoVENTA = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btn_actualizar_venta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_boleta = new javax.swing.JButton();
        dni_alumno = new javax.swing.JTextField();
        estado_matricula_p = new javax.swing.JComboBox<>();
        año_alumno = new javax.swing.JTextField();
        panel1 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btnregresar16 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnEnviarCliente1 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        table_buscar_alumnos1 = new javax.swing.JTable();
        txt_nombre_a2 = new javax.swing.JTextField();
        txt_nombre_a3 = new javax.swing.JTextField();
        txt_apellido_a2 = new javax.swing.JTextField();
        txt_dni_a3 = new javax.swing.JTextField();
        txt_dni_a4 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        txt_nombre_a = new javax.swing.JTextField();
        txt_dni_a = new javax.swing.JTextField();
        txt_telefono_a = new javax.swing.JTextField();
        btnagregarcli = new javax.swing.JButton();
        btnlimpiarcli = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_alumno = new javax.swing.JTable();
        btnmodificarcli = new javax.swing.JButton();
        btneliminarcli = new javax.swing.JButton();
        btnEnviarCliente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_apellido_a = new javax.swing.JTextField();
        txt_direccion_a = new javax.swing.JTextField();
        combo_distrito_a = new javax.swing.JComboBox<>();
        combo_genero_a = new javax.swing.JComboBox<>();
        combo_año_electivo_a = new javax.swing.JComboBox<>();
        date_años_a = new com.toedter.calendar.JDateChooser();
        panel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_nombre_p = new javax.swing.JTextField();
        txt_apellido_a1 = new javax.swing.JTextField();
        combo_genero_a1 = new javax.swing.JComboBox<>();
        txt_dni_a2 = new javax.swing.JTextField();
        txt_telefono_a1 = new javax.swing.JTextField();
        txt_direccion_a1 = new javax.swing.JTextField();
        combo_distrito_a1 = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        table_padres = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnagregarcli1 = new javax.swing.JButton();
        btnmodificarcli1 = new javax.swing.JButton();
        btnlimpiarcli2 = new javax.swing.JButton();
        btneliminarcli1 = new javax.swing.JButton();
        btnEnviarCliente2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtcodigo10 = new javax.swing.JTextField();
        btnGenerarVenta2 = new javax.swing.JButton();
        txtclientedatos1 = new javax.swing.JTextField();
        txtdni1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtdni2 = new javax.swing.JTextField();
        txtprecio3 = new javax.swing.JTextField();
        btnregresar = new javax.swing.JButton();
        btnregresar1 = new javax.swing.JButton();
        txtbuscarventa = new javax.swing.JTextField();
        btnbuscar1 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablabuscarventa = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txt_total_pagar = new javax.swing.JTextField();
        panel3 = new javax.swing.JPanel();
        txtbuscar_padres = new javax.swing.JTextField();
        btnbuscar2 = new javax.swing.JButton();
        btnregresar17 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnEnviarCliente3 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        table_buscar_padres = new javax.swing.JTable();
        txt_nombre_a5 = new javax.swing.JTextField();
        txt_apellido_a3 = new javax.swing.JTextField();
        txt_dni_a5 = new javax.swing.JTextField();
        lblnombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnsalir1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        btnGenerarVenta1.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarVenta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N

        btnsalir3.setBackground(new java.awt.Color(255, 102, 102));
        btnsalir3.setText("SALIR");

        txtsuma2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtsuma2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo Registro de Matriculas - Fe y Alegría");
        setBackground(new java.awt.Color(51, 255, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedor.setBackground(new java.awt.Color(0, 0, 0));
        contenedor.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txtclientedatos.setEditable(false);
        txtclientedatos.setBackground(new java.awt.Color(255, 255, 255));
        txtclientedatos.setBorder(javax.swing.BorderFactory.createTitledBorder("APELLIDO PADRE"));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("MATRICULAS DISPONIBLES");

        txtStock.setEditable(false);
        txtStock.setBackground(new java.awt.Color(204, 255, 204));
        txtStock.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnEliminarventa.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/36_104857 (1).png"))); // NOI18N
        btnEliminarventa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEliminarventa.setBorderPainted(false);
        btnEliminarventa.setMaximumSize(new java.awt.Dimension(300, 300));
        btnEliminarventa.setPreferredSize(new java.awt.Dimension(100, 100));
        btnEliminarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarventaActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("ELIMINAR MATRICULA");

        apellido_alumno.setEditable(false);
        apellido_alumno.setBackground(new java.awt.Color(255, 255, 255));
        apellido_alumno.setBorder(javax.swing.BorderFactory.createTitledBorder("APELLIDO DEL ALUMNO"));

        tabla_matricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO DE ALUMNO", "NOMBRE DEL ALUMNO", "APELLIDO DEL ALUMNO", "DNI", "GRADO ELECTIVO", "ESTADO ", "NOMBRE PADRE/MADRE", "APELLIDO DEL PADRE/MADRE"
            }
        ));
        tabla_matricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_matriculaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_matricula);

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setText("PROCESAR MATRICULA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnregresar10.setBackground(new java.awt.Color(153, 255, 153));
        btnregresar10.setText("Agregar Padre");
        btnregresar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresar10ActionPerformed(evt);
            }
        });

        nombre_padre_m.setEditable(false);
        nombre_padre_m.setBackground(new java.awt.Color(255, 255, 255));
        nombre_padre_m.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRE PADRE/MADRE"));

        txtnumero.setEditable(false);
        txtnumero.setBackground(new java.awt.Color(255, 255, 255));
        txtnumero.setBorder(javax.swing.BorderFactory.createTitledBorder("DNI"));

        nombre_alumno.setEditable(false);
        nombre_alumno.setBackground(new java.awt.Color(255, 255, 255));
        nombre_alumno.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRE DEL ALUMNO"));

        txtcodigoVENTA.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigoVENTA.setText("0002");
        txtcodigoVENTA.setBorder(javax.swing.BorderFactory.createTitledBorder("CÓDIGO DE MATRICULA"));

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setText("BUSCAR ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_actualizar_venta.setBackground(new java.awt.Color(255, 255, 153));
        btn_actualizar_venta.setText("ACTUALIZAR DATOS");
        btn_actualizar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_ventaActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/11_104884 (1).png"))); // NOI18N
        jLabel6.setToolTipText("");

        btn_boleta.setBackground(new java.awt.Color(255, 255, 255));
        btn_boleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        btn_boleta.setText("IMPRIMIR MATRICULA");
        btn_boleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_boletaActionPerformed(evt);
            }
        });

        dni_alumno.setBorder(javax.swing.BorderFactory.createTitledBorder("DNI"));

        estado_matricula_p.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PAGADO", "INCOMPLETO" }));

        año_alumno.setBorder(javax.swing.BorderFactory.createTitledBorder("Año lectivo"));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(574, 574, 574)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtcodigoVENTA, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(nombre_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(btn_actualizar_venta)
                                        .addGap(38, 38, 38)
                                        .addComponent(jButton1))
                                    .addComponent(apellido_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(estado_matricula_p, 0, 163, Short.MAX_VALUE)
                                    .addComponent(dni_alumno))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(año_alumno))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(nombre_padre_m, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(txtclientedatos, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnregresar10, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_boleta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(19, 19, 19))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(apellido_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(nombre_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtcodigoVENTA, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(20, 20, 20))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(año_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(15, 15, 15)))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)))
                                .addComponent(dni_alumno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(btnEliminarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(estado_matricula_p, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addComponent(btn_actualizar_venta))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtclientedatos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre_padre_m, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnregresar10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_boleta)
                        .addGap(65, 65, 65))))
        );

        contenedor.addTab("GENERAR MATRICULA", jPanel4);

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        txtbuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar alumno, por nombre apelllido o dni"));
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        btnbuscar.setBackground(new java.awt.Color(255, 255, 51));
        btnbuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/11_104884 (1).png"))); // NOI18N
        btnbuscar.setText("ACTUALIZAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnregresar16.setBackground(new java.awt.Color(102, 255, 102));
        btnregresar16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnregresar16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/39_104850.png"))); // NOI18N
        btnregresar16.setText("AGREGAR ALUMNO");
        btnregresar16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresar16ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Busqueda de alumos de la institucion educativa Fe y Alegia");

        btnEnviarCliente1.setBackground(new java.awt.Color(102, 102, 255));
        btnEnviarCliente1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEnviarCliente1.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviarCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/10_104859.png"))); // NOI18N
        btnEnviarCliente1.setText("ENVIAR ALUMNO");
        btnEnviarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCliente1ActionPerformed(evt);
            }
        });

        table_buscar_alumnos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRES", "APELLIDO", "GENERO", "DNI", "DISTRITO", "DIRECCIÓN", "TELEFONO", "GRADO ELECITOV"
            }
        ));
        table_buscar_alumnos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_buscar_alumnos1MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(table_buscar_alumnos1);
        if (table_buscar_alumnos1.getColumnModel().getColumnCount() > 0) {
            table_buscar_alumnos1.getColumnModel().getColumn(0).setPreferredWidth(30);
            table_buscar_alumnos1.getColumnModel().getColumn(1).setPreferredWidth(30);
            table_buscar_alumnos1.getColumnModel().getColumn(2).setPreferredWidth(5);
            table_buscar_alumnos1.getColumnModel().getColumn(3).setPreferredWidth(5);
            table_buscar_alumnos1.getColumnModel().getColumn(4).setPreferredWidth(30);
            table_buscar_alumnos1.getColumnModel().getColumn(5).setPreferredWidth(200);
            table_buscar_alumnos1.getColumnModel().getColumn(6).setPreferredWidth(5);
            table_buscar_alumnos1.getColumnModel().getColumn(7).setPreferredWidth(20);
        }

        txt_nombre_a2.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRES"));
        txt_nombre_a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_a2ActionPerformed(evt);
            }
        });

        txt_nombre_a3.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRES"));
        txt_nombre_a3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_a3ActionPerformed(evt);
            }
        });

        txt_apellido_a2.setBorder(javax.swing.BorderFactory.createTitledBorder("APELLIDOS"));
        txt_apellido_a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellido_a2ActionPerformed(evt);
            }
        });

        txt_dni_a3.setBorder(javax.swing.BorderFactory.createTitledBorder("DNI"));

        txt_dni_a4.setBorder(javax.swing.BorderFactory.createTitledBorder("Año lectivo"));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(1019, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(btnregresar16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(txt_nombre_a3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_apellido_a2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_dni_a3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)))
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(txt_dni_a4)
                                        .addGap(12, 12, 12))
                                    .addComponent(btnEnviarCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addGap(569, 569, 569)
                    .addComponent(txt_nombre_a2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(569, Short.MAX_VALUE)))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGap(21, 21, 21)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dni_a4)
                    .addComponent(txt_dni_a3)
                    .addComponent(txt_nombre_a3, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(txt_apellido_a2))
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnregresar16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addGap(264, 264, 264)
                    .addComponent(txt_nombre_a2)
                    .addGap(265, 265, 265)))
        );

        contenedor.addTab("BUSCAR ALUMNO", panel1);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        txt_nombre_a.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRES"));
        txt_nombre_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_aActionPerformed(evt);
            }
        });

        txt_dni_a.setBorder(javax.swing.BorderFactory.createTitledBorder("DNI"));

        txt_telefono_a.setBorder(javax.swing.BorderFactory.createTitledBorder("TELÉFONO"));

        btnagregarcli.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnagregarcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/39_104850.png"))); // NOI18N
        btnagregarcli.setText("REGISTRAR ALUMNO");
        btnagregarcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarcliActionPerformed(evt);
            }
        });

        btnlimpiarcli.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnlimpiarcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/28_104847.png"))); // NOI18N
        btnlimpiarcli.setText("LIMPIAR");
        btnlimpiarcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarcliActionPerformed(evt);
            }
        });

        table_alumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRES", "APELLIDO", "GENERO", "DNI", "DISTRITO", "DIRECCIÓN", "TELEFONO", "GRADO ELECITOV"
            }
        ));
        table_alumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_alumnoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_alumno);
        if (table_alumno.getColumnModel().getColumnCount() > 0) {
            table_alumno.getColumnModel().getColumn(0).setPreferredWidth(30);
            table_alumno.getColumnModel().getColumn(1).setPreferredWidth(30);
            table_alumno.getColumnModel().getColumn(2).setPreferredWidth(5);
            table_alumno.getColumnModel().getColumn(3).setPreferredWidth(5);
            table_alumno.getColumnModel().getColumn(4).setPreferredWidth(30);
            table_alumno.getColumnModel().getColumn(5).setPreferredWidth(200);
            table_alumno.getColumnModel().getColumn(6).setPreferredWidth(5);
            table_alumno.getColumnModel().getColumn(7).setPreferredWidth(20);
        }

        btnmodificarcli.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnmodificarcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/17_104874.png"))); // NOI18N
        btnmodificarcli.setText("MODIFICAR");
        btnmodificarcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarcliActionPerformed(evt);
            }
        });

        btneliminarcli.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btneliminarcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/36_104857 (1).png"))); // NOI18N
        btneliminarcli.setText("ELIMINAR");
        btneliminarcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarcliActionPerformed(evt);
            }
        });

        btnEnviarCliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEnviarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/10_104859.png"))); // NOI18N
        btnEnviarCliente.setText("ENVIAR ALUMNO");
        btnEnviarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarClienteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("Tabla de Alumnos");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setText("Registros de Alumnos");

        txt_apellido_a.setBorder(javax.swing.BorderFactory.createTitledBorder("APELLIDOS"));
        txt_apellido_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellido_aActionPerformed(evt);
            }
        });

        txt_direccion_a.setBorder(javax.swing.BorderFactory.createTitledBorder("DIRECCIÓN"));

        combo_distrito_a.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lima Cercado", "Pucusana", "Ancón", "Pueblo Libre", "Ate", "Puente Piedra", "Barranco", "Punta Hermosa", "Breña", "Punta Negra", "Carabayllo", "Rímac", "Chaclacayo", "San Bartolo", "Chorrillos", "San Borja", "Cieneguilla", "San Isidro", "Comas", "San Juan de Lurigancho", "El Agustino", "San Juan de Miraflores", "Independencia", "San Luis", "Jesús María", "San Martín de Porres", "La Molina", "San Miguel", "La Victoria", "Santa Anita", "Lince 150138 Santa María del Mar", "Los Olivos", "Santa Rosa", "Lurigancho", "Santiago de Surco", "Lurín", "Surquillo", "Magdalena del Mar", "Villa El Salvador", "Miraflores", "Villa María del Triunfo", "Pachacámac" }));
        combo_distrito_a.setToolTipText("");
        combo_distrito_a.setBorder(javax.swing.BorderFactory.createTitledBorder("DISTRITO"));
        combo_distrito_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_distrito_aActionPerformed(evt);
            }
        });

        combo_genero_a.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMENINO", "MASCULINO", " " }));
        combo_genero_a.setBorder(javax.swing.BorderFactory.createTitledBorder("GENERO"));

        combo_año_electivo_a.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inicial - 3 años", "Inicial - 4 años", "Inicial - 5 años", "Primer grado - primaria", "Seundo grado - primaria", "Tercer grado - primaria", "Cuato grado - primaria", "Quinto grado - primaria", "Sexto grado - primaria", "Primer grado - secunadaria", "Seundo grado- secunadaria", "Tercer grado- secunadaria", "Cuato grado - secunadaria", "Quinto grado - secunadaria", " " }));
        combo_año_electivo_a.setBorder(javax.swing.BorderFactory.createTitledBorder("GRADO ELECTIVO"));

        date_años_a.setBorder(javax.swing.BorderFactory.createTitledBorder("FECHA DE NACIMINETO"));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnagregarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(btnmodificarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(btnlimpiarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(btneliminarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(btnEnviarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombre_a, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_distrito_a, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txt_apellido_a, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                .addGap(26, 26, 26)
                                .addComponent(date_años_a, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_direccion_a))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_telefono_a)
                            .addComponent(combo_genero_a, 0, 211, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_dni_a)
                            .addComponent(combo_año_electivo_a, 0, 187, Short.MAX_VALUE)))
                    .addComponent(jScrollPane6))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel9)
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(combo_genero_a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_dni_a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txt_nombre_a)
                        .addComponent(txt_apellido_a))
                    .addComponent(date_años_a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_distrito_a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_direccion_a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefono_a, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_año_electivo_a, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        contenedor.addTab("REGISTRO DE ALUMNOS", jPanel7);

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setText("Registros de padres o apoderados");

        txt_nombre_p.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRES"));
        txt_nombre_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_pActionPerformed(evt);
            }
        });

        txt_apellido_a1.setBorder(javax.swing.BorderFactory.createTitledBorder("APELLIDOS"));
        txt_apellido_a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellido_a1ActionPerformed(evt);
            }
        });

        combo_genero_a1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMENINO", "MASCULINO", " " }));
        combo_genero_a1.setBorder(javax.swing.BorderFactory.createTitledBorder("GENERO"));

        txt_dni_a2.setBorder(javax.swing.BorderFactory.createTitledBorder("DNI"));

        txt_telefono_a1.setBorder(javax.swing.BorderFactory.createTitledBorder("TELÉFONO"));

        txt_direccion_a1.setBorder(javax.swing.BorderFactory.createTitledBorder("DIRECCIÓN"));

        combo_distrito_a1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lima Cercado", "Pucusana", "Ancón", "Pueblo Libre", "Ate", "Puente Piedra", "Barranco", "Punta Hermosa", "Breña", "Punta Negra", "Carabayllo", "Rímac", "Chaclacayo", "San Bartolo", "Chorrillos", "San Borja", "Cieneguilla", "San Isidro", "Comas", "San Juan de Lurigancho", "El Agustino", "San Juan de Miraflores", "Independencia", "San Luis", "Jesús María", "San Martín de Porres", "La Molina", "San Miguel", "La Victoria", "Santa Anita", "Lince 150138 Santa María del Mar", "Los Olivos", "Santa Rosa", "Lurigancho", "Santiago de Surco", "Lurín", "Surquillo", "Magdalena del Mar", "Villa El Salvador", "Miraflores", "Villa María del Triunfo", "Pachacámac" }));
        combo_distrito_a1.setToolTipText("");
        combo_distrito_a1.setBorder(javax.swing.BorderFactory.createTitledBorder("DISTRITO"));
        combo_distrito_a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_distrito_a1ActionPerformed(evt);
            }
        });

        table_padres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRES", "APELLIDO", "GENERO", "DNI", "DISTRITO", "DIRECCIÓN", "TELEFONO"
            }
        ));
        table_padres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_padresMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(table_padres);
        if (table_padres.getColumnModel().getColumnCount() > 0) {
            table_padres.getColumnModel().getColumn(0).setPreferredWidth(30);
            table_padres.getColumnModel().getColumn(1).setPreferredWidth(30);
            table_padres.getColumnModel().getColumn(2).setPreferredWidth(5);
            table_padres.getColumnModel().getColumn(3).setPreferredWidth(5);
            table_padres.getColumnModel().getColumn(4).setPreferredWidth(30);
            table_padres.getColumnModel().getColumn(5).setPreferredWidth(200);
            table_padres.getColumnModel().getColumn(6).setPreferredWidth(5);
        }

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setText("Tabla de padres o apoderados");

        btnagregarcli1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnagregarcli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/39_104850.png"))); // NOI18N
        btnagregarcli1.setText("REGISTRAR PADRES");
        btnagregarcli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarcli1ActionPerformed(evt);
            }
        });

        btnmodificarcli1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnmodificarcli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/17_104874.png"))); // NOI18N
        btnmodificarcli1.setText("MODIFICAR");
        btnmodificarcli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarcli1ActionPerformed(evt);
            }
        });

        btnlimpiarcli2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnlimpiarcli2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/28_104847.png"))); // NOI18N
        btnlimpiarcli2.setText("LIMPIAR");
        btnlimpiarcli2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarcli2ActionPerformed(evt);
            }
        });

        btneliminarcli1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btneliminarcli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/36_104857 (1).png"))); // NOI18N
        btneliminarcli1.setText("ELIMINAR");
        btneliminarcli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarcli1ActionPerformed(evt);
            }
        });

        btnEnviarCliente2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEnviarCliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/10_104859.png"))); // NOI18N
        btnEnviarCliente2.setText("ENVIAR PADRES");
        btnEnviarCliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCliente2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(btnagregarcli1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(btnmodificarcli1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(btnlimpiarcli2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(btneliminarcli1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(btnEnviarCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombre_p, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_distrito_a1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(txt_apellido_a1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                .addGap(35, 35, 35)
                                .addComponent(combo_genero_a1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))
                            .addComponent(txt_direccion_a1))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_telefono_a1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dni_a2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane9))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel10)
                .addGap(36, 36, 36)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nombre_p, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_apellido_a1)
                        .addComponent(combo_genero_a1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_dni_a2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_distrito_a1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_direccion_a1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefono_a1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregarcli1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificarcli1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiarcli2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminarcli1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        contenedor.addTab("REGISTRAR PADRES", panel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtcodigo10.setBorder(javax.swing.BorderFactory.createTitledBorder("CODIGO"));

        btnGenerarVenta2.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarVenta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        btnGenerarVenta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVenta2ActionPerformed(evt);
            }
        });

        txtclientedatos1.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRES Y APELLIDOS"));

        txtdni1.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefono"));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total a Pagar:");

        txtdni2.setBorder(javax.swing.BorderFactory.createTitledBorder("DNI / RUC"));

        txtprecio3.setBorder(javax.swing.BorderFactory.createTitledBorder("CORREO"));

        btnregresar.setText("GUARDAR");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });

        btnregresar1.setText("REGISTRAR");
        btnregresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresar1ActionPerformed(evt);
            }
        });

        txtbuscarventa.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR VENTA"));
        txtbuscarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarventaActionPerformed(evt);
            }
        });
        txtbuscarventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarventaKeyReleased(evt);
            }
        });

        btnbuscar1.setBackground(new java.awt.Color(51, 255, 51));
        btnbuscar1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnbuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/11_104884 (1).png"))); // NOI18N
        btnbuscar1.setText("RESETEAR");
        btnbuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar1ActionPerformed(evt);
            }
        });

        tablabuscarventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablabuscarventa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablabuscarventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablabuscarventaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablabuscarventaMouseEntered(evt);
            }
        });
        tablabuscarventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablabuscarventaKeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(tablabuscarventa);

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));

        txt_total_pagar.setBorder(javax.swing.BorderFactory.createTitledBorder("TOTAL A PAGAR"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigo10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnGenerarVenta2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_total_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnregresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtprecio3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdni1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdni2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46))))
                    .addComponent(txtclientedatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 142, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtbuscarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtclientedatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbuscarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcodigo10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdni2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtdni1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtprecio3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 53, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(txt_total_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(86, 86, 86))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnGenerarVenta2)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnregresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(44, 44, 44))))))
        );

        contenedor.addTab("COMPROBANTE DE PAGO", jPanel3);

        panel3.setBackground(new java.awt.Color(255, 255, 255));

        txtbuscar_padres.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar padres, por nombre apelllido o dni"));
        txtbuscar_padres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar_padresActionPerformed(evt);
            }
        });
        txtbuscar_padres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar_padresKeyReleased(evt);
            }
        });

        btnbuscar2.setBackground(new java.awt.Color(255, 255, 51));
        btnbuscar2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnbuscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/11_104884 (1).png"))); // NOI18N
        btnbuscar2.setText("ACTUALIZAR");
        btnbuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar2ActionPerformed(evt);
            }
        });

        btnregresar17.setBackground(new java.awt.Color(102, 255, 102));
        btnregresar17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnregresar17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/39_104850.png"))); // NOI18N
        btnregresar17.setText("AGREGAR PADRE");
        btnregresar17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresar17ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("Busqueda de padres de la institucion educativa Fe y Alegia");

        btnEnviarCliente3.setBackground(new java.awt.Color(102, 102, 255));
        btnEnviarCliente3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEnviarCliente3.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviarCliente3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/10_104859.png"))); // NOI18N
        btnEnviarCliente3.setText("ENVIAR PADRE");
        btnEnviarCliente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCliente3ActionPerformed(evt);
            }
        });

        table_buscar_padres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRES", "APELLIDO", "GENERO", "DNI", "DISTRITO", "DIRECCIÓN", "TELEFONO"
            }
        ));
        table_buscar_padres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_buscar_padresMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(table_buscar_padres);
        if (table_buscar_padres.getColumnModel().getColumnCount() > 0) {
            table_buscar_padres.getColumnModel().getColumn(0).setPreferredWidth(30);
            table_buscar_padres.getColumnModel().getColumn(1).setPreferredWidth(30);
            table_buscar_padres.getColumnModel().getColumn(2).setPreferredWidth(5);
            table_buscar_padres.getColumnModel().getColumn(3).setPreferredWidth(5);
            table_buscar_padres.getColumnModel().getColumn(4).setPreferredWidth(30);
            table_buscar_padres.getColumnModel().getColumn(5).setPreferredWidth(200);
            table_buscar_padres.getColumnModel().getColumn(6).setPreferredWidth(5);
        }

        txt_nombre_a5.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRES"));
        txt_nombre_a5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_a5ActionPerformed(evt);
            }
        });

        txt_apellido_a3.setBorder(javax.swing.BorderFactory.createTitledBorder("APELLIDOS"));
        txt_apellido_a3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellido_a3ActionPerformed(evt);
            }
        });

        txt_dni_a5.setBorder(javax.swing.BorderFactory.createTitledBorder("DNI"));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(txtbuscar_padres, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(1019, Short.MAX_VALUE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                    .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addComponent(btnregresar17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addComponent(txt_nombre_a5, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txt_apellido_a3)
                                            .addGap(18, 18, 18)
                                            .addComponent(txt_dni_a5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(45, 45, 45)))
                                    .addComponent(btnEnviarCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel13)
                .addGap(21, 21, 21)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar_padres, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dni_a5)
                    .addComponent(txt_nombre_a5, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(txt_apellido_a3))
                .addGap(25, 25, 25)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnregresar17, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        contenedor.addTab("BUSCAR PADRES", panel3);

        jPanel1.add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 1480, 634));

        lblnombre.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 595, 41));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Administrador");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 41));

        btnsalir1.setBackground(new java.awt.Color(255, 102, 102));
        btnsalir1.setText("SALIR");
        btnsalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 870, 151, 44));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/32_104802.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 70, 49, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga png.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 150, 160));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo grande 1.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1730, 930));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnsalir1ActionPerformed

    private void tablabuscarventaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablabuscarventaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablabuscarventaKeyReleased

    private void tablabuscarventaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablabuscarventaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablabuscarventaMouseEntered

    private void tablabuscarventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablabuscarventaMouseClicked

        int seleccion = tablabuscarventa.rowAtPoint(evt.getPoint());
        txtcodigo10.setText(String.valueOf(tablabuscarventa.getValueAt(seleccion, 1)));
        txtproductoventa.setText(String.valueOf(tablabuscarventa.getValueAt(seleccion, 2)));
        txtcantidad1.setText(String.valueOf(tablabuscarventa.getValueAt(seleccion, 4)));
        txtprecio1.setText(String.valueOf(tablabuscarventa.getValueAt(seleccion, 5)));
        txtclientedatos1.setText(String.valueOf(tablabuscarventa.getValueAt(seleccion, 6)));
        txtdni2.setText(String.valueOf(tablabuscarventa.getValueAt(seleccion, 7)));
        txtdni1.setText(String.valueOf(tablabuscarventa.getValueAt(seleccion, 8)));
        txtprecio3.setText(String.valueOf(tablabuscarventa.getValueAt(seleccion, 9)));

       

        // try {
            //int fila = tablabuscarventa.getSelectedRow();
            //int id = Integer.parseInt(tablabuscarventa.getValueAt(fila, 0).toString());

            /*PreparedStatement ps;
            ResultSet rs;

            Connection con = Conexion_DAO.conectar();
            ps = con.prepareStatement("SELECT CODIGO,PRODUCTO,DESCRIPCION,CANTIDAD,PRECIO,NOMBREAPELLIDO,DNIRUC, NUMERO,CORREO * FROM venta");

            //ps.setInt(5, id);
            rs = ps.executeQuery();

            while(rs.next()){

                txtcodigo10.setText(rs.getString("CODIGO"));
                txtcodigo1.setText(rs.getString("PRODUCTO"));
                txtdescripcion1.setText(rs.getString("DESCRIPCION"));
                txtcantidad1.setText(rs.getString("CANTIDAD"));
                txtprecio1.setText(rs.getString("PRECIO"));
                txtclientedatos1.setText(rs.getString("NOMBREAPELLIDO"));
                txtdni2.setText(rs.getString("DNIRUC"));
                txtdni1.setText(rs.getString("NUMERO"));
                txtprecio3.setText(rs.getString("CORREO"));

            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());

        }*/
  
    }//GEN-LAST:event_tablabuscarventaMouseClicked

    private void btnbuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar1ActionPerformed
      
        limpiarboleta();
    }//GEN-LAST:event_btnbuscar1ActionPerformed

    private void txtbuscarventaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarventaKeyReleased
        cargartablaventa(txtbuscarventa.getText());
    }//GEN-LAST:event_txtbuscarventaKeyReleased

    private void txtbuscarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarventaActionPerformed

    private void btnGenerarVenta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVenta2ActionPerformed

    }//GEN-LAST:event_btnGenerarVenta2ActionPerformed

    private void btnEnviarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCliente1ActionPerformed
        nombre_alumno.setText(txt_nombre_a3.getText());
        apellido_alumno.setText(txt_apellido_a2.getText());
        dni_alumno.setText(txt_dni_a3.getText());
        año_alumno.setText(txt_dni_a4.getText());
     

        contenedor.setSelectedIndex(0);
       
      

    }//GEN-LAST:event_btnEnviarCliente1ActionPerformed

    private void btnregresar16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresar16ActionPerformed

        contenedor.setSelectedIndex(2);
    }//GEN-LAST:event_btnregresar16ActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        cargartabla("");
        txtbuscar.setText(null);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        cargartabla(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void combo_distrito_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_distrito_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_distrito_aActionPerformed

    private void txt_apellido_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellido_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellido_aActionPerformed

    private void btnEnviarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarClienteActionPerformed

        txtclientedatos.setText(nombre_alumno.getText());
        nombre_padre_m.setText(txt_dni_a.getText());
        txtnumero.setText(txt_telefono_a.getText());
      

        contenedor.setSelectedIndex(0);
       
    }//GEN-LAST:event_btnEnviarClienteActionPerformed

    private void btneliminarcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarcliActionPerformed

     /*  try {
            int i =   cliente_crud.eliminarcli(txt_nombre_a.getText(),Integer.parseInt(txt_dni_a.getText()),Integer.parseInt(txt_telefono_a.getText()),txtcorreocli.getText());
            if (i>0){

                JOptionPane.showMessageDialog(this,"Cliente eliminado con exito");
            }
            else {
                JOptionPane.showMessageDialog(this,"No se pudo eliminar . Intente mas tarde");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        limpiarcli();
        cargarTablacli();*/
    }//GEN-LAST:event_btneliminarcliActionPerformed

    private void btnmodificarcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarcliActionPerformed

       /* try {
            int i =   cliente_crud.updatecli(txt_nombre_a.getText(),Integer.parseInt(txt_dni_a.getText()),Integer.parseInt(txt_telefono_a.getText()),txtcorreocli.getText());
            if (i>0){
                JOptionPane.showMessageDialog(this,"Cliente modificado con exito");
            }
            else {
                JOptionPane.showMessageDialog(this,"No se pudo actualizar . Intente mas tarde");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        cargarTablacli();
        limpiarcli();*/
    }//GEN-LAST:event_btnmodificarcliActionPerformed

    private void table_alumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_alumnoMouseClicked
        int seleccion = table_alumno.rowAtPoint(evt.getPoint());
        txt_nombre_a.setText(String.valueOf(table_alumno.getValueAt(seleccion, 0)));
        txt_dni_a.setText(String.valueOf(table_alumno.getValueAt(seleccion, 1)));
        txt_telefono_a.setText(String.valueOf(table_alumno.getValueAt(seleccion, 2)));
       

        cargarTablacli();
    }//GEN-LAST:event_table_alumnoMouseClicked

    private void btnlimpiarcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarcliActionPerformed

        Limpiar_tabla_alumnos();
       
    }//GEN-LAST:event_btnlimpiarcliActionPerformed

    private void btnagregarcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarcliActionPerformed

        try {
            int i =   alumno_crud.guardar_alumno(txt_nombre_a.getText(),txt_apellido_a.getText(),(String) combo_genero_a.getSelectedItem(),Integer.parseInt(txt_dni_a.getText()),(String) combo_distrito_a.getSelectedItem(),txt_direccion_a.getText(),Integer.parseInt(txt_telefono_a.getText()),(String) combo_año_electivo_a.getSelectedItem());
            if (i>0){
                JOptionPane.showMessageDialog(this,"Alumno registrado con exito");
            }
            else {
                JOptionPane.showMessageDialog(this,"No se pudo registrar. Intente mas tarde");
            }
        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null, ex.toString());

        }
        CargarTablaAlumno();
        Limpiar_tabla_alumnos();
    }//GEN-LAST:event_btnagregarcliActionPerformed

    private void txt_nombre_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_aActionPerformed

    private void btn_actualizar_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_ventaActionPerformed

      /*  try {
            int i =   venta_crud.updateventa(Integer.parseInt(txtcantidad.getText()),txtproductoVENTA.getText());
            if (i>0){
                JOptionPane.showMessageDialog(this,"Pedido actulizada con exito");
            }
            else {
                JOptionPane.showMessageDialog(this,"No se pudo actualizar el pedido. Intente mas tarde");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
        cargarTablaventa();
        limpiarventa();
        calcular();*/
    }//GEN-LAST:event_btn_actualizar_ventaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        contenedor.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnregresar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresar10ActionPerformed
        contenedor.setSelectedIndex(5);
    }//GEN-LAST:event_btnregresar10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            int i =   matricula_crud.GuardarMatricula(Integer.parseInt(txtcodigoVENTA.getText()),nombre_alumno.getText(),apellido_alumno.getText(),Integer.parseInt(dni_alumno.getText()),año_alumno.getText(),(String) estado_matricula_p.getSelectedItem(),nombre_padre_m.getText(),txtclientedatos.getText());
            if (i>0){
                JOptionPane.showMessageDialog(this,"Matricula registrada con exito");
            }
            else {
                JOptionPane.showMessageDialog(this,"No se pudo registrar la matricula. Intente mas tarde");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
        CargarTablaMatricula();
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabla_matriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_matriculaMouseClicked

        int seleccion = tabla_matricula.rowAtPoint(evt.getPoint());
        jTextField1.setText(String.valueOf(tabla_matricula.getValueAt(seleccion, 1)));
        nombre_alumno.setText(String.valueOf(tabla_matricula.getValueAt(seleccion, 2)));
        apellido_alumno.setText(String.valueOf(tabla_matricula.getValueAt(seleccion, 3)));
  
        txtclientedatos.setText(String.valueOf(tabla_matricula.getValueAt(seleccion, 6)));
        nombre_padre_m.setText(String.valueOf(tabla_matricula.getValueAt(seleccion, 7)));
        txtnumero.setText(String.valueOf(tabla_matricula.getValueAt(seleccion, 8)));
     

     
    }//GEN-LAST:event_tabla_matriculaMouseClicked

    private void btn_boletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_boletaActionPerformed

    
        Conexion con = new Conexion();
        Connection conn = Conexion_DAO.conectar();

        JasperReport reporte = null;
        String path = "src\\APP\\newReport.jasper";

        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            JasperViewer view = new JasperViewer(jprint,false);

            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(VISTA_FORMULARIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_boletaActionPerformed

    private void btnEliminarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarventaActionPerformed
      /*    try {
            int i =   venta_crud.eliminarventa(Integer.parseInt(txtcodigoVENTA.getText()),txtproductoVENTA.getText(),txtdescripcion1.getText(),Integer.parseInt(txtcantidad.getText()),Integer.parseInt(txtprecio.getText()),txtclientedatos.getText(),Integer.parseInt(txtdniruc.getText()),Integer.parseInt(txtnumero.getText()),txtcorreo.getText());
            if (i>0){
                JOptionPane.showMessageDialog(this,"Pedido eliminado con exito");
            }
            else {
                JOptionPane.showMessageDialog(this,"No se pudo eliminar el pedido. Intente mas tarde");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }

        try {
            int i =  precio_igv.eliminarigv(Integer.parseInt(txtdniruc.getText()),txt_precio_total.getText(),txt_igv.getText(),txt_valortotal.getText());
            if (i>0){
                JOptionPane.showMessageDialog(this,"Pedido eliminado con exito");
            }
            else {
                JOptionPane.showMessageDialog(this,"No se pudo eliminar el pedido. Intente mas tarde");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
        cargarTablaventa();
        limpiarventa();
        calcular();*/
    }//GEN-LAST:event_btnEliminarventaActionPerformed

    private void txt_nombre_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_pActionPerformed

    private void txt_apellido_a1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellido_a1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellido_a1ActionPerformed

    private void combo_distrito_a1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_distrito_a1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_distrito_a1ActionPerformed

    private void table_padresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_padresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_padresMouseClicked

    private void btnagregarcli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarcli1ActionPerformed
       
        try {
            int i =   padres_crud.guardar_padres(txt_nombre_p.getText(),txt_apellido_a1.getText(),(String) combo_genero_a1.getSelectedItem(),Integer.parseInt(txt_dni_a2.getText()),(String) combo_distrito_a1.getSelectedItem(),txt_direccion_a1.getText(),Integer.parseInt(txt_telefono_a1.getText()));
            if (i>0){
                JOptionPane.showMessageDialog(this,"Padre registrado con exito");
            }
            else {
                JOptionPane.showMessageDialog(this,"No se pudo registrar. Intente mas tarde");
            }
        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null, ex.toString());

        }
        CargarTablaPadres();
        
    }//GEN-LAST:event_btnagregarcli1ActionPerformed

    private void btnmodificarcli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarcli1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmodificarcli1ActionPerformed

    private void btnlimpiarcli2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarcli2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlimpiarcli2ActionPerformed

    private void btneliminarcli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarcli1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarcli1ActionPerformed

    private void btnEnviarCliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCliente2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarCliente2ActionPerformed

    private void table_buscar_alumnos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_buscar_alumnos1MouseClicked
        int seleccion = table_alumno.rowAtPoint(evt.getPoint());
        txt_nombre_a3.setText(String.valueOf(table_alumno.getValueAt(seleccion, 0)));
        txt_apellido_a2.setText(String.valueOf(table_alumno.getValueAt(seleccion, 1)));
        txt_dni_a3.setText(String.valueOf(table_alumno.getValueAt(seleccion, 3)));  
        txt_dni_a4.setText(String.valueOf(table_alumno.getValueAt(seleccion, 7))); 
    }//GEN-LAST:event_table_buscar_alumnos1MouseClicked

    private void txt_nombre_a2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_a2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_a2ActionPerformed

    private void txt_nombre_a3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_a3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_a3ActionPerformed

    private void txt_apellido_a2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellido_a2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellido_a2ActionPerformed

    private void txtbuscar_padresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar_padresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_padresActionPerformed

    private void txtbuscar_padresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar_padresKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_padresKeyReleased

    private void btnbuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar2ActionPerformed
         cargartabla1("");
        txtbuscar_padres.setText(null);
    }//GEN-LAST:event_btnbuscar2ActionPerformed

    private void btnregresar17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresar17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnregresar17ActionPerformed

    private void btnEnviarCliente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCliente3ActionPerformed
        nombre_padre_m.setText(txt_nombre_a5.getText());
        txtclientedatos.setText(txt_apellido_a3.getText());
        txtnumero.setText(txt_dni_a5.getText());
       
     

        contenedor.setSelectedIndex(0);
    }//GEN-LAST:event_btnEnviarCliente3ActionPerformed

    private void table_buscar_padresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_buscar_padresMouseClicked
        int seleccion = table_buscar_padres.rowAtPoint(evt.getPoint());
        txt_nombre_a5.setText(String.valueOf(table_buscar_padres.getValueAt(seleccion, 0)));
        txt_apellido_a3.setText(String.valueOf(table_buscar_padres.getValueAt(seleccion, 1)));
        txt_dni_a5.setText(String.valueOf(table_buscar_padres.getValueAt(seleccion, 3)));  
        
    }//GEN-LAST:event_table_buscar_padresMouseClicked

    private void txt_nombre_a5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_a5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_a5ActionPerformed

    private void txt_apellido_a3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellido_a3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellido_a3ActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        VISTA_INICIO ventana = new VISTA_INICIO();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnregresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnregresar1ActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VISTA_FORMULARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VISTA_FORMULARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VISTA_FORMULARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VISTA_FORMULARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VISTA_FORMULARIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido_alumno;
    private javax.swing.JTextField año_alumno;
    private javax.swing.JButton btnEliminarventa;
    private javax.swing.JButton btnEnviarCliente;
    private javax.swing.JButton btnEnviarCliente1;
    private javax.swing.JButton btnEnviarCliente2;
    private javax.swing.JButton btnEnviarCliente3;
    private javax.swing.JButton btnGenerarVenta1;
    private javax.swing.JButton btnGenerarVenta2;
    private javax.swing.JButton btn_actualizar_venta;
    private javax.swing.JButton btn_boleta;
    private javax.swing.JButton btnagregarcli;
    private javax.swing.JButton btnagregarcli1;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnbuscar1;
    private javax.swing.JButton btnbuscar2;
    private javax.swing.JButton btneliminarcli;
    private javax.swing.JButton btneliminarcli1;
    private javax.swing.JButton btnlimpiarcli;
    private javax.swing.JButton btnlimpiarcli2;
    private javax.swing.JButton btnmodificarcli;
    private javax.swing.JButton btnmodificarcli1;
    private javax.swing.JButton btnregresar;
    private javax.swing.JButton btnregresar1;
    private javax.swing.JButton btnregresar10;
    private javax.swing.JButton btnregresar16;
    private javax.swing.JButton btnregresar17;
    private javax.swing.JButton btnsalir1;
    private javax.swing.JButton btnsalir3;
    private javax.swing.JComboBox<String> combo_año_electivo_a;
    private javax.swing.JComboBox<String> combo_distrito_a;
    private javax.swing.JComboBox<String> combo_distrito_a1;
    private javax.swing.JComboBox<String> combo_genero_a;
    private javax.swing.JComboBox<String> combo_genero_a1;
    public javax.swing.JTabbedPane contenedor;
    private com.toedter.calendar.JDateChooser date_años_a;
    private javax.swing.JTextField dni_alumno;
    private javax.swing.JComboBox<String> estado_matricula_p;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JLabel lblnombre;
    private javax.swing.JTextField nombre_alumno;
    private javax.swing.JTextField nombre_padre_m;
    public javax.swing.JPanel panel1;
    public javax.swing.JPanel panel2;
    public javax.swing.JPanel panel3;
    private javax.swing.JTable tabla_matricula;
    public javax.swing.JTable tablabuscarventa;
    public javax.swing.JTable table_alumno;
    public javax.swing.JTable table_buscar_alumnos1;
    public javax.swing.JTable table_buscar_padres;
    public javax.swing.JTable table_padres;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txt_apellido_a;
    private javax.swing.JTextField txt_apellido_a1;
    private javax.swing.JTextField txt_apellido_a2;
    private javax.swing.JTextField txt_apellido_a3;
    private javax.swing.JTextField txt_direccion_a;
    private javax.swing.JTextField txt_direccion_a1;
    private javax.swing.JTextField txt_dni_a;
    private javax.swing.JTextField txt_dni_a2;
    private javax.swing.JTextField txt_dni_a3;
    private javax.swing.JTextField txt_dni_a4;
    private javax.swing.JTextField txt_dni_a5;
    private javax.swing.JTextField txt_nombre_a;
    private javax.swing.JTextField txt_nombre_a2;
    private javax.swing.JTextField txt_nombre_a3;
    private javax.swing.JTextField txt_nombre_a5;
    private javax.swing.JTextField txt_nombre_p;
    private javax.swing.JTextField txt_telefono_a;
    private javax.swing.JTextField txt_telefono_a1;
    private javax.swing.JTextField txt_total_pagar;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtbuscar_padres;
    private javax.swing.JTextField txtbuscarventa;
    private javax.swing.JTextField txtclientedatos;
    private javax.swing.JTextField txtclientedatos1;
    private javax.swing.JTextField txtcodigo10;
    private javax.swing.JTextField txtcodigoVENTA;
    private javax.swing.JTextField txtdni1;
    private javax.swing.JTextField txtdni2;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtprecio3;
    private javax.swing.JLabel txtsuma2;
    // End of variables declaration//GEN-END:variables

 
}
