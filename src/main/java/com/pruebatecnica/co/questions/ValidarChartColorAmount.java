package com.pruebatecnica.co.questions;

import com.pruebatecnica.co.utils.Helpers;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static com.pruebatecnica.co.ui.HomeAcmeDemo.LBL_AMOUNT_COLUMN;

public class ValidarChartColorAmount implements Question<Boolean> {
    Boolean ValidateContent;
    String findChart;
    String findClassName;
    public ValidarChartColorAmount(String findChart, String findClassName){
        this.findChart=findChart;
        this.findClassName=findClassName;
    }
    public static ValidarChartColorAmount Amount(String findChart, String findClassName) {
        return new ValidarChartColorAmount(findChart,findClassName);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Helpers helpers = new Helpers();
        List<WebElementFacade> elementos= helpers.getWebElementsFilters(LBL_AMOUNT_COLUMN,findChart,actor);
        for(WebElementFacade element : elementos){
            if(element.getAttribute("class").contains(findClassName)){
                ValidateContent=true;
            }else{
                ValidateContent=false;
                break;
            }
        }
        return ValidateContent;
    }


}
