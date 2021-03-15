package testCases.viaCep;

import Utilities.FileOperations;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testBases.viaCep.CepValidoTestBase;

import static io.restassured.RestAssured.given;

public class getCepValidoTestCase extends CepValidoTestBase {

    @Test
    public void getCepValido() {

        Response payLoad =

                given()
                        .spec(requestSpec)
                .when()
                        .get()
                .then()
                        .spec(responseSpec).extract().response();
        ;

        try {
            String cepConsultado = FileOperations.getProperties("cep").getProperty("cepValido");
            String cepResposta = payLoad.then().extract().path("cep").toString().replaceAll("-","");

            Assertions.assertEquals(cepConsultado , cepResposta);

            setValoresProperties(payLoad.then().extract().path("cep"),
                    payLoad.then().extract().path("logradouro"),
                    payLoad.then().extract().path("complemento"),
                    payLoad.then().extract().path("bairro"),
                    payLoad.then().extract().path("localidade"),
                    payLoad.then().extract().path("uf"),
                    payLoad.then().extract().path("ibge"));
        } catch (Error | Exception e) {
            setValoresProperties("", "", "", "", "", "", "");
            System.out.println("Problema ao consultar cep, retorno diferente do esperado " + e.getMessage());
        }

        payLoad.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/CepValidoJsonSchema.json"));
    }

    public void setValoresProperties(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String ibge) {
        FileOperations.setProperties("retornoConsultaCepValido", "cep", cep);
        FileOperations.setProperties("retornoConsultaCepValido", "logradouro", logradouro);
        FileOperations.setProperties("retornoConsultaCepValido", "complemento", complemento);
        FileOperations.setProperties("retornoConsultaCepValido", "bairro", bairro);
        FileOperations.setProperties("retornoConsultaCepValido", "localidade", localidade);
        FileOperations.setProperties("retornoConsultaCepValido", "uf", uf);
        FileOperations.setProperties("retornoConsultaCepValido", "ibge", ibge);
    }

}
