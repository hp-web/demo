package com.apiTest;

import com.utils.ReadProperties;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTestDemo {
        @Test
        public void requestGet(){

            String url = ReadProperties.getBundle("test.url")+ReadProperties.getBundle("demo");
            Response s = given()
                    .when()
                    .get(url);
            System.out.println(s.prettyPrint());
        }

}
