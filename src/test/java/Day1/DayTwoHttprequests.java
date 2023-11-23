package Day1;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class DayTwoHttprequests {

@Test()
    void CreateUser() throws FileNotFoundException {

    //1/2.JSON Data request type and HASHMAP both are same just convert data to the string
//    JSONObject data = new JSONObject();
//    data.put("name","morpheus");
//    data.put("job","leader");
//    3.USING POJO for SENDING DATA //Create a class with getter and setter then call the class here
//    pojo_data data = new pojo_data();
//    data.setName("Sahil");
//    data.setJob("QAAAAAA");
    //4. External Json file

        File data_file = new File("/Users/pdgt/IdeaProjects/RestAssured/src/test/java/Day1/body.json");
        FileReader file_reader = new FileReader(data_file);
        JSONTokener jt = new JSONTokener(file_reader);
        JSONObject data = new JSONObject(jt);

    given()
            .contentType("application/json")
            .body(data.toString())
            .when().post("https://reqres.in/api/users")
            .then().log().status()
            .statusCode(201)
            .body("name",equalTo("sahil"))
            .body("job",equalTo("QA Analyst"))
            .log().all();

}}
