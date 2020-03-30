package org.jtesttools.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:real-integrationtest.properties")
@Disabled
class RealTranslatorIT {

    @Test
    public void whenGetLanguagesThenVerifyTranslatorLanguages() {
        given()
                .when()
                .get("/languages")
                .then()
                .statusCode(HttpStatus.OK.value())
                //.body("languages", hasSize(104))
                .body("languages.language", hasItems("en", "pt", "es"));
    }

    @BeforeEach
    public void init() {
        RestAssured.port = randomPort;
    }


    @LocalServerPort
    int randomPort;
}
