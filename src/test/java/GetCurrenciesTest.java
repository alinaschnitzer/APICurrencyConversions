import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class GetCurrenciesTest {
    private static Response response;

    @Test
    public void getCurrenciesRateTest() {
        response = given().get(Consts.URL_CURRENCY + Consts.LIVE_ENDPOINT + Consts.API_KEY + Consts.SOURCE + "=USD" + Consts.CURRENCIES + "=EUR,CAD,RUB,NIS");
        System.out.println(response.asString());
        response.then().statusCode(200);
        response.then().body("success", equalTo(true));}

    @Test
    public void negativeTestGetCurrenciesWithWrongParam() {
       response = given().get(Consts.URL_CURRENCY + Consts.LIVE_ENDPOINT + Consts.API_KEY + Consts.SOURCE + Consts.CURRENCIES + "=EURO");
        System.out.println(response.asString());
        response.then().statusCode(200);
        response.then().body("success", equalTo(false));}
}

