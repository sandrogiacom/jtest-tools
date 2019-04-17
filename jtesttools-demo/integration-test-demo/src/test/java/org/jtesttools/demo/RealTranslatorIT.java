package org.jtesttools.demo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
class RealTranslatorIT {

    @LocalServerPort
    int randomPort;

    @BeforeEach
    public void initMock() {
        RestAssured.port = randomPort;
    }

    @Test
    public void whenSayHelloThenShowMockMessage() {
        given()
                .when()
                .get("/languages")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().response().prettyPrint();
//                .body("languages", hasSize(2))
//                .body("languages[0].language", equalTo("af"))
//                .body("languages[1].language", equalTo("pt"));
    }


}
