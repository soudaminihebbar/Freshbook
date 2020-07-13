package freshbook;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

public class Estimate extends Base {

    File file = new File("estimateData.json");

    @Test
    public void singleEstimate() {

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(file)
                .post("accounting/account/AQggqQ/estimates/estimates")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
