package ru.netology.enums;

public enum ValidationMessages implements IEnumValue {
    USER_BLOCKED("Ошибка! Пользователь заблокирован"),
    WRONG_USERNAME_OR_PASSWORD("Ошибка! Неверно указан логин или пароль");

    private String messageKey;

    ValidationMessages(String messageKey) {
        this.messageKey = messageKey;
    }


    @Override
    public String getValue() {
        return this.messageKey;
    }
}
