package com.test_rest_assured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_WebPage {
@Test(priority  =1)
    public  void testGetRequest(){

    given()//no pre request required
            .when()
            .get("https://reqres.in/api/users?delay=3")//this will give me some response

            .then()//we can do validation in here
            .statusCode(200);
    //there is one pass,no failed

}

@Test(priority = 2)
    public  void testPostRequest(){
    //create hashmap object,for put some data inside this hashmap
    HashMap data=new HashMap<>();
    data.put("email","eve.holt@reqres.in");
    data.put("password","cityslicka");

    Response res=

    given()
            .contentType("application/json; charset=utf-8")
            .body(data)//body will contains data
            .when()
            .post("https://reqres.in/api/login")//provide request type and URL in here
            .then()//start validation part
            .statusCode(200)
            .log().body()//what ever data we have ,then it will display on the console window
            .extract().response();


}

@Test(priority = 3)
    public  void getSingleUser(){

        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()//do some validation
                .statusCode(200)
                .log().body()
                .extract().body().jsonPath();



}

@Test(priority = 4)

    public  void  putRequest(){

        HashMap data=new HashMap<>();//put data in here
        data.put("name","morpheus");
        data.put("job","zion resident");

        given()
                .contentType("application/json; charset=utf-8")
                .body(data)
                .when()//star provide method type and navigate to the URL
                .put("https://reqres.in/api/users/2\n")
                .then()//after then keyword we can start validation
                .statusCode(200)
                .log().body();
}

@Test(priority = 5)
    public  void DeleteRequest() throws InterruptedException {

        given()
                .when()
                .delete("https://reqres.in/api/users/2\n")//after method type,directly move to next line is then keyword
                .then()
                .statusCode(204)
                .log().body()
                .extract().response();

        Thread.sleep(3000);
}

}
