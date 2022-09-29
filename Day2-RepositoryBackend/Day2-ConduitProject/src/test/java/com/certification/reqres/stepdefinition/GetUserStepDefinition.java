package com.certification.reqres.stepdefinition;

import com.certification.reqres.endpoitns.ApiEndpoints;
import com.certification.reqres.endpoitns.ConsumirApi;
import com.certification.reqres.endpoitns.ConsumirApiGet;
import com.certification.reqres.models.AutenticacionModels;
import com.certification.reqres.utils.CrearBody;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetUserStepDefinition {

    private EnvironmentVariables enVars;

    private Actor analista;

    @Before
    public void configurarElEscenario() {
        String baseUrl = enVars.optionalProperty("restapi.baseurl").orElseThrow(IllegalArgumentException::new);
        SerenityRest.useRelaxedHTTPSValidation("TLS");
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("analista");
        analista = Actor.named("Ismael Carvajal").whoCan(CallAnApi.at(baseUrl));
    }

    @Dado("que el analista registró al usuario")
    public void queElAnalistaRegistróAlUsuario() {
        String bodyObtenerUsuario = AutenticacionModels.GET_USER;
        OnStage.theActorInTheSpotlight().remember("bodyObtenerUsuario", bodyObtenerUsuario);
    }

    @Cuando("el analista solicite los usuarios registrados mediante el '(.*)'")
    public void elAnalistaSoliciteLosUsuariosRegistradosMedianteEl(String servicio) {
        String bodyObtenerUsuario = OnStage.theActorInTheSpotlight().recall("bodyObtenerUsuario");
        ConsumirApiGet.tipoGet(ApiEndpoints.obtenerEndpoint(servicio), analista);
    }

    @Entonces("el sistema deberá devolver la información de dichos usuarios con el codigo {int}")
    public void elSistemaDeberáDevolverLaInformaciónDeDichosUsuarios(int codigo) {
        analista.should(
                seeThatResponse("El usuario se obtuvo correctamente",
                        response -> response.statusCode(codigo))
        );
    }

}
