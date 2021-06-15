import static io.restassured.RestAssured.*;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getAPITestSingleUser {

    @Test
    public void baseSetup(){

//        Specify base URI
        baseURI = "https://reqres.in/api/unknown";

//        Request Object
        RequestSpecification httpRequest = given();

//        Response Object

        Response response = httpRequest.request(Method.GET,"/2");

//        Print response

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

//        status code

        int status = response.getStatusCode();
        System.out.println("status code -> : :" +status);
        Assert.assertEquals(status,200,"Not matched");

//        status line

        String statusLine = response.statusLine();
        System.out.println("statusLine->" +statusLine);

    }
}
