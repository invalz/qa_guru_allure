package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelTest {

    @Test
    public void testDynamicLabels(){
        Allure.label("owner", "Uladzimir Kuzmitski");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature("New feature");
        Allure.story("Combobust");
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setName("Тест динамического лейбла"));
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setDescription("Этот тест проверяет на сколько динамичен лейбл"));
        Allure.link("GitHub","https://github.com");
    }

    @Test
    @Owner("Uladzimir Kuzmitski")
    @Severity(SeverityLevel.MINOR)
    @Feature("New feature")
    @Story("Betslip")
    @DisplayName("Тест статического лейбла")
    @Description("Этот тест проверяет на сколько статичен лейбл")
    @Link(name = "GitHub", url = "https://github.com")
    public void testStaticLabels(){

    }
}
