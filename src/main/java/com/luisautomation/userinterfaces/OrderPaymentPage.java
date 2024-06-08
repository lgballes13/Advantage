package com.luisautomation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class OrderPaymentPage {

    public static final Target BTN_NEXT = Target.the("boton next").locatedBy("//button[@id='next_btn']");

    public static final Target TXT_USERNAME_SAFEPAY = Target.the("Text username safepay").locatedBy("//input[@name='safepay_username']");

    public static final Target TXT_PASSWORD_SAFEPAY = Target.the("Text password safepay").locatedBy("//input[@name='safepay_password']");

    public static final Target BTN_PAY_NOW = Target.the("boton pay now").locatedBy("//button[@id='pay_now_btn_SAFEPAY']");

    public static final Target LBL_ORDER_ID = Target.the("label orderid").locatedBy("//label[@id='orderNumberLabel']");

    public static final Target SEL_MY_ORDERS = Target.the("option my orders of userMenu").locatedBy("(//div[@style='display: block;']//label[@translate='My_Orders'])[1]");

    public static final Target LBL_THANK_YOU = Target.the("label thank you").locatedBy("//span[text()='Thank you for buying with Advantage']");


}
