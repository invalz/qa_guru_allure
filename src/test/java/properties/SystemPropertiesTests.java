package properties;

import com.sun.management.VMOption;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SystemPropertiesTests {
    @Test
    void someTest1(){
        String browser = System.getProperty("browser");
        System.out.println(browser); //null
    }

    @Test
    void someTest2(){
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser");
        System.out.println(browser); //
    }

    @Test
    void someTest3(){
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser); //
    }

    @Test
    void someTest4(){
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser); //
    }

    @Test
    void someTest5(){
        System.getProperty("anyValue", "any text");
        String browser = System.getProperty("anyValue", "some text");
        System.out.println(browser); //
    }

    @Test
    @Tag("test6")
    void someTest6(){
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "101");
        String browserSize = System.getProperty("browserSize", "1920x1080");

        System.out.println(browser); //
        System.out.println(version); //
        System.out.println(browserSize); //
    }

    @Test
    @Tag("hello")
    void someTest7(){
        System.out.println("Hello + " + System.getProperty("text"));
    }
}
