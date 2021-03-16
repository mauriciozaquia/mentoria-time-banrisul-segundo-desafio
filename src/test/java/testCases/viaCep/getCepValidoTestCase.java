package testCases.viaCep;

import Utilities.FileOperations;
import Utilities.PropertiesSaver;
import Utilities.RequestTypes;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBases.viaCep.CepValidoTestBase;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getCepValidoTestCase extends CepValidoTestBase {

    @Description("Consulta um CEP válido")
    @DisplayName("Consulta CEP válido")
    @Test
    public void getCepValido() {

        Response payLoad =

                given()
                        .spec(requestSpec)
                        .pathParam("cep", FileOperations.getProperties("cep").getProperty("cepValido"))
                .when()
                        .get("/{cep}/" + RequestTypes.getJson())
                .then()
                        .body("cep", equalTo("91060-900"))
                        .body("complemento", equalTo(""))
                        .body("logradouro", equalTo("Avenida Assis Brasil 3940"))
                        .body("bairro", equalTo("São Sebastião"))
                        .body("uf", equalTo("RS"))
                        .body("ibge", equalTo("4314902"))
                        .spec(responseSpec).extract().response();
        ;

        String cepConsultado = FileOperations.getProperties("cep").getProperty("cepValido");
        String cepResposta = payLoad.then().extract().path("cep").toString().replaceAll("-", "");
        Assertions.assertEquals(cepConsultado, cepResposta);

        PropertiesSaver.setValoresProperties(payLoad);
    }

    @Description("Consulta um endereco valido a partir de um logradouro")
    @DisplayName("Consulta CEP Logradouro")
    @Test
    public void getCepValidoLogradouro() {

        Response payLoad =

                given()
                        .spec(requestSpec)
                        .pathParam("estado", FileOperations.getProperties("cep").getProperty("estado"))
                        .pathParam("cidade", FileOperations.getProperties("cep").getProperty("cidade"))
                        .pathParam("logradouro", FileOperations.getProperties("cep").getProperty("logradouro"))
                .when()
                        .get("/{estado}/{cidade}/{logradouro}/" + RequestTypes.getJson())
                .then()
                        .spec(responseSpec).extract().response();
        ;

        ArrayList<String> cepsActual = payLoad.then().extract().path("cep");
        String[] cepsExpected = {"94085-170", "94175-000"};

        Assertions.assertArrayEquals(cepsExpected, cepsActual.toArray());
    }

}
