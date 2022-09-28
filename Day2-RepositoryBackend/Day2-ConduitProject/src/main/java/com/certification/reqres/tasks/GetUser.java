package com.certification.reqres.tasks;

import com.certification.reqres.endpoitns.ApiEndpoints;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class GetUser implements Task {

    private String endpoint;

    private String getUser;

    public GetUser(String traerRegistro){
        this.getUser = getUser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(ApiEndpoints.obtenerEndpoint(endpoint)).with(request -> request
                .header("Content-Type", "application/json").body(getUser)));
    }
    public static GetUser conLaInformacionDel(String getUser){
        return Tasks.instrumented(GetUser.class, getUser);
    }
    public GetUser yElEndPoint(String endpoint){
        this.endpoint = endpoint;
        return this;
    }

}
