package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    String email = "tom@yandex.by";
    String password = "321321";
    private LoginPage loginPage;

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Вход по кнопке \"Войти\" на главной странице")
    public void loginViaLoginButtonOnMainPage() {
        loginPage = open(MainPage.URL, MainPage.class)
                .clickLoginButton();
        assertTrue("Main page is not opened after login", isLoginSuccessful());
    }

    @Test
    @DisplayName("Вход по кнопке \"Личный кабинет\" на главной странице")
    public void loginViaPersonalAccountButtonOnMainPage() {
        loginPage = open(MainPage.URL, MainPage.class)
                .clickPersonalAccountButtonBeforeLogin();
        assertTrue("Main page is not opened after login", isLoginSuccessful());
    }

    @Test
    @DisplayName("Вход по кнопке \"Войти\" на странице регистрации")
    public void loginViaLoginButtonOnRegistrationPage() {
        loginPage = open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickRegisterButton()
                .clickLoginButton();
        assertTrue("User is not logged in", isLoginSuccessful());

    }

    @Test
    @DisplayName("Вход по кнопке \"Войти\" на странице восстановления пароля")
    public void loginViaLoginButtonOnForgotPasswordPage() {
        loginPage = open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickForgotPasswordButton()
                .clickLoginButton();
        assertTrue("User is not logged in", isLoginSuccessful());
    }


    private boolean isLoginSuccessful() {
        return loginPage
                .setEmailField(email)
                .setPasswordField(password)
                .clickLoginButton()
                .clickPersonalAccountButtonAfterLogin()
                .isProfileLinkDisplayed();
    }
}
