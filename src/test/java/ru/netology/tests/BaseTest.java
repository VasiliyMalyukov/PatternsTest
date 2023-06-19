package ru.netology.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "http://localhost:9999";
        Configuration.headless = Boolean.parseBoolean(System.getProperty("selenide.headless"));
    }

}
