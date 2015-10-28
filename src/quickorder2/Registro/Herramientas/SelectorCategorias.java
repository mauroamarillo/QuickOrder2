/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickorder2.Registro.Herramientas;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Mauro
 */
public class SelectorCategorias extends javax.swing.JDialog {
    quickorder2.Registro.Restaurante par;
    /**
     * Creates new form SelectorCategorias
     */
    public SelectorCategorias(java.awt.Frame parent, quickorder2.Registro.Restaurante par ) {
        super(parent, true);
        initComponents();
        listDisponibles.setCellRenderer(new CatRenderer());
        listSeleccionadas.setCellRenderer(new CatRenderer());
        this.par = par;
        cargarDatos(par.categorias);
    }

    public void cargarDatos(webservices.DataCategoria[] cats) {
        DefaultListModel modeloDisp = new DefaultListModel();
        DefaultListModel modeloSel = new DefaultListModel();
        
        HashMap categorias = new HashMap();
        for(webservices.DataCategoria c : cats){
            categorias.put(c.getId(),c);
        }
        
        Iterator disponibles = quickorder2.QuickOrder2.port.consultarDataCategorias().iterator();

        while (disponibles.hasNext()) {
            webservices.DataCategoria cat = (webservices.DataCategoria) disponibles.next();
            if(categorias.containsKey(cat.getId()))
                modeloSel.addElement(cat);
            else
                modeloDisp.addElement(cat);
        }

        listDisponibles.setModel(modeloDisp);
        listSeleccionadas.setModel(modeloSel);
    }

    public class CatRenderer extends JLabel implements ListCellRenderer<webservices.DataCategoria> {

        @Override
        public Component getListCellRendererComponent(JList<? extends webservices.DataCategoria> list, webservices.DataCategoria categoria, int index,
                boolean isSelected, boolean cellHasFocus) {

            
            
            int id = categoria.getId();

            setText(categoria.getNombre());
            this.setOpaque(isSelected);
               
            if(isSelected){
               this.setBackground(list.getSelectionBackground());
            }
            
            return this;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listSeleccionadas = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listDisponibles = new javax.swing.JList();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccione categorias");

        listSeleccionadas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listSeleccionadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSeleccionadasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listSeleccionadas);

        listDisponibles.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDisponiblesMouseClicked(evt);
            }
        });
        listDisponibles.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDisponiblesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listDisponibles);

        btnAdd.setText(">>");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("<<");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Categorias disponibles:");

        jLabel2.setText("Categorias Seleccionadas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdd)
                                    .addComponent(btnRemove)))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addGap(0, 0, 0))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DefaultListModel modeloDisp = (DefaultListModel) listDisponibles.getModel();
        DefaultListModel modeloSel = (DefaultListModel) listSeleccionadas.getModel();

        for (Object item : listDisponibles.getSelectedValuesList()) {
            modeloDisp.removeElement(item);
            modeloSel.addElement(item);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        DefaultListModel modeloDisp = (DefaultListModel) listDisponibles.getModel();
        DefaultListModel modeloSel = (DefaultListModel) listSeleccionadas.getModel();

        for (Object item : listSeleccionadas.getSelectedValuesList()) {
            modeloSel.removeElement(item);
            modeloDisp.addElement(item);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        webservices.DataCategoria[] seleccionadas = new webservices.DataCategoria[listSeleccionadas.getModel().getSize()];
        
        for(int i = 0 ; i < seleccionadas.length ; i++){
            seleccionadas[i] = (webservices.DataCategoria) listSeleccionadas.getModel().getElementAt(i);
        }
        
        this.par.categorias = seleccionadas;
        
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void listDisponiblesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDisponiblesValueChanged
        
    }//GEN-LAST:event_listDisponiblesValueChanged

    private void listDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDisponiblesMouseClicked
        if(evt.getClickCount() == 2){
            btnAddActionPerformed(null);
        }
    }//GEN-LAST:event_listDisponiblesMouseClicked

    private void listSeleccionadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSeleccionadasMouseClicked
        if(evt.getClickCount() == 2){
            btnRemoveActionPerformed(null);
        }
    }//GEN-LAST:event_listSeleccionadasMouseClicked

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
            java.util.logging.Logger.getLogger(SelectorCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectorCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectorCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectorCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectorCategorias dialog = new SelectorCategorias(new javax.swing.JFrame(), null);
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listDisponibles;
    private javax.swing.JList listSeleccionadas;
    // End of variables declaration//GEN-END:variables
}
