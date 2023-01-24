import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class AccessWithoutAccessKeyNegativeTest {
    @Test
    public void accessWithoutAccessKeyTest() {
        Response response = given().get(Consts.URL_CURRENCY+Consts.LIVE_ENDPOINT+Consts.INVALID_API_KEY);
        System.out.println(response.asString());
        response.then().statusCode(401);
        response.then().body("message", containsString("Invalid authentication credentials"));}
}
