package com.redhat.summit2019;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TwitterServiceTest {

    private static final String ENDPOINT_PATH = "api/tweet";

    @Value("${local.server.port}")
    private int port;

    @Test
    public void testTwitterEndpoint() {

        Map<String, String> insultBody = new HashMap<>();
        insultBody.put("insult", "Verily, ye be a pox-marked, rank blind-worm!");

        RestAssured.baseURI = String.format("http://localhost:%d", port);

        Response response = given()
                .contentType("application/json")
                .body(insultBody)
                .post(ENDPOINT_PATH)
                .then()
                .statusCode(200)
                .extract().response();
        assertNotNull(response);
        System.out.println(response.toString());
    }

}