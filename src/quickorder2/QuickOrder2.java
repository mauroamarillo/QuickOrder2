/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickorder2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Mauro
 */
public class QuickOrder2 {

    private final static String CARPETA = System.getProperty("user.home") + "\\QuickOrder\\";
    private final static String ARCHIVO = "QuickOrderApp.properties";
    private final static String RUTA = CARPETA + ARCHIVO;

    public static webservices.WSQuickOrder port;
    public static QuickOrder parent;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (!existe()) {
            configurar();
        }
        webservices.WSQuickOrder_Service service = null;

        try {
            Properties propiedades = new Properties();
            propiedades.load(new FileInputStream(RUTA));

            String rutaWS = propiedades.getProperty("rutaWS");

            try {
                service = new webservices.WSQuickOrder_Service(new java.net.URL(rutaWS));
            } catch (javax.xml.ws.WebServiceException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR FATAL", JOptionPane.WARNING_MESSAGE);
                return;
            }

        } catch (FileNotFoundException ex) {
            try {
                service = new webservices.WSQuickOrder_Service();
            } catch (javax.xml.ws.WebServiceException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR FATAL", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Logger.getLogger(QuickOrder2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            try {
                service = new webservices.WSQuickOrder_Service();
            } catch (javax.xml.ws.WebServiceException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR FATAL", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Logger.getLogger(QuickOrder2.class.getName()).log(Level.SEVERE, null, ex);
        }

        port = service.getWSQuickOrderPort();

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        
        JFrame.setDefaultLookAndFeelDecorated(true);

        parent = new QuickOrder();
        parent.setExtendedState(JFrame.MAXIMIZED_BOTH);
        parent.setVisible(true);
    }

    private static boolean existe() {
        return (new java.io.File(RUTA)).exists();
    }

    private static void configurar() {
        try {
            File archivo = new File(RUTA);
            new File(CARPETA).mkdirs();
            archivo.createNewFile();
            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("rutaWS=http://localhost:8080/WSUsuario/WSQuickOrder?wsdl\n");
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(QuickOrder2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
