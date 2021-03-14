package testCases.viaCep;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import testBases.viaCep.CepInexistenteTestBase;

import static io.restassured.RestAssured.given;

public class getCepInexistenteTestCase extends CepInexistenteTestBase {

    @Test
    public void getCepInexistente(){

        Response payLoad =

        given()
                .spec(requestSpec)
        .when()
                .get()
        .then()
                .log().all()
                .spec(responseSpec).extract().response()
        ;

        Boolean erro = payLoad.then().extract().body().path("erro");
        System.out.println(erro.toString());

        payLoad.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/CepInexistenteJsonSchema.json"));

    }

}
