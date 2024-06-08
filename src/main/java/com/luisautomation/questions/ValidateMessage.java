package com.luisautomation.questions;

import com.luisautomation.userinterfaces.OrderPaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class ValidateMessage {


    public static Question<String> thankYOu(){
        return actor -> OrderPaymentPage.LBL_THANK_YOU.resolveFor(actor).getText();
    }
}
