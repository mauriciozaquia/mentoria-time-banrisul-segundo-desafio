package testBases.viaCep;

import Utilities.FileOperations;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class CepInexistenteTestBase {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    protected static final String requestType = "json";

    @BeforeAll
    public static void setUp(){
        buildCepInexistente();
        buildRequestSpec();
        buildResponseSpec();
    }

    public static void buildRequestSpec(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://viacep.com.br")
                .setBasePath("/ws/"+ FileOperations.getProperties("cep").getProperty("cepInexistente") +"/" + requestType)
                .build();
    }

    public static void buildResponseSpec(){
        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }

    public static void buildCepInexistente(){
        FileOperations.setProperties("cep","cepInexistente","99999999");
    }
}
