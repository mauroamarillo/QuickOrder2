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

            if (isSelected) {
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

            if (isSelected) {
                this.setBackground(list.getSelectionBackground());
            }

            return this;
        }

    }

    public static class ClienteListCellRenderer extends JLabel implements ListCellRenderer<webservices.DataCliente> {

        @Override
        public Component getListCellRendererComponent(JList<? extends webservices.DataCliente> list, webservices.DataCliente cliente, int index,
                boolean isSelected, boolean cellHasFocus) {

            String nombre = cliente.getNombre() + " " + cliente.getApellido();

            setText(nombre);

            this.setOpaque(isSelected);

            if (isSelected) {
                this.setBackground(list.getSelectionBackground());
            }

            return this;
        }
    }

    public static class ProductosListCellRenderer extends JLabel implements ListCellRenderer<webservices.DataProducto> {

        @Override
        public Component getListCellRendererComponent(JList<? extends webservices.DataProducto> list, webservices.DataProducto producto, int index,
                boolean isSelected, boolean cellHasFocus) {

            String nombre = producto.getNombre();

            setText(nombre);

            this.setOpaque(isSelected);

            if (isSelected) {
                this.setBackground(list.getSelectionBackground());
            }

            return this;
        }
        
    }
    
    public static class IndividualListCellRenderer extends JLabel implements ListCellRenderer<webservices.DataIndividual> {

        @Override
        public Component getListCellRendererComponent(JList<? extends webservices.DataIndividual> list, webservices.DataIndividual producto, int index,
                boolean isSelected, boolean cellHasFocus) {
            
            String restaurante = producto.getRestaurante();

            setText(producto.getNombre());
            
            this.setOpaque(isSelected);
               
            if(isSelected){
               this.setBackground(list.getSelectionBackground());
            }
            
            return this;
        }

    }
    
    public static class ProdPromoListCellRenderer extends JLabel implements ListCellRenderer<webservices.DataProdPromo> {

        @Override
        public Component getListCellRendererComponent(JList<? extends webservices.DataProdPromo> list, webservices.DataProdPromo producto, int index,
                boolean isSelected, boolean cellHasFocus) {
            
            webservices.DataIndividual prod = producto.getIndividual();

            setText(producto.getCantidad() + " - " + producto.getIndividual().getNombre());
            
            this.setOpaque(isSelected);
               
            if(isSelected){
               this.setBackground(list.getSelectionBackground());
            }
            
            return this;
        }

    }
    
    public static class ProdPedidoListCellRenderer extends JLabel implements ListCellRenderer<webservices.DataProdPedido> {

        @Override
        public Component getListCellRendererComponent(JList<? extends webservices.DataProdPedido> list, webservices.DataProdPedido producto, int index,
                boolean isSelected, boolean cellHasFocus) {
            
            webservices.DataProducto prod = producto.getProducto();

            setText(producto.getCantidad() + " - " + producto.getProducto().getNombre());
            
            this.setOpaque(isSelected);
               
            if(isSelected){
               this.setBackground(list.getSelectionBackground());
            }
            
            return this;
        }

    }
}
