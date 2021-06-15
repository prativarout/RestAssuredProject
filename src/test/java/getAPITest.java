import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class getAPITest {

    @Test
    public void getAPI(){
        given().

                when().
                get("https://reqres.in/api/users").
                then().
                log().all().
                assertThat().
                statusCode(200).
                and().
                body("data.id",hasSize(6),"data.email",hasItems("george.bluth@reqres.in","janet.weaver@reqres.in","emma.wong@reqres.in","eve.holt@reqres.in","charles.morris@reqres.in","tracey.ramos@reqres.in"),"data[2].first_name",is(equalTo("Emma"))).
                and().
                header("Content-Encoding",equalTo("gzip"));
    }
}
