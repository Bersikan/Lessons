package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Main {
    public By tLabel = By.className("product_label");
    public By lInventory = By.className("inventory_item");
    public List<SelenideElement> inventoryItems = $$(lInventory);
    public List<SelenideElement> prices = $$("div.inventory_item_price");

    public SelenideElement tLabel() {
        return $(tLabel);
    }

    public String getLowerPrice() {
        List<Float> arr = new ArrayList<Float>();
        for (SelenideElement price : prices) {
            arr.add(Float.parseFloat(price.getText().replace("$", "")));
        }
        String min = Collections.min(arr).toString();
        return min;
    }
}

