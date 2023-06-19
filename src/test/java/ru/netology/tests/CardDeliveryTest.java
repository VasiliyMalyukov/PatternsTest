package ru.netology.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.models.User;
import ru.netology.pages.AuthPage;
import ru.netology.pages.DashBoardPage;
import ru.netology.utils.DataGenerator;

import static ru.netology.enums.ValidationMessages.USER_BLOCKED;
import static ru.netology.enums.ValidationMessages.WRONG_USERNAME_OR_PASSWORD;
import static ru.netology.utils.DataGenerator.createRandomUser;
import static ru.netology.utils.DataGenerator.createRegisteredUser;

public class CardDeliveryTest extends BaseTest {

    private AuthPage authPage;

    @BeforeEach
    public void openMainPage() {
        authPage = new AuthPage();
    }

    @Test
    @DisplayName("Проверка входа зарегистрированным пользователем")
    public void shouldLoginRegisteredUser() {
        User user = createRegisteredUser("active");

        authPage
                .setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .clickSubmitButton();
        new DashBoardPage().shouldBeVisible();
    }

    @Test
    @DisplayName("Проверка появления ошибки при входе незарегистрированным пользователем")
    public void shouldNotLoginUnRegisteredUser() {
        User user = createRandomUser("active");
        authPage
                .setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .clickSubmitButton();
        authPage.errorNotificationShouldHaveText(WRONG_USERNAME_OR_PASSWORD.getValue());
    }

    @Test
    @DisplayName("Проверка появления ошибки при входе заблокированным пользователем после регистрации")
    public void shouldNotLoginBlockedRegisteredUser() {
        User user = createRegisteredUser("blocked");

        authPage
                .setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .clickSubmitButton();
        authPage.errorNotificationShouldHaveText(USER_BLOCKED.getValue());

    }


    @Test
    @DisplayName("Проверка появления ошибки при входе зарегистрированным пользователем с некорректным паролем")
    public void shouldNotLoginWithIncorrectPassword() {
        User user = DataGenerator.createRegisteredUser("active");
        user.setPassword(user.getPassword().substring(1));

        authPage
                .setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .clickSubmitButton();
        authPage.errorNotificationShouldHaveText(WRONG_USERNAME_OR_PASSWORD.getValue());

    }

}
