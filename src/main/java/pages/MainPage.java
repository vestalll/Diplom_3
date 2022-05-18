package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement loginButton;

    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement personalAccountButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__linkText__3q_va")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunTab;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunTabTitle;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sauceTab;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement sauceTabTitle;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingTab;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement fillingTabTitle;

    @Step("Переход на страницу входа по нажатию на кнопку \"Войти\"")
    public LoginPage clickLoginButton() {
        this.loginButton.click();
        return page(LoginPage.class);
    }

    @Step("Попытка перехода в личный кабинет пользователя без авторизации")
    public LoginPage clickPersonalAccountButtonBeforeLogin() {
        this.personalAccountButton.click();
        return page(LoginPage.class);
    }

    @Step("Переход в личный кабинет пользователя после авторизации")
    public AccountProfilePage clickPersonalAccountButtonAfterLogin() {
        this.personalAccountButton.click();
        return page(AccountProfilePage.class);
    }

    @Step("Отображение заголовка раздела \"Констуктор\"")
    public boolean isConstructorButtonDisplayed() {
        return this.constructorButton.shouldBe(visible).isDisplayed();
    }

    @Step("Переход к разделу \"Булки\"")
    public MainPage clickBunTab() {
        this.bunTab.click();
        return this;
    }

    @Step("Отображение заголовка раздела \"Булки\"")
    public boolean isBunTabTitleDisplayed() {
        return this.bunTabTitle.isDisplayed();
    }

    @Step("Переход к разделу \"Соусы\"")
    public MainPage clickSauceTab() {
        this.sauceTab.click();
        return this;
    }

    @Step("Отображение заголовка раздела \"Соусы\"")
    public boolean isSauceTabTitleDisplayed() {
        return this.sauceTabTitle.isDisplayed();
    }

    @Step("Переход к разделу \"Начинки\"")
    public MainPage clickFillingTab() {
        this.fillingTab.click();
        return this;
    }

    @Step("Отображение заголовка раздела \"Начинки\"")
    public boolean isFillingTabTitleDisplayed() {
        return this.fillingTabTitle.isDisplayed();
    }

}