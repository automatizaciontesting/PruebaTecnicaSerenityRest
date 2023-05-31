package com.pruebatecnica.co.stepsdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class PeticionesStepsDefinition {
    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    private Actor hervin;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in/api");
        hervin = Actor.named("Hervin automation test").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
    @Given("que como {string} realizo una solicitud GET")
    public void queComoRealizoUnaSolicitudGET(String actor) {
        hervin.attemptsTo(
                Get.resource("/users/1")
        );
    }
    @Then("valido el status code {int}")
    public void validoElStatusCode(Integer statusCode) {

        hervin.should(
                seeThatResponse(response -> response.statusCode(statusCode)
                        .body("updatedAt", not(isEmptyString())))
        );

    }
    @Then("valido el contenidos")
    public void validoElContenido() {
        hervin.should(
                seeThatResponse( "User details should be correct",
                        response -> response
                                .body("data.first_name", equalTo("George"))
                                .body("data.last_name", equalTo("Bluth"))
                )
        );
    }
    @Given("que realizo una solicitud POST")
    public void queRealizoUnaSolicitudPOST() {

        hervin.attemptsTo(
                Post.to("/users")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"firstName\": \"jack\",\"lastName\": \"smith\"}")
                        )
        );
    }
    @Given("que realizo una solicitud PUT")
    public void queRealizoUnaSolicitudPUT() {
        hervin.attemptsTo(
                Put.to("/userss/2")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"firstName\": \"jack\",\"lastName\": \"smith\"}")
                        )
        );
    }
    @Given("que realizo una solicitud Delete")
    public void queRealizoUnaSolicitudDelete() {
        hervin.attemptsTo(
                Delete.from("/users/1")
        );
    }
    @Then("valido el status code {int} del delete")
    public void validoElStatusCodeDelDelete(Integer statusCode) {

        hervin.should(
                seeThatResponse(response -> response.statusCode(statusCode))
        );
    }

    @Given("creo un usuario con nombre {string} y trabajo {string}")
    public void creoUnUsuarioConNombreYTrabajo(String name, String job) {
        hervin.attemptsTo(
                Post.to("/users")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"name\": \""+name+"\",\"job\": \""+job+"\"}")
                        )
        );
        hervin.should(
                seeThatResponse(
                        response -> Serenity.setSessionVariable("idApi").
                                to(response.extract().jsonPath().getString("id"))
                )
        );
    }
    @Then("valido el codigo generado")
    public void validoElCodigoGenerado() {
        hervin.attemptsTo(
                Get.resource("/users/"+Serenity.sessionVariableCalled("idApi"))
        );
        hervin.should(
                seeThatResponse( "User details should be correct",
                        response -> response
                                .body("data.id", equalTo(Integer.parseInt(Serenity.sessionVariableCalled("idApi"))))
                                .statusCode(200)
                )
        );
    }
}
