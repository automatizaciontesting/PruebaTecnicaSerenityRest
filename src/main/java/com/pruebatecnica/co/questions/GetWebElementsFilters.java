package com.pruebatecnica.co.questions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.List;

public class GetWebElementsFilters implements Question<List<WebElementFacade>> {
    Target lblAmountColumn;
    String symbol;
    static ListOfWebElementFacades  nuevaLista;
    public GetWebElementsFilters(Target lblAmountColumn, String symbol) {
        this.lblAmountColumn=lblAmountColumn;
        this.symbol=symbol;
    }

    public static GetWebElementsFilters returnValues(Target lblAmountColumn, String s) {
        return new GetWebElementsFilters(lblAmountColumn,s);
    }

    @Override
    public List<WebElementFacade> answeredBy(Actor actor) {
        ListOfWebElementFacades nuevaLista = new ListOfWebElementFacades(new ArrayList<>());
        ListOfWebElementFacades elementos = lblAmountColumn.resolveAllFor(actor);
        for (int i = 0; i <= elementos.size()-1;i++) {
            if (elementos.get(i).containsText(symbol)) {
                System.out.println(elementos.get(i).getText());
                nuevaLista.add(elementos.get(i));
            }
        }
        return nuevaLista;
    }


}
