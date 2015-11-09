/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickorder2.Consulta;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauro
 */
public class DetallePedido extends javax.swing.JDialog {

    webservices.DataPedido pedido = null;

    /**
     * Creates new form DetallePedido
     */
    public DetallePedido(java.awt.Frame parent, int numero) {
        super(parent, true);
        initComponents();
        this.setLocationRelativeTo(quickorder2.QuickOrder2.parent);
        this.setResizable(false);
        cargarDatos(numero);
    }

    public void cargarDatos(int numero) {
        pedido = quickorder2.QuickOrder2.port.getDataPedido(numero);
        limpiarTablas();

        lblNumero.setText(String.valueOf(pedido.getNumero()));
        lblCliente.setText(pedido.getCliente());
        lblRestaurante.setText(pedido.getRestaurante());
        lblFecha.setText(String.format("%02d/%02d/%d", pedido.getFecha().getDia(), pedido.getFecha().getMes(), pedido.getFecha().getAgno()));
        lblPrecio.setText("$" + pedido.getPrecio());
        lblEstado.setText(pedido.getEstado().value());

        prepararCambioEstado(pedido.getEstado().value());

        DefaultTableModel modeloHistorial = (DefaultTableModel) tablaEstado.getModel();

        modeloHistorial.setColumnIdentifiers(new Object[]{"Estado", "Fecha y Hora"});

        while (modeloHistorial.getRowCount() > 0) {
            modeloHistorial.removeRow(0);
        }

        Iterator cambios = quickorder2.QuickOrder2.port.retornarCambiosEstado(numero).iterator();

        while (cambios.hasNext()) {
            webservices.DataHistorialPedido cambio = (webservices.DataHistorialPedido) cambios.next();
            String estado = "";
            switch (cambio.getEstado()) {
                case 0:
                    estado = "En preparacion";
                    break;
                case 1:
                    estado = "Enviado";
                    break;
                case 2:
                    estado = "Recibido";
                    break;
                case 3:
                    estado = "A confirmar";
                    break;
            }
            modeloHistorial.addRow(new Object[]{estado, cambio.getFechaHora()});
        }

        tablaEstado.setModel(modeloHistorial);

        DefaultTableModel modeloDetalle = (DefaultTableModel) tablaDetalle.getModel();

        modeloDetalle.setColumnIdentifiers(new Object[]{"Producto", "Precio individual", "Cantidad", "Subtotal"});

        while (modeloDetalle.getRowCount() > 0) {
            modeloDetalle.removeRow(0);
        }

        Iterator detalles = quickorder2.QuickOrder2.port.pedidoGetProdPedidos(numero).iterator();

        while (detalles.hasNext()) {
            webservices.DataProdPedido linea = (webservices.DataProdPedido) detalles.next();
            modeloDetalle.addRow(new Object[]{linea.getProducto().getNombre(), "$" + linea.getProducto().getPrecio(), linea.getCantidad(), "$" + (linea.getProducto().getPrecio() * linea.getCantidad())});
        }

        tablaDetalle.setModel(modeloDetalle);

        this.setTitle("Datos del pedido N° " + pedido.getNumero());
    }
    
    private void limpiarTablas(){
        DefaultTableModel estado = (DefaultTableModel) tablaEstado.getModel();
        
        while(estado.getRowCount() > 0){
            estado.removeRow(0);
        }
        
        DefaultTableModel detalle = (DefaultTableModel) tablaDetalle.getModel();
        
        while(detalle.getRowCount() > 0){
            detalle.removeRow(0);
        }
    }

    private void prepararCambioEstado(String estado) {
        for (int i = 2; i < btnEstado.getMouseListeners().length; i++) {
            btnEstado.removeMouseListener(btnEstado.getMouseListeners()[i]);
        }

        if (estado.toLowerCase().equals("aconfirmar")) {
            btnEstado.setText("En Preparacion");
        }else if (estado.toLowerCase().equals("preparacion")) {
            btnEstado.setText("Enviado");
        }else if (estado.toLowerCase().equals("enviado")) {
            btnEstado.setText("Recibido");
        }else if (estado.toLowerCase().equals("recibido")) {
            btnEstado.setVisible(false);
        } 

        btnEstado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int siguienteEstado = 3;
                if (estado.toLowerCase().equals("aconfirmar")) {
                    btnEstado.setText("En Preparacion");
                    siguienteEstado = 0;
                }else if (estado.toLowerCase().equals("preparacion")) {
                    btnEstado.setText("Enviado");
                    siguienteEstado = 1;
                }else if (estado.toLowerCase().equals("enviado")) {
                    btnEstado.setText("Recibido");
                    siguienteEstado = 2;
                    btnEstado.setVisible(false);
                }

                quickorder2.QuickOrder2.port.cambiarEstadoPedido(pedido.getNumero(), siguienteEstado);

                cargarDatos(pedido.getNumero());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        lblFN = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNick = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblRestaurante = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEstado = new javax.swing.JTable();
        btnEstado = new javax.swing.JButton();

        jLabel6.setText("Fecha de nacimiento:");

        lblFN.setText("Fecha de nacimiento");

        lblApellido.setText("Apellido");

        lblNombre.setText("Nombre");

        lblDireccion.setText("Direccion");

        lblMail.setText("Email");

        jLabel1.setText("Apellido:");

        lblNick.setText("Nick");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Nickname:");

        jLabel4.setText("Email:");

        jLabel5.setText("Direccion:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos del pedido N° X");

        jLabel7.setText("Fecha:");

        lblFecha.setText("Fecha");

        lblRestaurante.setText("Apellido");

        lblCliente.setText("Cliente");

        lblPrecio.setText("Precio");

        lblNumero.setText("Numero");

        jLabel8.setText("Restaurante:");

        lblEstado.setText("Estado");

        jLabel9.setText("Cliente:");

        jLabel10.setText("Estado actual:");

        jLabel11.setText("Numero:");

        jLabel12.setText("Precio total:");

        jLabel13.setText("Cambios de estado:");

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaDetalle);

        jLabel14.setText("Detalle:");

        tablaEstado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaEstado);

        btnEstado.setText("Siguiente Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEstado))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstado)
                                    .addComponent(lblNumero)
                                    .addComponent(lblPrecio)
                                    .addComponent(lblCliente)
                                    .addComponent(lblRestaurante)
                                    .addComponent(lblFecha)))
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblRestaurante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblEstado))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DetallePedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallePedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallePedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallePedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetallePedido dialog = new DetallePedido(new javax.swing.JFrame(), 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFN;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNick;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblRestaurante;
    private javax.swing.JTable tablaDetalle;
    private javax.swing.JTable tablaEstado;
    // End of variables declaration//GEN-END:variables
}
