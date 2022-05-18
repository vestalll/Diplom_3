package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginButton;

    @Step("Переход на страницу входа по нажатию на кнопку \"Войти\"")
    public LoginPage clickLoginButton() {
        this.loginButton.click();
        return page(LoginPage.class);
    }
}

