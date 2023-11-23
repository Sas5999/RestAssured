package Day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class DayThreeCookies {


    @Test()
    void GetUser() {
        given()
                .pathParam("type","unknown") //Using dynamic variables.
                .pathParam("id",2)

                .when().get("https://reqres.in/api/{type}/{id}")
                .then().statusCode(200)
                .log().all()
                .body("data.id",equalTo(2))
                .body("data.name",equalTo("fuchsia rose"));
    }
    @Test()
    void GetUsers(){
        given()// query params are added
                .pathParam("user_type","users")
                .queryParam("page", 2)
                .when().get("https://reqres.in/api/{user_type}")
                .then().statusCode(200).log().all();
    }
    }

