import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class APIEndpointFunctionalityTest {
    @Test
    public void accessWithAccessKeyTest() {
        Response response = given().get(Consts.URL_CURRENCY+Consts.LIVE_ENDPOINT+Consts.API_KEY);
        System.out.println(response.asString());
        response.then().body("success" , equalTo(true));
        response.then().body("source",equalTo( "USD"));}
}
