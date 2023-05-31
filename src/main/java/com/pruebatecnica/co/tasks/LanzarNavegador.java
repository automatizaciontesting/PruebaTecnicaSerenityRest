package com.pruebatecnica.co.tasks;

import com.pruebatecnica.co.ui.LoginPageAcmeDemo;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class LanzarNavegador {
    public static Performable paraLaPrueba() {
        return Task.where(
                actor -> {
                    Open.browserOn().the(LoginPageAcmeDemo.class).performAs(actor);
                    Serenity.setSessionVariable("url").to(Serenity.getDriver().getCurrentUrl());
                }
        );
    }
}
