package com.luisautomation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ShoppingCartPage {


    public static final Target BTN_SHOPPING_CART = Target.the("Boton shopping cart link").locatedBy("//a[@id='shoppingCartLink']");

    public static final Target LBL_TOTAL_PURCHASE = Target.the("text of total purchase").locatedBy("(//span[text()='TOTAL:']//following::span)[1]");

    public static final Target LBL_REMOVE_PRODUCT = Target.the("remove a product").locatedBy("(//a[text()='REMOVE'])[{0}]");

    public static final Target LBL_PRICE_TO_REMOVE = Target.the("price of product a eliminated").locatedBy("(//a[text()='REMOVE'])[{0}]//ancestor::td//p");

}
