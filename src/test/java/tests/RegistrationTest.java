package tests;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    String name = RandomStringUtils.randomAlphabetic(1, 50);
    String email = RandomStringUtils.randomAlphanumeric(1, 50) + "@" + RandomStringUtils.randomAlphabetic(1, 10) + "." + RandomStringUtils.randomAlphabetic(2, 5);
    String password = RandomStringUtils.randomAlphanumeric(6, 20);
    String invalidPassword = RandomStringUtils.randomAlphanumeric(1, 5);

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void userRegistrationTest() {
        boolean isLoginPageDisplayedAfterRegistration = open(RegistrationPage.URL, RegistrationPage.class)
                .setNameField(name)
                .setEmailField(email)
                .setPasswordField(password)
                .clickRegistrationButtonWithValidDataInForm()
                .isLoginPageTitleDisplayed();
        assertTrue("Login page is not displayed", isLoginPageDisplayedAfterRegistration);
    }


    @Test
    @DisplayName("Ошибка при попытке регистрации с некорректным паролем")
    public void userRegistrationWithInvalidPasswordTest() {
        boolean isIncorrectPasswordMessageDisplayed = open(RegistrationPage.URL, RegistrationPage.class)
                .setNameField(name)
                .setEmailField(email)
                .setPasswordField(invalidPassword)
                .clickRegistrationButtonWithInvalidDataInForm()
                .isIncorrectPasswordMessageDisplayed();
        assertTrue("Incorrect password message is not displayed", isIncorrectPasswordMessageDisplayed);

    }
}
