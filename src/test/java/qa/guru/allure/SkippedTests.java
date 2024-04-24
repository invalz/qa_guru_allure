package qa.guru.allure;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkippedTests {

    @Test
    @Disabled("some reason")
    void test1(){
        assertTrue(true);
    }

    @Test
    @Disabled
    void test2(){
        assertTrue(true);
    }

    @Test
    @Disabled
    void test3(){
        assertTrue(true);
    }
}