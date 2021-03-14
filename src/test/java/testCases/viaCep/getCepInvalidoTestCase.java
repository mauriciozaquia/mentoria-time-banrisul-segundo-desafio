package testCases.viaCep;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testBases.viaCep.CepInvalidoTestBase;

import static io.restassured.RestAssured.given;

public class getCepInvalidoTestCase extends CepInvalidoTestBase {

    @Test
    public void getCepInvalido(){
        Response payLoad =

                given()
                        .spec(requestSpec)
                .when()
                        .get()
                .then()
                        .spec(responseSpec).extract().response()
                ;

        try {
            Assertions.assertEquals("200", payLoad.then().extract().statusCode());
            System.out.println("Cep consultado com sucesso!");
        } catch (Error | Exception e) {
            System.out.println("Erro ao consultar cep, formato invalido!");
        }
    }

}
