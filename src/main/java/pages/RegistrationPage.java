package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "//fieldset[1]//input")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = "//fieldset[2]//input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private SelenideElement passwordField;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement registrationButton;

    @FindBy(how = How.CLASS_NAME, using = "input__error")
    private SelenideElement incorrectPasswordMessage;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement loginButton;

    @Step("Заполнение поля \"Имя\"")
    public RegistrationPage setNameField(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Заполнение поля \"E-mail\"")
    public RegistrationPage setEmailField(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Заполнение поля \"Пароль\"")
    public RegistrationPage setPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Нажатие на кнопку \"Зарегистрироваться\" при верно заполненных полях формы")
    public LoginPage clickRegistrationButtonWithValidDataInForm() {
        this.registrationButton.click();
        return page(LoginPage.class);
    }

    @Step("Нажатие на кнопку \"Зарегистрироваться\" при неверно заполненных полях формы")
    public RegistrationPage clickRegistrationButtonWithInvalidDataInForm() {
        this.registrationButton.click();
        return page(RegistrationPage.class);
    }

    @Step("Отображение сообщения о недопустимом значении в поле \"Пароль\"")
    public boolean isIncorrectPasswordMessageDisplayed() {
        return this.incorrectPasswordMessage.isDisplayed();
    }

    @Step("Нажатие кнопки \"Войти\"")
    public LoginPage clickLoginButton() {
        this.loginButton.click();
        return page(LoginPage.class);
    }

}
