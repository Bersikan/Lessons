package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LogIn {
    public By fLogin = By.cssSelector("[data-test='username']");
    public By fPwd = By.cssSelector("[data-test='password']");
    public By bLogin = By.className("login-button");

    public SelenideElement fLogin() {
        return $(fLogin).shouldBe(visible);
    }

    public SelenideElement fPwd() {
        return $(fPwd).shouldBe(visible);
    }

    public SelenideElement bLogin() {
        return $(bLogin).shouldBe(visible);
    }


    public void logIn(String login, String pwd){
        fLogin().clear();
        fLogin().val(login);
        fPwd().clear();
        fPwd().val(pwd);
        bLogin().click();
    }
}