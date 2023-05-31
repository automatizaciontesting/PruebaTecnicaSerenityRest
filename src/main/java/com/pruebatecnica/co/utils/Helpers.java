package com.pruebatecnica.co.utils;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Helpers {
    public List<WebElementFacade> getWebElementsFilters(Target lblAmountColumn, String symbol, Actor actor) {
        ListOfWebElementFacades nuevaLista = new ListOfWebElementFacades(new ArrayList<>());
        ListOfWebElementFacades elementos = lblAmountColumn.resolveAllFor(actor);
        for (int i = 0; i <= elementos.size()-1;i++) {
            if (elementos.get(i).containsText(symbol)) {
                nuevaLista.add(elementos.get(i));
            }
        }
        return nuevaLista;
    }
}
