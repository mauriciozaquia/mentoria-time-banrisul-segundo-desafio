package testBases.viaCep;

import Utilities.FakersGeneratorPtBr;
import Utilities.FileOperations;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class PesquisarCepTestBase {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    protected static final String requestType = "json";
    private static FakersGeneratorPtBr fakerPtBr = new FakersGeneratorPtBr();


    @BeforeAll
    public static void setUp(){
        buildRequestSpec();
        buildResponseSpec();
    }

    public static void buildRequestSpec(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://viacep.com.br")
                .setBasePath("/ws/"+ FileOperations.getProperties("cep").getProperty("cepValido") +"/" + requestType)
                .build();
    }

    public static void buildResponseSpec(){
        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }

}
