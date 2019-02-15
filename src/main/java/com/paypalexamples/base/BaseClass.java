package com.paypalexamples.base;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BaseClass {

    public static String accessTocken;
    public static final String clientId = "AUzmV1sS5iQozdZokZu-0EBOa-Kk1lP-iAl90LlS1Mq-qtN5zzO8rDaPvxjlsTYXOAPxcxRFUMeGnWbS";
    public static final String clientSecret = "EDi-Sgo2m1I_4yK7gB5IHZxTY8bCb4oH_RtPw7w4plHEAdkFGOlCvmT-f_c6Oki7cT6b_c_pIC7JfcIb";


    @BeforeClass
    public static void init(){

        RestAssured.baseURI = "https://api.sandbox.paypal.com";
        RestAssured.basePath = "/v1";

        accessTocken = given()
                .parameters("grant_type", "client_credentials")
                .auth()
                .preemptive()
                .basic(clientId, clientSecret)
                .when()
                .post("/oauth2/token")
                .then()
                .extract()
                .path("access_token");

        System.out.println("The tocken is: "+accessTocken);

    }

    @Test
    public void something(){

    }
}
