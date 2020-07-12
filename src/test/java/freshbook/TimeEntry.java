package freshbook;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;

public class TimeEntry extends Base {









    @Test
    public void delete() {
        RestAssured
                .delete(String.valueOf(id))
                .then()
                .assertThat()
                .statusCode(204);

    }

}

