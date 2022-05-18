package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.AccountProfilePage;
import pages.MainPage;

import static org.junit.Assert.assertTrue;


public class PersonalAccountTest {

    AccountProfilePage accountProfilePage;

    String email = "tom@yandex.by";
    String password = "321321";

    @Before
    public void setUp() {
        accountProfilePage = Selenide.open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .setEmailField(email)
                .setPasswordField(password)
                .clickLoginButton()
                .clickPersonalAccountButtonAfterLogin();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void goToPersonalAccount() {
        boolean isPersonalAccountOpened = accountProfilePage.isProfileLinkDisplayed();
        assertTrue("Personal account page is not opened", isPersonalAccountOpened);
    }

    @Test
    @DisplayName("Выход из личного кабинета пользователя")
    public void logoutFromAccount() {
        boolean isUserLogout = accountProfilePage.clickLogoutLink()
                .isLoginPageTitleDisplayed();
        assertTrue("User is not logged out", isUserLogout);
    }

}

