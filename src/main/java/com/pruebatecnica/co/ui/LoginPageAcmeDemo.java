package com.pruebatecnica.co.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPageAcmeDemo extends PageObject {
    public static final Target TXT_USER = Target.the("Usuario Acme demo").located(By.id("username"));
    public static final Target TXT_PASSWORD = Target.the("contrasena Acme demo").located(By.id("password"));
    public static final Target BTN_LOGIN= Target.the("Logueo Acme demo").located(By.id("log-in"));

}
