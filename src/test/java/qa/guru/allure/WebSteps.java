package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открывваем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Ищем репозиторий по имени {repository}")
    public void searchForRepository(String repository) {
        $(".search-input").click();
        $("#query-builder-test").setValue(repository).submit();
    }

    @Step("В результатах поиска переходим по ссылке репозитория {repository}")
    public void openRepositoryLink(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем что существует Issue с номером {issueNumber}")
    public void shouldSeeIssueWithNumber(Integer issueNumber) {
        $(withText("#" + issueNumber)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeSkreenshot() {
        return ((TakesScreenshot)webdriver().driver()).getScreenshotAs(OutputType.BYTES);
    }
}
