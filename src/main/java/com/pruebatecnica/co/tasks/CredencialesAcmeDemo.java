package com.pruebatecnica.co.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.pruebatecnica.co.ui.LoginPageAcmeDemo.*;

public class CredencialesAcmeDemo implements Task {
    private String usuario;
    private String contrasena;
    public CredencialesAcmeDemo(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(TXT_USER),
                Enter.theValue(contrasena).into(TXT_PASSWORD),
                Click.on(BTN_LOGIN)
        );
    }
}
