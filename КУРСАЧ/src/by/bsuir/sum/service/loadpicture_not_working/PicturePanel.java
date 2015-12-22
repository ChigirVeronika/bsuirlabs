package by.bsuir.sum.service.loadpicture_not_working;

/**
 * Created by Вероника on 11.05.2015.
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PicturePanel extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage originalImage = null;
    private Image image = null;
    public float suSize;

    public PicturePanel() {

        setLayout(null);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

    }

    private void formComponentResized(java.awt.event.ComponentEvent evt) {
        int w = this.getWidth();
        int h = this.getHeight();
        if ((originalImage != null) && (w > 0) && (h > 0)) {
            image = originalImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);
            this.repaint();
        }
    }

    public void paint(Graphics g) {

        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }
        super.paintChildren(g);
        super.paintBorder(g);
    }


    public BufferedImage getImage() {
        return originalImage;
    }

    public void setImage(BufferedImage image) {
        this.originalImage = image;
        suSize = (float)(image.getWidth())/(float)(image.getHeight());
        formComponentResized(null);
    }


    public void setImageFile(File iF) {
        if(iF==null)originalImage=null;
        else{
            try {
                BufferedImage bi;
                bi = ImageIO.read(iF);
                originalImage = bi;
            } catch (IOException ex) {
                System.err.println("Couldn't load picture!");
                ex.printStackTrace();
            }
            formComponentResized(null);
            suSize = (float)(originalImage.getWidth())/(float)(originalImage.getHeight());
            repaint();
        }
    }

}
