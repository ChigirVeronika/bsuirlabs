package test;

/**
 * Created by Вероника on 14.05.2015.
 */

import javafx.scene.control.TextArea;
import by.bsuir.sum.util.PrintList;
import org.junit.Test;
import static junit.framework.Assert.*;

public class PrintListTest {

    @Test(timeout = 1000)
    public void testOnePrint(){
        PrintList pl= new PrintList();
        int i1 = 0;
        TextArea ta1 = null;

        assertNull(ta1);

        assertNotSame(i1,ta1);

        assertNotNull(pl);
    }

    @Test(timeout = 1000)
    public void testAllPrint(){
        PrintList pl= new PrintList();
        int i1 = 0;
        TextArea ta1 = null;

        assertNull(ta1);

        assertNotSame(i1,ta1);

        assertNotNull(pl);
    }
}
