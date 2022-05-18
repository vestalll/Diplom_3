package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AccountProfilePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.CLASS_NAME, using = "Account_link__2ETsJ")
    private SelenideElement profileLink;


    @FindBy(how = How.CLASS_NAME, using = "Account_button__14Yp3")
    private SelenideElement logoutLink;

    @Step("Переход в раздел \"Профиль\"")
    public AccountProfilePage clickProfileLink() {
        this.profileLink.click();
        return this;
    }

    @Step("Отображение ссылки \"Профиль\"")
    public boolean isProfileLinkDisplayed() {
        profileLink.shouldBe(Condition.visible);
        return this.profileLink.isDisplayed();
    }


    @Step("Выход из личного кабинета по нажатию на ссылку \"Выход\"")
    public LoginPage clickLogoutLink() {
        this.logoutLink.shouldBe(Condition.visible).click();
        return page(LoginPage.class);
    }

}
