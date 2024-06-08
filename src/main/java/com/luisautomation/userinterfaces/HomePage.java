package com.luisautomation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {


    public static final Target BTN_USER = Target.the("Boton for login").locatedBy("//a[@id='menuUserLink']");

    public static final Target TXT_USERNAME = Target.the("Text username").locatedBy("//input[@name='username']");

    public static final Target TXT_PASSWORD = Target.the("Text password").locatedBy("//input[@name='password']");

    public static final Target BTN_SIGN_IN = Target.the("boton sign in").locatedBy("//button[@id='sign_in_btn']");

    public static final Target BTN_CATEGORY = Target.the("Boton selects for category").locatedBy("//span[contains(text(),'{0}')]");

    public static final Target LBL_PRODUCT_PRICE = Target.the("text of price the products").locatedBy("(//a[text()='{0}']//following::p//a)[1]");

    public static final Target BTN_PRODUCT = Target.the("Boton selects for products").locatedBy("//a[text()='{0}']");

    public static final Target BTN_ADD_TO_CART = Target.the("Boton add to cart").locatedBy("//button[@name='save_to_cart']");

    public static final Target BTN_HOME = Target.the("boton home page").locatedBy("//a[@translate='HOME']");

    public static final Target LBL_ORDER_NUBER = Target.the("label order number dinamic").locatedBy("//span[text()='{0}']");






}
