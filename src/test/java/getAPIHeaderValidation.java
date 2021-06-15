import static io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class getAPIHeaderValidation {

//    RequestSpecBuilder builder;

    @Test
    public void allHeadersValidation(){

        RequestSpecification httpRequest = given();

        httpRequest.baseUri("https://reqres.in/api");

        httpRequest.header("Content-Type","application/json");

//        Response
        Response response = httpRequest.request(Method.GET,"/unknown");

//        Response body

        String body = response.getBody().asString();
        System.out.println("response body -> " +body);

//        capture individual header

        String header1 = response.header("Content-Type");
        System.out.println("Header -> " + header1);

        Headers allHeader = response.headers();

        for(Header header : allHeader){
            System.out.println("Name -> " + header.getName()+ " Value->  " + header.getValue() );
        }
    }
}
