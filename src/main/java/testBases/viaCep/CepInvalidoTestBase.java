package testBases.viaCep;

import Utilities.FileOperations;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class CepInvalidoTestBase {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    protected static final String requestType = "json";

    @BeforeAll
    public static void setUp(){
        buildCepInvalido();
        buildRequestSpec();
        buildResponseSpec();
    }

    public static void buildRequestSpec(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://viacep.com.br")
                .setBasePath("/ws/"+ FileOperations.getProperties("cep").getProperty("cepInvalido") +"/" + requestType)
                .build();
    }

    public static void buildResponseSpec(){
        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.HTML)
                .expectStatusCode(400)
                .build();
    }

    public static void buildCepInvalido(){
        FileOperations.setProperties("cep","cepInvalido","12-34");
    }
}
