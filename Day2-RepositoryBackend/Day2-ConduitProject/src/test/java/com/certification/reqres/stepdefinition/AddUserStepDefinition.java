package com.certification.reqres.stepdefinition;

import com.certification.reqres.endpoitns.ApiEndpoints;
import com.certification.reqres.endpoitns.ConsumirApi;
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
import org.junit.Test;

import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.IsEqual.equalTo;


public class AddUserStepDefinition {

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

    @Dado("que el analista envia una peticion con los siguientes datos:")
    public void queElAnalistaEnviaUnaPeticionConLosSiguientesDatos(List<Map<String, String>> datos) {
        String bodyAgregarUsuario = CrearBody.conLaPlantilla(AutenticacionModels.CREATE_USER).yLosValores(datos);
        OnStage.theActorInTheSpotlight().remember("bodyAgregarUsuario", bodyAgregarUsuario);
    }

    @Cuando("el analista agregue los datos del usuario mediante el '(.*)'")
    public void elAnalistaAgregueLosDatosDelUsuarioMedianteEl(String servicio) {
        String bodyCrearUsuario = OnStage.theActorInTheSpotlight().recall("bodyAgregarUsuario");
        ConsumirApi.tipoPOST(ApiEndpoints.obtenerEndpoint(servicio), bodyCrearUsuario, analista);
    }

    @Entonces("deberia ver como respuesta un codigo {int}")
    public void deberiaVerComoRespuestaUnCodigo(int codigo) {
        analista.should(
                seeThatResponse("El usuario se agregó correctamente",
                        response -> response.statusCode(codigo))
        );

    }


}
