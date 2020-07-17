package com.rodrigoramos.registration.controller;

import com.rodrigoramos.registration.service.impl.PersonServiceImpl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@TestPropertySource("/application-dev.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private PersonServiceImpl personService;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        RestAssured.basePath = "/api/v1/register/person";
    }

    @Test
    void should_Return_Status200_WhenGetPerson() {
        given()
                .auth()
                .basic("admin","123")
                .accept(ContentType.JSON)
                .when()
                .get("/")
                .then()
                .statusCode(HttpStatus.OK.value());
    }


    @Test
    void should_Return_Person_WhenGetByID() {
        given()
                .auth()
                .basic("admin","123")
                .pathParam("id", 1)
                .accept(ContentType.JSON)
                .when()
                .get("/{id}")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("fullName", equalTo("Ronaldo Macedo"));
    }

    @Test
    void should_return_404_getById() {
        given()
                .auth()
                .basic("admin","123")
                .pathParam("id", 99)
                .accept(ContentType.JSON)
                .when()
                .get("/{id}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void should_Return_Status201_WhenCreatePerson() {
        String personNew = "{ \"fullName\": \"Jonas\",\n" +
                "    \"gender\": \"MALE\",\n" +
                "    \"email\": \"ronasl4d1o@bol.com.br\",\n" +
                "    \"dateOfBirth\": \"2000-10-10\",\n" +
                "    \"placeOfBirth\": \"Rio de Janeiro\",\n" +
                "    \"nationality\": \"Brazilian\",\n" +
                "    \"cpf\": \"66375288037\" }";

        given()
                .auth()
                .basic("admin","123")
                .body(personNew)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    void deleteByID() {
        given()
                .auth()
                .basic("admin","123")
                .accept(ContentType.JSON)
                .pathParam("id", 1)
                .when()
                .delete("/{id}")
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Test
    void deleteNotFoundByID() {
        given()
                .auth()
                .basic("admin","123")
                .accept(ContentType.JSON)
                .pathParam("id", 11)
                .when()
                .delete("/{id}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void updatePersonByID() {
        String personUpdated = "{\n" +
                "  \"fullName\": \"Ronaldo Assis\"\n" +
                "}";
        given()
                .auth()
                .basic("admin","123")
                .body(personUpdated)
                .contentType(ContentType.JSON)
                .pathParam("id", 1)
                .when()
                .patch("/{id}")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("fullName", equalTo("Ronaldo Assis"));
    }

    @Test
    void testRedirectPage() {
        given()
                .auth()
                .basic("admin","123")
                .accept(ContentType.JSON)
                .when()
                .get("/redirect")
                .then()
                .statusCode(HttpStatus.OK.value());
    }


}
