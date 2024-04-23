package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final Integer ISSUE_NUMBER = 89;
    @Test
    public void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открывваем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий по имени " + REPOSITORY, () -> {
          $(".search-input").click();
          $("#query-builder-test").setValue(REPOSITORY).submit();
        });
        step("В результатах поиска переходим по ссылке репозитория" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем что существует Issue с номером " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
            Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png",
                    ((TakesScreenshot)webdriver().driver()).getScreenshotAs(OutputType.BYTES));
            attachment("Source", webdriver().driver().source());
        });
    }

    @Test
    public void testAnnotatedStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
        steps.takeSkreenshot();
    }
}
