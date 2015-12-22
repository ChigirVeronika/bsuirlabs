package by.bsuir.sum.service.loadpicture_not_working;

/**
 * Created by Вероника on 11.05.2015.
 */
import javax.swing.filechooser.FileFilter;


public class TextFileFilter extends FileFilter {

    public boolean accept(java.io.File file) {

        if ( file.isDirectory() ) return true;

        return ( file.getName().endsWith(".jpg") );
    }

    public String getDescription() {
        return "Pictures (*.jpg)";
    }

}
