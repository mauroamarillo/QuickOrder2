/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickorder2.Registro.Herramientas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import quickorder2.Registro.Herramientas.ListRenderers.*;

/**
 *
 * @author Mauro
 */
public class SelectorMultiple extends javax.swing.JDialog {

    public Object[] resultado;

    /**
     * Creates new form SelectorCategorias
     */
    public SelectorMultiple(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        btnNueva.setVisible(false);
    }

    public void cargarCategorias(webservices.DataCategoria[] cats) {
        btnNueva.setVisible(true);
        lblDisponibles.setText("Categorias disponibles:");
        lblSeleccionados.setText("Categorias seleccionadas:");

        listDisponibles.setCellRenderer(new CategoriaListCellRenderer());
        listSeleccionadas.setCellRenderer(new CategoriaListCellRenderer());

        btnAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object[] seleccionadas = new webservices.DataCategoria[listSeleccionadas.getModel().getSize()];
                for (int i = 0; i < seleccionadas.length; i++) {
                    seleccionadas[i] = (webservices.DataCategoria) listSeleccionadas.getModel().getElementAt(i);
                }
                resultado = seleccionadas;
                dispose();
            }
        });

        listDisponibles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    add();
                }
            }
        });

        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add();
            }
        });
        
        btnRemove.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remove();
            }
        });
        
        listSeleccionadas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2)
                    remove();
            }
        });

        DefaultListModel modeloDisp = new DefaultListModel();
        DefaultListModel modeloSel = new DefaultListModel();

        HashMap categorias = new HashMap();
        for (webservices.DataCategoria c : cats) {
            categorias.put(c.getId(), c);
        }

        Iterator disponibles = quickorder2.QuickOrder2.port.consultarDataCategorias().iterator();

        while (disponibles.hasNext()) {
            webservices.DataCategoria cat = (webservices.DataCategoria) disponibles.next();
            if (categorias.containsKey(cat.getId())) {
                modeloSel.addElement(cat);
            } else {
                modeloDisp.addElement(cat);
            }
        }

        listDisponibles.setModel(modeloDisp);
        listSeleccionadas.setModel(modeloSel);
    }

    public void cargarIndividuales(webservices.DataProdPromo[] seleccionados, String restaurante) {
        btnNueva.setVisible(false);
        lblDisponibles.setText("Productos disponibles:");
        lblSeleccionados.setText("Productos seleccionados:");

        listDisponibles.setCellRenderer(new IndividualListCellRenderer());
        listSeleccionadas.setCellRenderer(new ProdPromoListCellRenderer());

        btnAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object[] seleccionadas = new webservices.DataProdPromo[listSeleccionadas.getModel().getSize()];
                for (int i = 0; i < seleccionadas.length; i++) {
                    seleccionadas[i] = (webservices.DataProdPromo) listSeleccionadas.getModel().getElementAt(i);
                }
                resultado = seleccionadas;
                dispose();
            }
        });

        listDisponibles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    addIndividualAProdPromo();
                }
            }
        });

        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addIndividualAProdPromo();
            }
        });

        btnRemove.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeIndividualAProdPromo();
            }
        });
        
        listSeleccionadas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2)
                    removeIndividualAProdPromo();
            }
        });

        DefaultListModel modeloDisp = new DefaultListModel();
        DefaultListModel modeloSel = new DefaultListModel();

        HashMap productos = new HashMap();

        for (webservices.DataProdPromo p : seleccionados) {
            productos.put(p.getIndividual().getNombre(), p);
        }

        Iterator todos = quickorder2.QuickOrder2.port.restauranteGetIndividuales(restaurante).iterator();

        while (todos.hasNext()) {
            webservices.DataIndividual prod = (webservices.DataIndividual) todos.next();
            if (productos.containsKey(prod.getNombre())) {
                modeloSel.addElement(productos.get(prod.getNombre()));
            } else {
                modeloDisp.addElement(prod);
            }
        }

        listDisponibles.setModel(modeloDisp);
        listSeleccionadas.setModel(modeloSel);
    }

    public void add() {
        DefaultListModel modeloDisp = (DefaultListModel) listDisponibles.getModel();
        DefaultListModel modeloSel = (DefaultListModel) listSeleccionadas.getModel();

        for (Object item : listDisponibles.getSelectedValuesList()) {
            modeloDisp.removeElement(item);
            modeloSel.addElement(item);
        }
    }
    
    public void remove(){
        DefaultListModel modeloDisp = (DefaultListModel) listDisponibles.getModel();
        DefaultListModel modeloSel = (DefaultListModel) listSeleccionadas.getModel();

        for (Object item : listSeleccionadas.getSelectedValuesList()) {
            modeloSel.removeElement(item);
            modeloDisp.addElement(item);
        }
    }

    public void addIndividualAProdPromo() {
        DefaultListModel modeloDisp = (DefaultListModel) listDisponibles.getModel();
        DefaultListModel modeloSel = (DefaultListModel) listSeleccionadas.getModel();

        for (Object item : listDisponibles.getSelectedValuesList()) {
            webservices.DataProdPromo prod = new webservices.DataProdPromo();
            prod.setCantidad(Integer.valueOf(JOptionPane.showInputDialog("Ingrese el nombre de la categoria:")));
            prod.setIndividual((webservices.DataIndividual) item);
            modeloDisp.removeElement(item);
            modeloSel.addElement(prod);
        }
    }

    public void removeIndividualAProdPromo() {
        DefaultListModel modeloDisp = (DefaultListModel) listDisponibles.getModel();
        DefaultListModel modeloSel = (DefaultListModel) listSeleccionadas.getModel();

        for (Object item : listSeleccionadas.getSelectedValuesList()) {
            modeloSel.removeElement(item);
            modeloDisp.addElement(((webservices.DataProdPromo) item).getIndividual());
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
        lblDisponibles = new javax.swing.JLabel();
        lblSeleccionados = new javax.swing.JLabel();
        btnNueva = new javax.swing.JButton();

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

        lblDisponibles.setText("Disponibles:");

        lblSeleccionados.setText("Seleccionados:");

        btnNueva.setText("Nueva categoria");
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNueva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDisponibles)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdd)
                                    .addComponent(btnRemove))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSeleccionados)
                                .addGap(0, 134, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisponibles)
                    .addComponent(lblSeleccionados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnNueva))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void listDisponiblesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDisponiblesValueChanged

    }//GEN-LAST:event_listDisponiblesValueChanged

    private void listDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDisponiblesMouseClicked
        
    }//GEN-LAST:event_listDisponiblesMouseClicked

    private void listSeleccionadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSeleccionadasMouseClicked

    }//GEN-LAST:event_listSeleccionadasMouseClicked

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
        String categoria = JOptionPane.showInputDialog("Ingrese el nombre de la categoria:");
        quickorder2.QuickOrder2.port.insertarCategoria(categoria);
        webservices.DataCategoria[] seleccionadas = new webservices.DataCategoria[listSeleccionadas.getModel().getSize()];

        for (int i = 0; i < seleccionadas.length; i++) {
            seleccionadas[i] = (webservices.DataCategoria) listSeleccionadas.getModel().getElementAt(i);
        }

        cargarCategorias(seleccionadas);
    }//GEN-LAST:event_btnNuevaActionPerformed

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
            java.util.logging.Logger.getLogger(SelectorMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectorMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectorMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectorMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectorMultiple dialog = new SelectorMultiple(new javax.swing.JFrame());
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
    private javax.swing.JButton btnNueva;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDisponibles;
    private javax.swing.JLabel lblSeleccionados;
    private javax.swing.JList listDisponibles;
    private javax.swing.JList listSeleccionadas;
    // End of variables declaration//GEN-END:variables
}
