/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickorder2.Registro.Herramientas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import quickorder2.Registro.Cliente;

/**
 *
 * @author Mauro
 */
public class Imagenes {

    public static String SeleccionarImagen() {
        JFileChooser fileOpen = new JFileChooser();

        String[] suffices = ImageIO.getReaderFileSuffixes();

        for (FileFilter c : fileOpen.getChoosableFileFilters()) {
            fileOpen.removeChoosableFileFilter(c);
        }

        fileOpen.addChoosableFileFilter(new FileNameExtensionFilter("Archivos de imagen", suffices));

        int ret = fileOpen.showDialog(null, "Seleccionar imagen");

        if (ret == JFileChooser.APPROVE_OPTION) {
            return fileOpen.getSelectedFile().getPath();
        }

        return "";
    }

    public static String convertirImagen(String path) throws FileNotFoundException {
        if (path == null || path.isEmpty()) {
            return "NO";
        }
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }

            byte[] bytes = bos.toByteArray();

            ImageInputStream iis = ImageIO.createImageInputStream(file);

            Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);

            String type = "bmp";

            while (imageReaders.hasNext()) {
                ImageReader reader = (ImageReader) imageReaders.next();
                System.out.printf("formatName: %s%n", reader.getFormatName());
                type = reader.getFormatName();
            }

            return "data:image/" + type + ";base64," + Base64.getMimeEncoder().encodeToString(bytes);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "NO";
    }

    public static ImageIcon obtenerImagenEscalada(String path, int w, int h) {
        Image img = new ImageIcon(path).getImage();
        Image newImg;
        newImg = img.getScaledInstance(w, h, java.awt.Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(newImg);
    }

    public static ImageIcon escalarIcono(ImageIcon ico, int w, int h) {
        Image img = ico.getImage();
        Image newImg;
        newImg = img.getScaledInstance(w, h, java.awt.Image.SCALE_FAST);
        return new ImageIcon(newImg);
    }

    /**
     *
     * @param path
     * @return
     */
    public static ImageIcon cargarImagen(String path) {
        if(path == null ||path.isEmpty()|| path.equals("NO")){
            return new ImageIcon("src/img/sin_img.jpg");
        }
        try {
            byte[] btDataFile = Base64.getDecoder().decode(path.split(",")[1]);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(btDataFile));
            return new ImageIcon(image);
        } catch (IOException ex) {
            Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ImageIcon cargarYescalar(String path, int w, int h) {
        return escalarIcono(cargarImagen(path), w, h);
    }
}
