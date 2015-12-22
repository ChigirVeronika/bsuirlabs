package test;

import by.bsuir.sum.entity.Friend;
import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * Created by Вероника on 14.05.2015.
 */
public class FriendTest {
    @Test
    public  void  testGetId() throws  Exception{
        String ss="1";
        Friend fr = new Friend(ss,"vera","chigir","");

        assertNotNull(fr);

        assertEquals(fr.getId(),ss);

        try{Integer.parseInt(ss);}catch (Exception e){
            fail("Is not number!");
        }
    }

    @Test
    public  void  testGetName() throws  Exception{
        String ss="vera";
        Friend fr = new Friend(ss,"vera","chigir","");

        assertNotNull(fr);

        assertEquals(fr.getId(),ss);
    }

    @Test
    public  void  testGetFriend() throws  Exception{
        String ss="";
        Friend fr = new Friend(ss,"vera","chigir","");

        assertNotNull(fr);

        assertEquals(fr.getId(), ss);
    }
}
