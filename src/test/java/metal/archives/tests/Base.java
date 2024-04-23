package metal.archives.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class Base {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.metal-archives.com/";
    }

}
