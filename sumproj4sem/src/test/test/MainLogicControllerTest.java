package test;

import by.bsuir.sum.controller.MainLogicController;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Вероника on 14.05.2015.
 */
public class MainLogicControllerTest {
    @Test
    public  void testInitialize(){
        MainLogicController mainLogicController= new MainLogicController();
        assertNotNull(mainLogicController);
    }
}
