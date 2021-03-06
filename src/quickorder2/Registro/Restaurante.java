/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickorder2.Registro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import quickorder2.Registro.Herramientas.SelectorMultiple;
import static quickorder2.Registro.Herramientas.Validaciones.*;

/**
 *
 * @author Mauro
 */
public class Restaurante extends javax.swing.JInternalFrame {

    public webservices.DataCategoria[] categorias = new webservices.DataCategoria[]{};
    
    /**
     * Creates new form Restaurante
     */
    public Restaurante() {
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

        txtCategorias = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnEditarCategorias = new javax.swing.JButton();
        txtNick = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnVerifNick = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BtnVerifMail = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnMostrarPwd = new javax.swing.JButton();
        txtPwd = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Nuevo Usuario - Restaurante");

        txtCategorias.setEditable(false);
        txtCategorias.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Categorias:");

        btnEditarCategorias.setText("Editar");
        btnEditarCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEditarCategoriasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEditarCategoriasMouseReleased(evt);
            }
        });
        btnEditarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCategoriasActionPerformed(evt);
            }
        });

        jLabel6.setText("Direccion:");

        jLabel1.setText("Nickname:");

        btnVerifNick.setText("Verificar");
        btnVerifNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifNickActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        BtnVerifMail.setText("Verificar");
        BtnVerifMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnVerifMailMousePressed(evt);
            }
        });
        BtnVerifMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerifMailActionPerformed(evt);
            }
        });

        jLabel7.setText("Contraseña:");

        btnMostrarPwd.setText("Mostrar");
        btnMostrarPwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMostrarPwdMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnMostrarPwdMouseReleased(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("E-Mail:");

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
                            .addComponent(jLabel2))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerifNick))
                            .addComponent(txtNombre)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(73, 73, 73)
                        .addComponent(txtDireccion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPwd, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCategorias, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnVerifMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMostrarPwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnVerifNick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(BtnVerifMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnMostrarPwd)
                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnEditarCategorias))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarCategoriasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarCategoriasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarCategoriasMousePressed

    private void btnEditarCategoriasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarCategoriasMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarCategoriasMouseReleased

    private void btnVerifNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifNickActionPerformed
        if (quickorder2.QuickOrder2.port.nickOcupado(txtNick.getText())) {
            JOptionPane.showMessageDialog(this, "Ya existe un usuario con el nick " + txtNick.getText() + ".\n Ingrese un nuevo nick e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "El nick " + txtNick.getText() + " se encuentra disponible.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVerifNickActionPerformed

    private void BtnVerifMailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnVerifMailMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnVerifMailMousePressed

    private void BtnVerifMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerifMailActionPerformed
        if (!validarEmail(txtMail.getText())) {
            JOptionPane.showMessageDialog(this, "El e-mail " + txtMail.getText() + " tiene un formato incorrecto.\nIngrese un mail con el formato 'usuario@ejemplo.com' e intentelo de nuevo.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (quickorder2.QuickOrder2.port.emailOcupado(txtMail.getText())) {
            JOptionPane.showMessageDialog(this, "Ya existe un usuario con el e-mail " + txtMail.getText() + ".\nIngrese un nuevo e-mail e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "El e-mail " + txtMail.getText() + " es correcto y se encuentra disponible.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BtnVerifMailActionPerformed

    private void btnMostrarPwdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarPwdMousePressed
        char c = 0;
        txtPwd.setEchoChar(c);
    }//GEN-LAST:event_btnMostrarPwdMousePressed

    private void btnMostrarPwdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarPwdMouseReleased
        char c = '\u25cf';
        txtPwd.setEchoChar(c);
    }//GEN-LAST:event_btnMostrarPwdMouseReleased

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        List<Integer> cats = new ArrayList<>();
        
        for(webservices.DataCategoria c : categorias){
            cats.add(c.getId());
        }
        
        quickorder2.QuickOrder2.port.insertarRestaurante(txtNick.getText(), txtMail.getText(), txtDireccion.getText(), txtNombre.getText(), null, cats, new String(txtPwd.getPassword()));
        
        if(quickorder2.QuickOrder2.port.nickOcupado(txtNick.getText())){
            JOptionPane.showMessageDialog(this, "El restaurante " + txtNombre.getText() + " fue registrado correctamente.", "Correcto", JOptionPane.OK_OPTION);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Aparentemente hubo un error, revise los daos ingresados e inténtelo de nuevo.", "Correcto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Seguro de que desea cancelar el registro?", "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCategoriasActionPerformed
        SelectorMultiple s = new SelectorMultiple(null);
        s.cargarCategorias(categorias);
        s.setVisible(true);
        
        this.categorias = (webservices.DataCategoria[]) s.resultado;
        
        String cat = "";
        
        for(webservices.DataCategoria c : categorias){
            cat += c.getNombre();
            
            if(c.equals(categorias[categorias.length - 1]))
                cat += ".";
            else
                cat += ", ";
        }
        
        txtCategorias.setText(cat);
    }//GEN-LAST:event_btnEditarCategoriasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVerifMail;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarCategorias;
    private javax.swing.JButton btnMostrarPwd;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVerifNick;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCategorias;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNick;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPwd;
    // End of variables declaration//GEN-END:variables
}
