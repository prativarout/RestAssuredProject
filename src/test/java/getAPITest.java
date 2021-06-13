import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class getAPITest {

    @Test
    public void getAPI(){
        given().when().get("https://reqres.in/api/users").then().assertThat().body("data.id",hasSize(6));
    }
}
