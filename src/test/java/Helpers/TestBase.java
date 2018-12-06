package Helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Condition.exist;

public class TestBase {
    @BeforeSuite
    public void setUp() throws MalformedURLException {
        Configuration.timeout = 20000;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions);
        WebDriverRunner.setWebDriver(driver);
    }
    @AfterSuite
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    public void sendKeysDely(SelenideElement element, String text){
        element.shouldBe(exist).clear();
        for(char a: text.toCharArray()){

            try {
                element.sendKeys(String.valueOf(a));
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
