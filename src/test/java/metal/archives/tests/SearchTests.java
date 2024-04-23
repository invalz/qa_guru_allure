package metal.archives.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class SearchTests {

    @Test
    public void searchSerialTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            Selenide.open("https://www.lostfilm.tv");
        });
        $(".search-input").setValue("breaking bad").submit();
        $x("//*[@id=\"left-pane\"]/div/div/div[2]/div[2]/a").click();
        $(".title-en").shouldHave(text("breaking bad"));
        $x("//*[@id=\"left-pane\"]/div/div[1]/div[3]").shouldHave(text("Завершен"));

    }

//    @Test


}
