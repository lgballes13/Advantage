package com.luisautomation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target BTN_CATEGORY = Target.the("Boton selects for category").locatedBy("//span[contains(text(),'{0}')]");

    public static final Target LBL_PRODUCT_PRICE = Target.the("text of price the products").locatedBy("(//a[text()='{0}']//following::p//a)[1]");

    public static final Target BTN_PRODUCT = Target.the("Boton selects for products").locatedBy("//a[text()='{0}']");

    public static final Target BTN_ADD_TO_CART = Target.the("Boton add to cart").locatedBy("//button[@name='save_to_cart']");

    public static final Target BTN_HOME = Target.the("boton home page").locatedBy("//a[@translate='HOME']");






}
