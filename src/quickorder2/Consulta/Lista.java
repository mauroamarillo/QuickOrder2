/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickorder2.Consulta;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauro
 */
public class Lista extends javax.swing.JInternalFrame {

    /**
     * Creates new form Clientes
     */
    
    public Lista() {
        initComponents();
    }

    public void cargarClientes() {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        while(modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Nickname", "E-Mail"});
        
        List<Object> clientes = quickorder2.QuickOrder2.port.getDataClientes();

        Iterator it = clientes.iterator();

        while (it.hasNext()) {
            webservices.DataCliente cliente = (webservices.DataCliente) it.next();
            modelo.addRow(new Object[]{cliente.getNombre() + " " + cliente.getApellido(), cliente.getNickname(), cliente.getEmail()});
        }
        
        tabla.addMouseListener(new MouseAdapter() { 
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount()==2){
                        DetalleCliente w = new DetalleCliente(null, tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
                        w.setVisible(true);
                    }
                } 
         });
        
        tabla.setModel(modelo);
        this.setTitle("Clientes");
    }
    
    public void cargarRestaurantes() {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        while(tabla.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Nickname", "E-Mail"});
        
        List<Object> restaurantes = quickorder2.QuickOrder2.port.getDataRestaurantes();

        Iterator it = restaurantes.iterator();

        while (it.hasNext()) {
            webservices.DataRestaurante restaurante = (webservices.DataRestaurante) it.next();
            modelo.addRow(new Object[]{restaurante.getNombre(), restaurante.getNickname(), restaurante.getEmail()});
        }
        
        tabla.addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount()==2){
                        DetalleRestaurante w = new DetalleRestaurante(null, tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
                        w.setVisible(true);
                    }
                } 
         });
        
        tabla.setModel(modelo);
        this.setTitle("Restaurantes");
    }
    
    public void cargarPedidos() {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        while(tabla.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        modelo.setColumnIdentifiers(new Object[]{"Numero", "Restaurante", "Cliente", "Fecha"});
        
        Iterator pedidos = quickorder2.QuickOrder2.port.getInfoPedidos().iterator();

        while (pedidos.hasNext()) {
            webservices.DataPedido pedido = (webservices.DataPedido) pedidos.next();
            modelo.addRow(new Object[]{pedido.getNumero(), pedido.getRestaurante(), pedido.getCliente(), String.format("%02d/%02d/%d",pedido.getFecha().getDia(), pedido.getFecha().getMes(), pedido.getFecha().getAgno())});
        }
        
        tabla.addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount()==2){
                        DetallePedido w = new DetallePedido(null, Integer.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0).toString()));
                        w.setVisible(true);
                    }
                } 
         });
        
        tabla.setModel(modelo);
        this.setTitle("Pedidos");
    }
    
    public void cargarProductos(){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        while(tabla.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        modelo.setColumnIdentifiers(new Object[]{"Restaurante", "Nombre", "Descripcion", "Tipo",  "Precio"});
        
        Iterator individuales = quickorder2.QuickOrder2.port.getDataIndividuales().iterator();

        while (individuales.hasNext()) {
            webservices.DataIndividual individual = (webservices.DataIndividual) individuales.next();
            modelo.addRow(new Object[]{individual.getRestaurante(), individual.getNombre(), individual.getDescripcion(), "Individual",  "$ " + individual.getPrecio()});
        }
        
        Iterator promociones = quickorder2.QuickOrder2.port.getDataPromociones().iterator();
        
        while (promociones .hasNext()) {
            webservices.DataPromocion promocion = (webservices.DataPromocion) promociones.next();
            modelo.addRow(new Object[]{promocion.getRestaurante(), promocion.getNombre(), promocion.getDescripcion(), "Promocion",  "$ " + promocion.getPrecio()});
        }
        
        tabla.addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount()==2){
                        int i;
                        if(tabla.getValueAt(tabla.getSelectedRow(), 3).toString().equals("Individual"))
                            i = 0;
                        else
                            i = 1;
                            
                        DetalleProducto w = new DetalleProducto(null, i, tabla.getValueAt(tabla.getSelectedRow(), 0).toString(), tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
                        w.setVisible(true);
                    }
                } 
         });
        
        tabla.setModel(modelo);
        this.setTitle("Productos");
    }
    
    public void cargarVisitasRestaurante(){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        while(tabla.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        modelo.setColumnIdentifiers(new Object[]{"Nickname", "Nombre", "E-Mail", "Direccion",  "Visitas"});
        
        
        Iterator datos = quickorder2.QuickOrder2.port.consultarEstadisticasRestaurante().iterator();
        
        
        while(datos.hasNext()){
            String fila =  (String) datos.next();
            String[] mismo = fila.split("%");
            System.out.println(fila);
            modelo.addRow(mismo);
        }
        
        tabla.setModel(modelo);
    }
    
    public void cargarVisitasURL(){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        while(tabla.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        modelo.setColumnIdentifiers(new Object[]{"URL", "Visitas"});
        
        
        Iterator datos = quickorder2.QuickOrder2.port.consultarEstadisticasURL().iterator();
        
        
        while(datos.hasNext()){
            String fila =  (String) datos.next();
            String[] mismo = fila.split("%");
            System.out.println(fila);
            modelo.addRow(mismo);
        }
        
        tabla.setModel(modelo);
    }

    public void cargarVisitasSO(){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        while(tabla.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        modelo.setColumnIdentifiers(new Object[]{"Sistema Operativo", "Visitas"});
        
        
        Iterator datos = quickorder2.QuickOrder2.port.consultarEstadisticasSO().iterator();
        
        
        while(datos.hasNext()){
            String fila =  (String) datos.next();
            String[] mismo = fila.split("%");
            System.out.println(fila);
            modelo.addRow(mismo);
        }
        
        tabla.setModel(modelo);
    }
    
    public void cargarVisitasBrowser(){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        while(tabla.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        modelo.setColumnIdentifiers(new Object[]{"Navegador", "Visitas"});
        
        
        Iterator datos = quickorder2.QuickOrder2.port.consultarEstadisticasBrowser().iterator();
        
        
        while(datos.hasNext()){
            String fila =  (String) datos.next();
            String[] mismo = fila.split("%");
            System.out.println(fila);
            modelo.addRow(mismo);
        }
        
        tabla.setModel(modelo);
    }
    //cargar res

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setText("Filtro:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtFiltro)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

}
