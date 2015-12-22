package test;

import by.bsuir.sum.controller.BeginController;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Вероника on 14.05.2015.
 */
public class BeginControllerTest {
    @Test
    public  void testInitialize(){
        BeginController beginController= new BeginController();
        assertNotNull(beginController);
    }
}
