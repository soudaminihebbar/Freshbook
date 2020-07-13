package freshbook;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Delete extends Base {
//    String endpoint = "timetracking/business/3585241/time_entries";

    @Test
    public void delete() {
        RestAssured
                .delete(endpoint+"/"+id)
                .then()
                .assertThat()
                .statusCode(204);

    }

}

