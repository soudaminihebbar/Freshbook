package freshbook;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

public class Update extends Base{
    final File updateFile = new File("updateTimeEntry.json");
//    String endpoint = "timetracking/business/3585241/time_entries";

    @Test
    public void update() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(updateFile)
                .put(endpoint+"/"+id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
