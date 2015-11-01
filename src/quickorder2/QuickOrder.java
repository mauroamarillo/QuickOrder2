package quickorder2;

import java.awt.Dimension;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mauro
 */
public class QuickOrder extends javax.swing.JFrame {

    /**
     * Creates new form QuickOrder
     */
    public final webservices.WSQuickOrder port;

    public QuickOrder(webservices.WSQuickOrder port) {
        this.port = port;
        initComponents();
    }

    public QuickOrder() {
        this.port = null;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        MenuReg = new javax.swing.JMenu();
        RSubMenuUsuarios = new javax.swing.JMenu();
        ItemRCliente = new javax.swing.JMenuItem();
        ItemRRestaurante = new javax.swing.JMenuItem();
        RSubMenuProducto = new javax.swing.JMenu();
        ItemRIndividual = new javax.swing.JMenuItem();
        ItemRPromocion = new javax.swing.JMenuItem();
        RSubMenuPedido = new javax.swing.JMenuItem();
        MenuCons = new javax.swing.JMenu();
        CSubMenuUsuarios = new javax.swing.JMenu();
        CClientes = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        CPedidos = new javax.swing.JMenuItem();
        CProductos = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        CVisitasURL = new javax.swing.JMenuItem();
        CVisitasR = new javax.swing.JMenuItem();
        CVisitasSO = new javax.swing.JMenuItem();
        CVisitasBrowser = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));
        desktopPane.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                desktopPaneComponentAdded(evt);
            }
        });

        MenuReg.setText("Registro");

        RSubMenuUsuarios.setText("Usuarios");

        ItemRCliente.setText("Cliente");
        ItemRCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemRClienteActionPerformed(evt);
            }
        });
        RSubMenuUsuarios.add(ItemRCliente);

        ItemRRestaurante.setText("Restaurante");
        ItemRRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemRRestauranteActionPerformed(evt);
            }
        });
        RSubMenuUsuarios.add(ItemRRestaurante);

        MenuReg.add(RSubMenuUsuarios);

        RSubMenuProducto.setText("Productos");

        ItemRIndividual.setText("Individual");
        ItemRIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemRIndividualActionPerformed(evt);
            }
        });
        RSubMenuProducto.add(ItemRIndividual);

        ItemRPromocion.setText("Promocion");
        ItemRPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemRPromocionActionPerformed(evt);
            }
        });
        RSubMenuProducto.add(ItemRPromocion);

        MenuReg.add(RSubMenuProducto);

        RSubMenuPedido.setText("Pedidos");
        RSubMenuPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RSubMenuPedidoActionPerformed(evt);
            }
        });
        MenuReg.add(RSubMenuPedido);

        menuBar.add(MenuReg);

        MenuCons.setText("Consulta");

        CSubMenuUsuarios.setText("Usuarios");

        CClientes.setText("Clientes");
        CClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CClientesActionPerformed(evt);
            }
        });
        CSubMenuUsuarios.add(CClientes);

        jMenuItem1.setText("Restaurantes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        CSubMenuUsuarios.add(jMenuItem1);

        MenuCons.add(CSubMenuUsuarios);

        CPedidos.setText("Pedidos");
        CPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPedidosActionPerformed(evt);
            }
        });
        MenuCons.add(CPedidos);

        CProductos.setText("Productos");
        CProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CProductosActionPerformed(evt);
            }
        });
        MenuCons.add(CProductos);

        jMenu1.setText("Estadistica");

        CVisitasURL.setText("Visitas por URL");
        CVisitasURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVisitasURLActionPerformed(evt);
            }
        });
        jMenu1.add(CVisitasURL);

        CVisitasR.setText("Visitas por restaurante");
        CVisitasR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVisitasRActionPerformed(evt);
            }
        });
        jMenu1.add(CVisitasR);

        CVisitasSO.setText("Visitas por sistema operativo");
        CVisitasSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVisitasSOActionPerformed(evt);
            }
        });
        jMenu1.add(CVisitasSO);

        CVisitasBrowser.setText("Visitas por navegador");
        CVisitasBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVisitasBrowserActionPerformed(evt);
            }
        });
        jMenu1.add(CVisitasBrowser);

        MenuCons.add(jMenu1);

        menuBar.add(MenuCons);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemRClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemRClienteActionPerformed
        quickorder2.Registro.Cliente w = new quickorder2.Registro.Cliente();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_ItemRClienteActionPerformed

    private void CClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CClientesActionPerformed
        quickorder2.Consulta.Lista w = new quickorder2.Consulta.Lista();
        w.cargarClientes();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_CClientesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        quickorder2.Consulta.Lista w = new quickorder2.Consulta.Lista();
        w.cargarRestaurantes();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void CPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPedidosActionPerformed
        quickorder2.Consulta.Lista w = new quickorder2.Consulta.Lista();
        w.cargarPedidos();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_CPedidosActionPerformed

    private void ItemRRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemRRestauranteActionPerformed
        quickorder2.Registro.Restaurante w = new quickorder2.Registro.Restaurante();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_ItemRRestauranteActionPerformed

    private void ItemRIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemRIndividualActionPerformed
        quickorder2.Registro.Individual w = new quickorder2.Registro.Individual();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_ItemRIndividualActionPerformed

    private void ItemRPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemRPromocionActionPerformed
        quickorder2.Registro.Promocion w = new quickorder2.Registro.Promocion();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_ItemRPromocionActionPerformed

    private void RSubMenuPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RSubMenuPedidoActionPerformed
        quickorder2.Registro.Pedido w = new quickorder2.Registro.Pedido();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_RSubMenuPedidoActionPerformed

    private void CProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CProductosActionPerformed
        quickorder2.Consulta.Lista w = new quickorder2.Consulta.Lista();
        w.cargarProductos();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_CProductosActionPerformed

    private void CVisitasURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVisitasURLActionPerformed
        quickorder2.Consulta.Lista w = new quickorder2.Consulta.Lista();
        w.cargarVisitasURL();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_CVisitasURLActionPerformed

    private void CVisitasRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVisitasRActionPerformed
        quickorder2.Consulta.Lista w = new quickorder2.Consulta.Lista();
        w.cargarVisitasRestaurante();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_CVisitasRActionPerformed

    private void CVisitasSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVisitasSOActionPerformed
        quickorder2.Consulta.Lista w = new quickorder2.Consulta.Lista();
        w.cargarVisitasSO();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_CVisitasSOActionPerformed

    private void CVisitasBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVisitasBrowserActionPerformed
        quickorder2.Consulta.Lista w = new quickorder2.Consulta.Lista();
        w.cargarVisitasBrowser();
        desktopPane.add(w);
        w.setVisible(true);
    }//GEN-LAST:event_CVisitasBrowserActionPerformed

    private void desktopPaneComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_desktopPaneComponentAdded
        Dimension desktopSize = desktopPane.getSize();
        Dimension jInternalFrameSize = evt.getChild().getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        evt.getChild().setLocation(width, height);
        evt.getChild().setVisible(true);
    }//GEN-LAST:event_desktopPaneComponentAdded

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
            java.util.logging.Logger.getLogger(QuickOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuickOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuickOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuickOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuickOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CClientes;
    private javax.swing.JMenuItem CPedidos;
    private javax.swing.JMenuItem CProductos;
    private javax.swing.JMenu CSubMenuUsuarios;
    private javax.swing.JMenuItem CVisitasBrowser;
    private javax.swing.JMenuItem CVisitasR;
    private javax.swing.JMenuItem CVisitasSO;
    private javax.swing.JMenuItem CVisitasURL;
    private javax.swing.JMenuItem ItemRCliente;
    private javax.swing.JMenuItem ItemRIndividual;
    private javax.swing.JMenuItem ItemRPromocion;
    private javax.swing.JMenuItem ItemRRestaurante;
    private javax.swing.JMenu MenuCons;
    private javax.swing.JMenu MenuReg;
    private javax.swing.JMenuItem RSubMenuPedido;
    private javax.swing.JMenu RSubMenuProducto;
    private javax.swing.JMenu RSubMenuUsuarios;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
