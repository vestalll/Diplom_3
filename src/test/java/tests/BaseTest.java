package tests;

import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void gogo() {
        Configuration.browser = System.getProperty("browser");
    }
}
