package com.certification.reqres.endpoitns;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class ConsumirApiGet {

    public static void tipoGet(String endPoint, Actor actor) {

        actor.attemptsTo(Get.resource(endPoint)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYzMzMwZjRmNTJmZTUwMDAxNzk3OGU4ZCIsInVzZXJuYW1lIjoiaXNhYmVsbGUiLCJleHAiOjE2Njk0NzY0ODcsImlhdCI6MTY2NDI5MjQ4N30.MKa24EY2hrxXoj5qg3zhxbEFDC9wv32slb1Vr1GG1rQ")
                        .relaxedHTTPSValidation("TLS")
                        .log().all()));

    }

}
