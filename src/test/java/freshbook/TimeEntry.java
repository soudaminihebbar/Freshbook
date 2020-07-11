package freshbook;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class TimeEntry {
    public int id;

    File file = new File("createTimeEntry.json");

    @Test
    public void createTimeEntry() {
        RestAssured.baseURI ="https://api.freshbooks.com/timetracking/business/3585241/time_entries";
        RestAssured.authentication = RestAssured.oauth2("642427e4ceb0bb6bff140abf531d1de9826284cb7b7a4a37cf838e6bf44bb1a5");

        ExtractableResponse response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(file)
                .post()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("time_entry.duration", greaterThan(0))
                .body("time_entry.duration", equalTo(7200))
                .extract();

        id = response.jsonPath().get("time_entry.id");


    }
}

