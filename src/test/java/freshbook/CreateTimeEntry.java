package freshbook;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class CreateTimeEntry extends Base{
    final File file = new File("createTimeEntry.json");


    @Test
    public void createTimeEntry() {
        ExtractableResponse response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(file)
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .body("time_entry.duration", greaterThan(0))
                .body("time_entry.duration", equalTo(7200))
                .extract();

        id = response.jsonPath().get("time_entry.id");
    }
}
