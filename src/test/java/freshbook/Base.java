package freshbook;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class Base {

    public static int id;
    public String endpoint = "timetracking/business/3585241/time_entries";

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "https://api.freshbooks.com";
        RestAssured.authentication = RestAssured.oauth2("9ee3aae95e1ebbc3252e16b5d0448816e06ae2e8fb9357ecb16adfbed986d0c1");
    }
}
