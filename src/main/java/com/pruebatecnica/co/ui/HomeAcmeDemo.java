package com.pruebatecnica.co.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeAcmeDemo {
    public static final Target TBL_TRANSACTIONS = Target.the("Recent Transactions").located(By.xpath("//*[@id='transactionsTable']/tbody/tr"));
    public static final Target LBL_TOTAL_BALANCE = Target.the("Total balance").located(By.className("balance-value"));
    public static final Target LBL_CREDIT_AVALIBLE = Target.the("Credit Avalible").located(By.xpath("//*[@id='creditAvailable']/div[@class='balance-value']"));
    public static final Target LBL_AMOUNT_COLUMN = Target.the("Amount column").locatedBy("//*[@id='transactionsTable']/tbody//td[contains(@class,'text-right')]/span");

    public static final Target TBL_STATUS_COLUM = Target.the("Status column").locatedBy("//*[@id='transactionsTable']/tbody//td/span[contains(@class,'status-pill')]/following-sibling::span");
    public static final Target TBL_COLOR_STATUS_COLUM = Target.the("Color status column").locatedBy("//*[@id='transactionsTable']/tbody//td/span[contains(@class,'status-pill')]/following-sibling::span");
}
