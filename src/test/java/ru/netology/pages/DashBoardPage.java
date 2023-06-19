package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DashBoardPage {
    private final SelenideElement mainElement = $x("//h2[contains(text(), 'Личный кабинет')]");

    public DashBoardPage shouldBeVisible() {
        mainElement.shouldBe(visible);
        return this;
    }
}
