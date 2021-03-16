package Utilities;

import io.restassured.response.Response;

public class PropertiesSaver {

    public static void setValoresProperties(Response payLoad) {
        FileOperations.setProperties("retornoConsultaCepValido", "cep", payLoad.body().path("cep"));
        FileOperations.setProperties("retornoConsultaCepValido", "logradouro", payLoad.body().path("logradouro"));
        FileOperations.setProperties("retornoConsultaCepValido", "complemento", payLoad.body().path("complemento"));
        FileOperations.setProperties("retornoConsultaCepValido", "bairro", payLoad.body().path("bairro"));
        FileOperations.setProperties("retornoConsultaCepValido", "localidade", payLoad.body().path("localidade"));
        FileOperations.setProperties("retornoConsultaCepValido", "uf", payLoad.body().path("uf"));
        FileOperations.setProperties("retornoConsultaCepValido", "ibge", payLoad.body().path("ibge"));
    }

}
