package ru.netology.pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private final SelenideElement mainElement = $("[data-test-id='login'] input");
    private final SelenideElement loginInput = $("[data-test-id='login'] input");
    private final SelenideElement passwordInput = $("[data-test-id='password'] input");
    private final SelenideElement submitButton = $("button.button");
    private final SelenideElement errorNotification = $(".notification_visible[data-test-id='error-notification']");
    private final SelenideElement errorNotificationMessage = errorNotification.$(".notification__content");



    public AuthPage() {
        Selenide.open("/");
        mainElement.shouldBe(visible);
    }


    public AuthPage setLogin(String login) {
        loginInput
                .should(visible)
                .setValue(login);
        return this;
    }

    public AuthPage setPassword(String password) {
        passwordInput
                .should(visible)
                .setValue(password);
        return this;
    }


    public void clickSubmitButton() {
        submitButton
                .should(visible)
                .click();
    }

    public AuthPage errorNotificationShouldHaveText(String errorText){
        errorNotification.shouldBe(visible);
        errorNotificationMessage
                .shouldHave(text(errorText));
        return this;
    }


}
