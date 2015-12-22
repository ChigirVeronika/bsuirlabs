package by.bsuir.sum.service.loadpicture_not_working;

/**
 * Created by Вероника on 11.05.2015.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class MyFrame extends JFrame {
    private JButton bLoad;
    private PicturePanel panel;

    MyFrame() {

        super("Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        panel = new PicturePanel();
        bLoad = new JButton("Load image to panel");

        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent event) {
                System.exit (0);
            }
        });

        bLoad.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                JFileChooser fileChs = new JFileChooser();
                fileChs.setDialogTitle("Choose file for loading");
                fileChs.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChs.setFileFilter(new TextFileFilter());
                int res = fileChs.showOpenDialog(MyFrame.this);
                if ( res == JFileChooser.APPROVE_OPTION ) {
                    MyFrame.this.getPicturePanel().setImageFile(fileChs.getSelectedFile());
                    BufferedImage im = MyFrame.this.getPicturePanel().getImage();
                    MyFrame.this.setSize(im.getWidth(),im.getHeight());

                }

            }
        });

        pane.add(panel,BorderLayout.CENTER);
        pane.add(bLoad,BorderLayout.SOUTH);
        setSize(300, 300);
        setVisible(true);
    }

    PicturePanel getPicturePanel() {
        return panel;
    }

//    public static void sample (String args[]) {
//        JFrame f;
//        f = new MyFrame ();
//    }
}
