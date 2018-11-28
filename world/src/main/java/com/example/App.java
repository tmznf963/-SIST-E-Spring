package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.testMessage("한지민");
    }
    public String getMessage(String who){
        return String.format("Hi~ %s Good Morning",who);
    }
    public void testMessage(String who){
        System.out.println("Welcome! Maven World");
        System.out.println(getMessage(who));
        System.out.println("Bye!");
    }
}
