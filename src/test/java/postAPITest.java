import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class postAPITest {

    @Test
    public void postTest(){

//        Specify base URI - RestAssured method
//        baseURI = "https://reqres.in/api";

//        Request Object
        RequestSpecification httpRequest = given();

//        Response Object
//        RequestSpecification methods - baseUri,baseUri,header,body,request

        httpRequest.baseUri("https://reqres.in/api");

        JSONObject requestParm = new JSONObject();

//        Request Payload sending along with post request


        requestParm.put("name","Prativa");
        requestParm.put("job","Leader");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParm.toJSONString()); //attach data to the request

//        Response object

        Response response = httpRequest.request(Method.POST,"/users");


//        Print response

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

//        status code

        int status = response.getStatusCode();
        System.out.println("status code -> : :" +status);
        Assert.assertEquals(status,201,"Not matched");

//        status line

        String statusLine = response.statusLine();
        System.out.println("statusLine->" +statusLine);

    }
}
