package com.pruebatecnica.co.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.pruebatecnica.co.ui.HomeAcmeDemo.LBL_TOTAL_BALANCE;

public class ValidarTotal implements Question<Integer> {
    public static ValidarTotal deLaPagina() {
        return new ValidarTotal();
    }
    @Override
    public Integer answeredBy(Actor actor) {
        return Integer.parseInt(LBL_TOTAL_BALANCE.resolveFor(actor).getText().replaceAll("[$ %7]",""));
    }
}
