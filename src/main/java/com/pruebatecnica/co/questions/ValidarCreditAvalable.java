package com.pruebatecnica.co.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.pruebatecnica.co.ui.HomeAcmeDemo.LBL_CREDIT_AVALIBLE;

public class ValidarCreditAvalable implements Question<String> {
    public static ValidarCreditAvalable inLabel() {
        return new ValidarCreditAvalable();
    }
    @Override
    public String answeredBy(Actor actor) {
        return  LBL_CREDIT_AVALIBLE.resolveFor(actor).getText()
                .replace("$","")
                .replace(",",".");
    }
}
