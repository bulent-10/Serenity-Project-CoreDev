package serenity.spartan;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static net.serenitybdd.rest.SerenityRest.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

@SerenityTest
public class SimpleSpartanTest {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://54.90.101.103:8000";
        RestAssured.basePath = "/api";
    }

    @AfterAll
    public static void cleanUp(){
        SerenityRest.clear();
        RestAssured.reset();
    }

    @DisplayName("Testing GET /api/hello Endpoint")
    @Test
    public void testingHelloEndPoint(){

        when().get("/hello");
//        Serenity's way of generating some steps for verification
        // in the report using Ensure class
        Ensure.that("Make sure endpoint works " ,
                response -> response
                        .statusCode(200)
                        .contentType(ContentType.TEXT)
                        .body( is("Hello from Sparta") )
        );

        Ensure.that("Success response was received",
                        thenResponse -> thenResponse.statusCode(200) )
                .andThat("I got text response" ,
                        blaResponse -> blaResponse.contentType(ContentType.TEXT) )
                .andThat("I got Hello from Sparta" ,
                        vResponse -> vResponse.body( is("Hello from Sparta") ) )
                .andThat("I got my response within 2 seconds",
                        vResponse -> vResponse.time( lessThan(2L), TimeUnit.SECONDS  ) )
        ;


    }

}
