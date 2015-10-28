/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickorder2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Mauro
 */
public class QuickOrder2 {
    
    public static webservices.WSQuickOrder port;
    public static QuickOrder parent;

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args){
        webservices.WSQuickOrder_Service service = new webservices.WSQuickOrder_Service();
        port = service.getWSQuickOrderPort();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(QuickOrder2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        parent = new QuickOrder();
        parent.setExtendedState(JFrame.MAXIMIZED_BOTH);
        parent.setVisible(true);
    }
}