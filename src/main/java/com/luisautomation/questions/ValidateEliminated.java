package com.luisautomation.questions;

import com.luisautomation.userinterfaces.ShoppingCartPage;
import com.luisautomation.utils.Log;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateEliminated implements Question<Boolean> {


    public static ValidateEliminated ofCart(){
        return new ValidateEliminated();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String totalPriceNew = ShoppingCartPage.LBL_TOTAL_PURCHASE.resolveFor(actor).getText();
        totalPriceNew = totalPriceNew.replace("$", "").replace(",","").trim();
        double doublePriceExpectedNew = Double.parseDouble(totalPriceNew);

        Log.printInfo("Total price expected in the page: " + doublePriceExpectedNew);

        if(actor.recall("totalPriceActual").equals((doublePriceExpectedNew))){
            Log.printInfo("the price actual: " + actor.recall("totalPriceActual") + " "+ "is equal to a the price expected: " + doublePriceExpectedNew + " ");
            return true;
        } else {
            Log.printError("the price actual: " + actor.recall("totalPriceActual") + "is not equal to a the price expected: " + doublePriceExpectedNew);
            return false;
        }
    }
}
