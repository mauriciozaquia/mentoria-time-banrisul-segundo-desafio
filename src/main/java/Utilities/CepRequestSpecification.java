package Utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class CepRequestSpecification {

    public static RequestSpecification getCepRequestSpecification() {

        return new RequestSpecBuilder()
                .setBaseUri("https://viacep.com.br")
                .setBasePath("/ws")
                .build();

    }

}
