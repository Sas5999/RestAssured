package Day1;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class GetCookies {

    @Test()
    void TestCookies(){

        given()//This should fail always
                .when().get("https://www.google.com")
                .then()
                .body("AEC",equalTo("Ackid1Srf4sYZGByWB7XR3pDilBWGFiOmVl5qkjlqNUjFonBUn9bhro4SIo"))
                .log().all();
    }

    @Test(priority = 2)
    void GetSpecificCookie(){
       Response res = given()//This will print specific cookie
                .when().get("https://www.google.com");
       //Get AEC
        String cookie_value = res.getCookie("AEC");
        System.out.println("value for AEC is " + cookie_value);
        Map<String,String> all_cookies =  res.getCookies();
        System.out.println("all cookies"+ all_cookies.keySet());

        for (String single: all_cookies.keySet()){
            String cookie_valueset = res.getCookie(single);
            System.out.println(single + "  " + cookie_valueset);
        }


    }
    @Test(priority = 3 )
    void GetHeader(){
        Response res = given()//This will print specific cookie
                .when().get("https://www.google.com");
        //Get AEC
        String header_value = res.header("Content-Type");
        System.out.println("value for content type is " + header_value);

    }

    @Test(priority = 4 )
    void GetHeaders(){
        given()//This will print specific cookie
                .when().get("https://www.google.com")
                .then()
                .header("Content-Type",equalTo("text/html; charset=ISO-8859-1"));

    }}
