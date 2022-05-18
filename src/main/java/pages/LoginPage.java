package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.NAME, using = "name")
    private SelenideElement emailField;

    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordField;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement loginButton;

    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement registerButton;

    @FindBy(how = How.LINK_TEXT, using = "Восстановить пароль")
    private SelenideElement forgotPasswordButton;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement loginPageTitle;

    @Step("Заполнение поля \"E-mail\"")
    public LoginPage setEmailField(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Заполнение поля \"Пароль\"")
    public LoginPage setPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Переход на страницу входа по нажатию на ссылку \"Войти\"")
    public MainPage clickLoginButton() {
        this.loginButton.click();
        return page(MainPage.class);
    }

    @Step("Переход на страницу регистрации по нажатию на ссылку \"Зарегистрироваться\"")
    public RegistrationPage clickRegisterButton() {
        this.registerButton.click();
        return page(RegistrationPage.class);
    }

    @Step("Переход на страницу восстановления пароля по нажатию на ссылку \"Восстановить пароль\"")
    public ForgotPasswordPage clickForgotPasswordButton() {
        this.forgotPasswordButton.click();
        return page(ForgotPasswordPage.class);
    }

    @Step("Отображение названия страницы входа")
    public boolean isLoginPageTitleDisplayed() {
        return this.loginPageTitle.shouldBe(Condition.visible).isDisplayed();
    }
}
