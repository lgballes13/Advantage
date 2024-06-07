package com.luisautomation.questions;

import com.luisautomation.userinterfaces.ShoppingCartPage;
import com.luisautomation.utils.Log;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidatePurchase implements Question<Boolean> {


    public static ValidatePurchase total (){
        return new ValidatePurchase();
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        String totalPriceActual = ShoppingCartPage.LBL_TOTAL_PURCHASE.resolveFor(actor).getText();
        totalPriceActual = totalPriceActual.replace("$", "").replace(",","").trim();

        double doublePriceActual = Double.parseDouble(totalPriceActual);
        Log.printInfo("Total price actual: " + doublePriceActual);

        if(actor.recall("totalPrice").equals((doublePriceActual))){
            Log.printInfo("the price expected: " + actor.recall("totalPrice") + " "+ "is equal to a the price actual: " + totalPriceActual + " ");
            return true;
        } else {
            Log.printError("the price expected: " + actor.recall("totalPrice") + "is not equal to a the price actual: " + totalPriceActual);
            return false;
        }

    }
}
