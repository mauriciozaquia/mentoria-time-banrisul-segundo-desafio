package testCases.viaCep;

import Utilities.FileOperations;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testBases.viaCep.PesquisarCepTestBase;

import static io.restassured.RestAssured.given;

public class getCepTestBase extends PesquisarCepTestBase {

    @Test
    public void getCepValido(){

        Response payLoad =

        given()
                .spec(requestSpec)
        .when()
                .get()
        .then()
                .log().all()
                .spec(responseSpec).extract().response();
        ;


        String cepConsultado = FileOperations.getProperties("cep").getProperty("cepValido");
        String cepResposta = payLoad.then().extract().path("cep");
        cepResposta = cepResposta.replaceAll("-","");
        Assertions.assertEquals(cepConsultado, cepResposta);

        FileOperations.setProperties("retornoConsultaCepValido","cep", payLoad.then().extract().path("cep"));
        FileOperations.setProperties("retornoConsultaCepValido","logradouro", payLoad.then().extract().path("logradouro"));
        FileOperations.setProperties("retornoConsultaCepValido","complemento", payLoad.then().extract().path("complemento"));
        FileOperations.setProperties("retornoConsultaCepValido","bairro", payLoad.then().extract().path("bairro"));
        FileOperations.setProperties("retornoConsultaCepValido","localidade", payLoad.then().extract().path("localidade"));
        FileOperations.setProperties("retornoConsultaCepValido","uf", payLoad.then().extract().path("uf"));
        FileOperations.setProperties("retornoConsultaCepValido","ibge", payLoad.then().extract().path("ibge"));

        //TODO criar contrato

    }

}
