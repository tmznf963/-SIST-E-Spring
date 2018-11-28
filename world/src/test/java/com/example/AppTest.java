package com.example;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private App app;
    public AppTest(){
        app = new App();
    }
    @Test
    public void mytest(){
        assertNotNull(app);
    }
    @Test
    public void mytest1(){
        String testMessage = "Hi~ 한지민 Good Morning";
        assertEquals(app.getMessage("한지민"),testMessage);//두 문자열이 같나?
        //단위테스트(부품테스트) == jUnit
    }
    // public void shouldAnswerWithTrue()
    // {
    //     assertTrue(true);
    // }
}
