package restAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class apiTests {
    RequestSpecification requestSpec = given().baseUri("https://catfact.ninja/");
    Response response;

    /**
     * https://github.com/rest-assured/rest-assured/wiki/Usage#static-imports
     * https://catfact.ninja/#/Breeds/getBreeds
     * https://jsonpath.com/
     */
    @Test
    public void apiTestMethod() {
//        get("https://catfact.ninja/breeds").then().body("total", equalTo(98));

//        response.body().asPrettyString();
//        Assert.assertEquals(response.body().asPrettyString(), "");
//        response.body().jsonPath().get("total");
//        response.body().jsonPath().get("per_page");

        response.then().assertThat()
                .body("total", equalTo(98))
                .body("per_page", greaterThanOrEqualTo(25))
                .statusCode(200)
                .time(lessThanOrEqualTo(2L), TimeUnit.SECONDS);
//                .body(matchesJsonSchema(new File("")));

//        var totalNumberOfBreeds = validatableRequest.extract().body().jsonPath().get("total");
//        Assert.assertEquals(totalNumberOfBreeds, 98);
    }

    @Test
    public void apiTestMethod2() {
//        var test2 = response.body().jsonPath().get("data.breed");
        response.then().assertThat()
                .body("data.breed", hasItems("Balinese", "Chausie"));
    }

    @BeforeClass
    public void beforeClass() {
        response = requestSpec.when().get("breeds");
    }
}
