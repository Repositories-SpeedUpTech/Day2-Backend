package com.certification.reqres.stepdefinition;

import com.certification.reqres.endpoitns.ApiEndpoints;
import com.certification.reqres.endpoitns.ApiEndpontLogin;
import com.certification.reqres.endpoitns.ConsumirApi;
import com.certification.reqres.endpoitns.ConsumirApiLogin;
import com.certification.reqres.models.AutenticacionModels;
import com.certification.reqres.utils.CrearBody;
import com.certification.reqres.utils.CrearBodyLogin;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;
import java.util.Map;

public class LoginUserStepDefinition {
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

    @Dado("que el analista loguea al usuario con los siguientes datos:")
    public void queElAnalistaLogueaAlUsuarioConLosSiguientesDatos(List<Map<String, String>> datos) {
        String bodyLoguearUsuario = CrearBodyLogin.conLaPlantilla(AutenticacionModels.LOGIN_USER).yLosValores(datos);
        OnStage.theActorInTheSpotlight().remember("bodyLoguearUsuario", bodyLoguearUsuario);
    }

    @Cuando("el analista envie los datos del usuario mediante el {string}")
    public void elAnalistaEnvieLosDatosDelUsuarioMedianteEl(String servicio) {
        String bodyLoguearUsuario = OnStage.theActorInTheSpotlight().recall("bodyLoguearUsuario");
        ConsumirApiLogin.tipoPOST(ApiEndpontLogin.obtenerEndpoint(servicio), bodyLoguearUsuario, analista);
    }
}
