import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HistoricalCurrenciesRateTest {
    private static Response response;

    @Test
    public void getHistoricalCurrenciesRateTest() {
        response = given().get(Consts.URL_CURRENCY + Consts.HISTORICAL_ENDPOINT + Consts.HISTORICAL_DATE + "2018-01-01" + "&" + Consts.HISTORICAL_API_KEY);
        System.out.println(response.asString());
        response.then().statusCode(200);}

    @Test
    public void getHistoricalCurrenciesRateNegativeTest() {
        response = given().get(Consts.URL_CURRENCY + Consts.HISTORICAL_ENDPOINT + Consts.HISTORICAL_DATE + "&" + Consts.HISTORICAL_API_KEY);
        System.out.println(response.asString());
        response.then().body("success", equalTo(false));
        response.then().statusCode(200);}

    @Test
    public void getHistoricalOptionalCurrenciesRateTest() {
        response = given().get(Consts.URL_CURRENCY + Consts.HISTORICAL_ENDPOINT + Consts.HISTORICAL_DATE + "2018-01-01" + "&" + Consts.HISTORICAL_API_KEY + Consts.CURRENCIES + "=USD,EUR,RUB,CAD,NIS");
        System.out.println(response.asString());
        response.then().statusCode(200);
        response.then().body("quotes.USDCAD", equalTo(1.25551f));
        response.then().body("quotes.USDEUR", equalTo(0.832296f));
        response.then().body("quotes.USDRUB", equalTo(57.980701f));}

    @Test
    public void getHistoricalCurrenciesRateWithWrongParamTest(){
        response = given().get(Consts.URL_CURRENCY + Consts.HISTORICAL_ENDPOINT + Consts.HISTORICAL_DATE + "2018-01-01" + "&" + Consts.HISTORICAL_API_KEY + Consts.CURRENCIES + "=EURO");
        System.out.println(response.asString());
        response.then().body("success", equalTo(false));
        response.then().statusCode(200);}
}

