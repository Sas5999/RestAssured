package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

import org.hamcrest.Matchers.*;

import java.util.HashMap;


public class Httprequests {
    int id;


    @Test(priority = 0)
    void CreateUser()
    {
        HashMap data = new HashMap();
        data.put("name","Sahil");
        data.put("job","QA");
        id = given()
                .contentType("application/json").body(data)
                .when().post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
//                .then().statusCode(201).log().all();
    }



    @Test(priority = 1)
    void UpdateUser() {
        HashMap data = new HashMap();
        data.put("name","Sahil Kapil");
        data.put("job","QA Analyst");
        given()
                .contentType("application/json").body(data)
                .when().put("https://reqres.in/api/users/"+id)
                .then().statusCode(200).log().all();
    }
    @Test(priority = 3)
    void GetUser()
    {
        when().get( "https://reqres.in/api/users?page=2")

        .then().statusCode(200).body("page", equalTo(2)).log().all();
    }

    @Test(priority = 2)
    void DeleteUser(){
        when().delete("https://reqres.in/api/users/8")
                .then().statusCode(204).log().all();
        System.out.println("Deletion successful");
    }

    private void then() {
    }


}
//BDD approach will be followed Gherken Lang
// Given - Pre-Requisites Cookies auth params headers
// When get post put patch delete
// AND
// Then assert compare response