/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickorder2.Registro;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static quickorder2.Registro.Herramientas.Imagenes.SeleccionarImagen;
import static quickorder2.Registro.Herramientas.Imagenes.convertirImagen;
import quickorder2.Registro.Herramientas.SelectorMultiple;
import quickorder2.Registro.Herramientas.SelectorSimple;

/**
 *
 * @author Mauro
 */
public class Promocion extends javax.swing.JInternalFrame {

    public webservices.DataRestaurante restaurante = null;
    public webservices.DataProdPromo[] productos = new webservices.DataProdPromo[]{};

    /**
     * Creates new form Promocion
     */
    public Promocion() {
        initComponents();
        cargarTabla(productos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscarR1 = new javax.swing.JButton();
        txtRestaurante1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        btnBuscarR = new javax.swing.JButton();
        txtRestaurante = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnRegistrar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtImagen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnExplorar = new javax.swing.JButton();
        btnMostrarImg = new javax.swing.JButton();

        btnBuscarR1.setText("Buscar");
        btnBuscarR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarR1ActionPerformed(evt);
            }
        });

        txtRestaurante1.setEditable(false);
        txtRestaurante1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Restaurante:");

        jLabel3.setText("Nombre:");

        setClosable(true);

        btnBuscarR.setText("Buscar");
        btnBuscarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRActionPerformed(evt);
            }
        });

        txtRestaurante.setEditable(false);
        txtRestaurante.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Restaurante:");

        jLabel5.setText("Nombre:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel6.setText("Productos:");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        jLabel4.setText("Subtotal:");

        txtSubtotal.setEditable(false);
        txtSubtotal.setBackground(new java.awt.Color(255, 255, 255));
        txtSubtotal.setText("$ ");

        jLabel7.setText("Descuento:");

        txtDescuento.setText("% ");
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

        jLabel8.setText("Total:");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setText("$ ");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnRegistrar1.setText("Registrar");
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel9.setText("Descripcion:");

        txtImagen.setEditable(false);
        txtImagen.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Imagen:");

        btnExplorar.setText("Explorar");
        btnExplorar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExplorarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnExplorarMouseReleased(evt);
            }
        });
        btnExplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExplorarActionPerformed(evt);
            }
        });

        btnMostrarImg.setText("Mostrar");
        btnMostrarImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMostrarImgMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnMostrarImgMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRestaurante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarR))
                            .addComponent(txtNombre)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSubtotal)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(txtTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuitar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtImagen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExplorar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMostrarImg)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExplorar)
                        .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMostrarImg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(btnQuitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar1)
                    .addComponent(btnRegistrar1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRActionPerformed
        if(restaurante != null){
            if(JOptionPane.showConfirmDialog(this, "Si cambia de restaurante los productos agregados seran eliminados.\nSeguro de que desea continuar?", "Advertencia", JOptionPane.WARNING_MESSAGE) == JOptionPane.CANCEL_OPTION){
                return;
            }
        }
        SelectorSimple s = new SelectorSimple(null);
        s.cargarRestaurantes();
        s.setVisible(true);
        this.restaurante = (webservices.DataRestaurante) s.resultado;
        txtRestaurante.setText(restaurante.getNombre());
        productos = new webservices.DataProdPromo[]{};
        cargarTabla(productos);
    }//GEN-LAST:event_btnBuscarRActionPerformed

    private void btnBuscarR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarR1ActionPerformed
        SelectorSimple s = new SelectorSimple(null);
        s.cargarRestaurantes();
        s.setVisible(true);
        this.restaurante = (webservices.DataRestaurante) s.resultado;
        txtRestaurante.setText(restaurante.getNombre());
    }//GEN-LAST:event_btnBuscarR1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtRestaurante.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un restaurante.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (quickorder2.QuickOrder2.port.buscarRestaurante(restaurante.getNickname()) == null) {
            JOptionPane.showMessageDialog(this, "El restaurante ingresado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            SelectorMultiple s = new SelectorMultiple(null);
            s.cargarIndividuales(productos, restaurante.getNickname());

            s.setVisible(true);
            productos = (webservices.DataProdPromo[]) s.resultado;
            
            cargarTabla(productos);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        HashMap aux = new HashMap();
        
        for(int i = 0 ; i < productos.length ; i++){
            aux.put(productos[i].getIndividual().getNombre(), productos[i]);
        }
        
        for(int i = 0 ; i < tablaProductos.getSelectedRows().length ; i++){
            aux.remove(tablaProductos.getValueAt(tablaProductos.getSelectedRows()[i], 0));
        }
        
        webservices.DataProdPromo[] resultado = new webservices.DataProdPromo[aux.values().size()];
        
        for(int i = 0 ; i < resultado.length ; i++){
            resultado[i] = (webservices.DataProdPromo) aux.values().toArray()[i];
        }
        productos = resultado;
        
        cargarTabla(productos);
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
                if (evt.getKeyChar() == '.') {
            if (txtDescuento.getText().contains(",")) {
                evt.setKeyChar('\u0000');
            } else {
                evt.setKeyChar(',');
            }
        }

        if (!((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyChar() == ',')) {
            evt.setKeyChar('\u0000');
        }

        if (txtDescuento.getText().equals("%") || txtDescuento.getText().isEmpty()) {
            txtDescuento.setText("% ");
        }
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        calcularTotales();
    }//GEN-LAST:event_txtDescuentoKeyReleased

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        if(verificarDatos()){
            boolean activa;
            try {
                if(JOptionPane.showConfirmDialog(this, "Desea registrar esta promocion como activa?", "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    activa = true;
                }else{
                    activa = false;
                }
                
                List<webservices.DataProdPromo> prods = new ArrayList<webservices.DataProdPromo>();
                
                for(int i = 0 ; i < productos.length ; i++){
                    prods.add(productos[i]);
                }
                quickorder2.QuickOrder2.port.insertarPromocion(txtNombre.getText(), txtDescripcion.getText(), convertirImagen(txtImagen.getText()), activa, Float.valueOf(txtDescuento.getText().substring(2)), restaurante.getNickname(), prods);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Promocion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void btnExplorarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExplorarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExplorarMousePressed

    private void btnExplorarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExplorarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExplorarMouseReleased

    private void btnExplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExplorarActionPerformed
        txtImagen.setText(SeleccionarImagen());
    }//GEN-LAST:event_btnExplorarActionPerformed

    private void btnMostrarImgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarImgMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarImgMousePressed

    private void btnMostrarImgMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarImgMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarImgMouseReleased

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Seguro de que desea cancelar el registro?", "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void cargarTabla(webservices.DataProdPromo[] productos) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Descripcion", "Precio individual", "Cantidad", "Subtotal"});
        for (webservices.DataProdPromo producto : productos) {
            modelo.addRow(new Object[]{producto.getIndividual().getNombre(), producto.getIndividual().getDescripcion(), "$ " + producto.getIndividual().getPrecio(), producto.getCantidad(), producto.getCantidad() * producto.getIndividual().getPrecio()});
        }
        tablaProductos.setModel(modelo);
        calcularTotales();
    }
    
    private void calcularTotales(){
        double subtotal = 0;
        for(int i = 0 ; i < tablaProductos.getRowCount() ; i++){
            subtotal += Double.valueOf(tablaProductos.getValueAt(i, tablaProductos.getColumnCount()-1).toString());
        }
        txtSubtotal.setText("$ " + subtotal);
        
        Double descuento;
                
        if(txtDescuento.getText().substring(2).isEmpty()){
            descuento = 0.0;
        }else{
            descuento = (Double.valueOf(txtDescuento.getText().substring(2)) /100) * Double.valueOf(txtSubtotal.getText().substring(2));
        }
        
        txtTotal.setText("$ " + String.valueOf(Double.valueOf(txtSubtotal.getText().substring(2)) - descuento));
    }
    
    private boolean verificarDatos(){
        if(restaurante==null){
            JOptionPane.showMessageDialog(this, "El campo 'Restaurante' es obligatorio.\n Ingrese un restaurante e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(quickorder2.QuickOrder2.port.buscarRestaurante(restaurante.getNickname()) == null){
            JOptionPane.showMessageDialog(this, "El restaurante seleccionado no es valido.\n Ingrese otro restaurante e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(txtNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo 'Nombre' es obligatorio.\n Ingrese un nombre e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(txtDescripcion.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo 'Descripcion' es obligatorio.\n Ingrese una descripcion e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(productos.length<1){
            JOptionPane.showMessageDialog(this, "La promocion debe contener al menos un producto.\n Ingrese un producto e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(txtDescuento.getText().substring(2).isEmpty() || Double.valueOf(txtDescuento.getText().substring(2)) <= 0){
            JOptionPane.showMessageDialog(this, "El campo 'Descuento' contiene un valor inválido.\n Ingrese un descuento mayor a 0% e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarR;
    private javax.swing.JButton btnBuscarR1;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnExplorar;
    private javax.swing.JButton btnMostrarImg;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtImagen;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtRestaurante;
    private javax.swing.JTextField txtRestaurante1;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
