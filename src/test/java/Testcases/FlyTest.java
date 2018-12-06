package Testcases;

import Helpers.TestBase;
import Pages.LogIn;
import Pages.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class FlyTest extends TestBase {
    @Test
    public void test() throws InterruptedException {
        open("https://www.saucedemo.com/");
        LogIn login = new LogIn();
        login.logIn("standard_user","secret_sauce");
        Main main = new Main();
        Assert.assertEquals(main.tLabel().getText(), "Products", "Wrong title");
        Assert.assertEquals(main.inventoryItems.size(), 6, "not proper inventory items quantity");
        main.getLowerPrice();
    }
}
