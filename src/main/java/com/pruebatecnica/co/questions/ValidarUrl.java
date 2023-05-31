package com.pruebatecnica.co.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarUrl implements Question<Boolean> {
    public static ValidarUrl DeLaPaginaActual() {
        return new ValidarUrl();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Serenity.getDriver().getCurrentUrl().contains(
                "https://demo.applitools.com/hackathonAppV2.html");
    }
}
