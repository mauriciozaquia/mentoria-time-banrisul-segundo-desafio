package testBases.viaCep;

import Utilities.CepRequestSpecification;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class CepInvalidoTestBase {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;

    @BeforeAll
    public static void setUp() {
        buildRequestSpec();
        buildResponseSpec();
    }

    public static void buildRequestSpec() {
        requestSpec = CepRequestSpecification.getCepRequestSpecification();
    }

    public static void buildResponseSpec() {
        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.HTML)
                .expectStatusCode(400)
                .build();
    }
}
