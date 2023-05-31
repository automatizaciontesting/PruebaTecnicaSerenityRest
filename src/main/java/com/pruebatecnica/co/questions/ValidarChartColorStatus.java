package com.pruebatecnica.co.questions;

import com.pruebatecnica.co.utils.Helpers;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.pruebatecnica.co.ui.HomeAcmeDemo.TBL_COLOR_STATUS_COLUM;
import static com.pruebatecnica.co.ui.HomeAcmeDemo.TBL_STATUS_COLUM;

public class ValidarChartColorStatus implements Question<Boolean> {
    String findStatus;
    String findColorLabel;
    public ValidarChartColorStatus(String status, String colorLabel){
        this.findStatus=status;
        this.findColorLabel=colorLabel;
    }
    public static ValidarChartColorStatus InTheColumn(String status, String colorLabel) {
        return new ValidarChartColorStatus(status,colorLabel);
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        Helpers helpers = new Helpers();
        List<WebElementFacade> elementos= helpers.getWebElementsFilters(TBL_STATUS_COLUM,findStatus,actor);
        Target nameStatusTransaction = Target.the("Status column").locatedBy("//*[@id='transactionsTable']/tbody//td/span[contains(@class,'status-pill') and contains(@class,'"+findColorLabel+"')]");
        return  elementos.size() == nameStatusTransaction.resolveAllFor(actor).size();

    }
}
