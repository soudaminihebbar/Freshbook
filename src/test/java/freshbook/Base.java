package freshbook;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class Base {

    public static int id;

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "https://api.freshbooks.com/timetracking/business/3585241/time_entries";
        RestAssured.authentication = RestAssured.oauth2("a6e8afdb4d0ac8d2abd88bce92c3e3a266c3dc2897a24f343f8a8e046ad5421c");
    }
}
