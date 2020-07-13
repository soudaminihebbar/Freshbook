package freshbook;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import org.testng.annotations.Test;

import java.io.File;

public class Estimate extends Base {

    public int estimateId;
    File file = new File("estimateData.json");
    File updateEstimate = new File("updateEstimateData.json");

    @Test(priority = 1)
    public void singleEstimate() {

        ExtractableResponse response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(file)
                .post(estimateEndpoint)
                .then()
                .assertThat()
                .statusCode(200)
                .extract();
        estimateId = response.jsonPath().get("response.result.estimate.estimateid");
    }

    @Test(priority = 2)
    public void updateEstimate() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(updateEstimate)
                .put(estimateEndpoint+"/"+estimateId)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void getEstimate() {
        RestAssured
                .given()
                .get(estimateEndpoint+ "/"+estimateId)
                .then()
                .assertThat()
                .statusCode(200);
    }
}

