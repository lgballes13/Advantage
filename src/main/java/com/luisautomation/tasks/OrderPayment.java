package com.luisautomation.tasks;

import com.luisautomation.interactions.Wait;
import com.luisautomation.userinterfaces.OrderPaymentPage;
import com.luisautomation.userinterfaces.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OrderPayment implements Task {


    private String userSafePay;
    private String passwordSafePay;

    public OrderPayment(){
        Properties prop = new Properties();
        try {
            FileInputStream file = new FileInputStream("config_users.properties");
            prop.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.userSafePay = prop.getProperty("user.safepay");
        this.passwordSafePay = prop.getProperty("password.safepay");
    }
    public static OrderPayment advantage(){
        return Tasks.instrumented(OrderPayment.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OrderPaymentPage.BTN_NEXT),
                Enter.theValue(userSafePay).into(OrderPaymentPage.TXT_USERNAME_SAFEPAY),
                Enter.theValue(passwordSafePay).into(OrderPaymentPage.TXT_PASSWORD_SAFEPAY),
                Click.on(OrderPaymentPage.BTN_PAY_NOW),
                WaitUntil.the(OrderPaymentPage.LBL_THANK_YOU, WebElementStateMatchers.isVisible()));
    }
}
