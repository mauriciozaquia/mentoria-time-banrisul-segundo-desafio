package testCases.viaCep;

import Utilities.FileOperations;
import Utilities.RequestTypes;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBases.viaCep.CepInvalidoTestBase;

import static io.restassured.RestAssured.given;

public class getCepInvalidoTestCase extends CepInvalidoTestBase {

    @Description("Consulta um CEP inválido")
    @DisplayName("Consulta CEP inválido")
    @Test
    public void getCepInvalido() {
        given()
                .spec(requestSpec)
                .pathParam("cep", FileOperations.getProperties("cep").getProperty("cepInvalido"))
        .when()
                .get("/{cep}/" + RequestTypes.getJson())
        .then()
                .spec(responseSpec)
        ;
    }

}
