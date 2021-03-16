package testCases.viaCep;

import Utilities.FileOperations;
import Utilities.RequestTypes;
import io.qameta.allure.Description;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBases.viaCep.CepInexistenteTestBase;

import static io.restassured.RestAssured.given;

public class getCepInexistenteContratoTestCase extends CepInexistenteTestBase {

    @Description("Testa se os valores de retorno estão de acordo com o contrato")
    @DisplayName("Teste de Contrato - CEP Inexistente")
    @Test
    public void getCepInexistenteContrato() {
        Response payLoad =
                given()
                        .spec(requestSpec)
                        .pathParam("cep", FileOperations.getProperties("cep").getProperty("cepInexistente"))
                .when()
                        .get("/{cep}/" + RequestTypes.getJson())
                .then()
                        .spec(responseSpec).extract().response();
        ;

        payLoad.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/CepInexistenteJsonSchema.json"));
    }

}
