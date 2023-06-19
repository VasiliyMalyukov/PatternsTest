package ru.netology.utils;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ru.netology.models.User;

import java.util.Locale;

import static io.restassured.RestAssured.given;

public class DataGenerator {
    private static final Faker faker = new Faker(new Locale("en"));
    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    private DataGenerator() {

    }


    private static void sendPostUserRequest(User user) {
        given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post("api/system/users")
                .then()
                .statusCode(200);
    }

    public static User createRandomUser(String status) {
        return new User(faker.name().username(), faker.name().lastName(), status);
    }

    public static User createRegisteredUser(String status) {
        User user = createRandomUser(status);
        sendPostUserRequest(user);
        return user;
    }


}
