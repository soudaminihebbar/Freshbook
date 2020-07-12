package freshbook;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.hasItem;

public class TimeEntry extends Base {


    final File updateFile = new File("updateTimeEntry.json");





    @Test
    public void update() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(updateFile)
                .put(String.valueOf(id))
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void delete() {
        RestAssured
                .delete(String.valueOf(id))
                .then()
                .assertThat()
                .statusCode(204);

    }

}

