package com.pruebatecnica.co.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.pruebatecnica.co.ui.HomeAcmeDemo.TBL_TRANSACTIONS;

public class ValidarTransacciones implements Question<Integer> {

    public static ValidarTransacciones deLaPagina() {
        return new ValidarTransacciones();
    }
    @Override
    public Integer answeredBy(Actor actor) {
        return TBL_TRANSACTIONS.resolveAllFor(actor).size();
    }
}
