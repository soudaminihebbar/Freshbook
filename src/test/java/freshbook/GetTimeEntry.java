package freshbook;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.hasItem;

public class GetTimeEntry extends Base {

//    String endpoint = "timetracking/business/3585241/time_entries";

    @Test
    public void getAllTimeEntry() {
        RestAssured
                .given()
                .get(endpoint)
                .then()
                .assertThat()
                .statusCode(200)
                .body("time_entries.id", hasItem(id))
                .extract();
    }

    @Test
    public void getLatest() {
        RestAssured
                .given()
                .get(endpoint+"/"+id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
