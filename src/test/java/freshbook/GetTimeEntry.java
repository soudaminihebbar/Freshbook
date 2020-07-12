package freshbook;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.hasItem;

public class GetTimeEntry extends Base {

    @Test
    public void getAllTimeEntry() {
        RestAssured
                .given()
                .get()
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
                .get(String.valueOf(id))
                .then()
                .assertThat()
                .statusCode(200);
    }
}
