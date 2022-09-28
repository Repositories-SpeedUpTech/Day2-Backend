package com.certification.reqres.tasks;

import com.certification.reqres.endpoitns.ApiEndpoints;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class LoginUser implements Task {

    private String endpoint;

    private String loginUser;

    public LoginUser(String nuevoRegistro){
        this.loginUser = loginUser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(ApiEndpoints.obtenerEndpoint(endpoint)).with(request -> request
                .header("Content-Type", "application/json").body(loginUser)));
    }
    public static LoginUser conLaInformacionDel(String loginUser){
        return Tasks.instrumented(LoginUser.class, loginUser);
    }
    public LoginUser yElEndPoint(String endpoint){
        this.endpoint = endpoint;
        return this;
    }
}
