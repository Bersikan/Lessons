package Helpers;

import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class PageCreator {

    public void createPage(String pageName, String... elementNames) throws IOException {
        FileWriter newFile = new FileWriter(pageName + ".java");
        newFile.write(
                "package pages;" +
                        "import com.codeborne.selenide.SelenideElement;\n" +
                        "import org.openqa.selenium.By;\n" +
                        "import static com.codeborne.selenide.Selenide.*;\n" +
                        "public class " + pageName + " {\n");
        for (int i = 0; i < elementNames.length; i++) {
            newFile.write("public By " + elementNames[i] + " = By.xpath(\"\");\n" +
                    " public SelenideElement " + elementNames[i] + "(){\n" +
                    "        return $(" + elementNames[i] + ");}\n");


        }
        newFile.write("}");
        newFile.flush();
    }

    @Test
    public void test() throws IOException {
        createPage("main", "fLogin");
    }


}
