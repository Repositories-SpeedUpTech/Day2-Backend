package com.certification.reqres.tasks;

import com.certification.reqres.endpoitns.ApiEndpoints;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class AddUser implements Task {

    private String endpoint;

    private String addUser;

    public AddUser(String nuevoRegistro){
        this.addUser = addUser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(ApiEndpoints.obtenerEndpoint(endpoint)).with(request -> request
                .header("Content-Type", "application/json").body(addUser)));
    }
    public static AddUser conLaInformacionDel(String addUser){
        return Tasks.instrumented(AddUser.class, addUser);
    }
    public AddUser yElEndPoint(String endpoint){
        this.endpoint = endpoint;
        return this;
    }

}
