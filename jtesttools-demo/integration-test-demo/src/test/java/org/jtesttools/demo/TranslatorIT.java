package org.jtesttools.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.Arrays;

import org.jtesttools.demo.model.GoogleLanguages;
import org.jtesttools.demo.model.Language.LanguageBuilder;
import org.jtesttools.demo.model.Languages;
import org.jtesttools.mockit.MockItTestConfiguration;
import org.jtesttools.mockit.MockWebIt;
import org.jtesttools.mockit.annotations.MockIt;
import org.jtesttools.mockit.annotations.MockItAnnotations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@ContextConfiguration(classes = MockItTestConfiguration.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
class TranslatorIT {

    @LocalServerPort
    int randomPort;
    @MockIt
    private Translate translate;

    @Test
    public void whenGetLanguagesThenShowMockLanguages() throws Exception {
        GoogleLanguages langs = buildMockLanguages();

        MockWebIt.when(translate.getLanguages()).thenReturn(langs);

        given()
                .when()
                .get("/languages")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("languages", hasSize(3))
                .body("languages.language", hasItems("en", "pt", "es"));
    }

    private GoogleLanguages buildMockLanguages() {
        Languages langs = new Languages();
        langs.setLanguages(Arrays.asList(
                LanguageBuilder.of()
                        .language("en").build(),
                LanguageBuilder.of()
                        .language("pt").build(),
                LanguageBuilder.of()
                        .language("es").build()));
        GoogleLanguages lang = new GoogleLanguages();
        lang.setData(langs);

        return lang;
    }

    @Test
    public void whenUpdateSomething() {

        MockWebIt.mock(translate).updateSomething();


    }

    @BeforeEach
    public void initMock() {
        MockItAnnotations.initMocks(this);
        RestAssured.port = randomPort;
    }

}
