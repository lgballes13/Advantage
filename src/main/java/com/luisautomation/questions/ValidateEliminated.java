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
        double doublePriceActualNew = Double.parseDouble(totalPriceNew);

        Log.printInfo("Total price actual in the page: " + doublePriceActualNew);

        if(actor.recall("totalPriceExpected").equals((doublePriceActualNew))){
            Log.printInfo("the price expected: " + actor.recall("totalPriceExpected") + " "+ "is equal to a the price actual: " + doublePriceActualNew + " ");
            return true;
        } else {
            Log.printError("the price expected: " + actor.recall("totalPriceExpected") + "is not equal to a the price actual: " + doublePriceActualNew);
            return false;
        }
    }
}
