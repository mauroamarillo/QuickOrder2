/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickorder2.Registro.Herramientas;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Mauro
 */
public class ListRenderers {
    public static class CategoriaListCellRenderer extends JLabel implements ListCellRenderer<webservices.DataCategoria> {

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
    
    public static class RestauranteListCellRenderer extends JLabel implements ListCellRenderer<webservices.DataRestaurante> {

        @Override
        public Component getListCellRendererComponent(JList<? extends webservices.DataRestaurante> list, webservices.DataRestaurante restaurante, int index,
                boolean isSelected, boolean cellHasFocus) {

            
            
            String nick = restaurante.getNickname();

            setText(restaurante.getNombre());
            
            this.setOpaque(isSelected);
               
            if(isSelected){
               this.setBackground(list.getSelectionBackground());
            }
            
            return this;
        }

    }
}
