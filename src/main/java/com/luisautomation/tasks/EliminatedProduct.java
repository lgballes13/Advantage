package com.luisautomation.tasks;

import com.luisautomation.userinterfaces.ShoppingCartPage;
import com.luisautomation.utils.Log;
import com.luisautomation.utils.RandomNumber;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Map;

public class EliminatedProduct implements Task {



    public static EliminatedProduct ofCart(){
        return Tasks.instrumented(EliminatedProduct.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        double totalPriceInitial = actor.recall("totalPrice");

        Log.printWarning("the total price before of removed the product: "+" "+totalPriceInitial);

        int randomNumber = RandomNumber.getRandomNumber(1, AddProducts.sizeProduct);
        String randomNumberString = String.valueOf(randomNumber);


        String priceProductRemove = ShoppingCartPage.LBL_PRICE_TO_REMOVE.of(randomNumberString).resolveFor(actor).getText();
        priceProductRemove = priceProductRemove.replace("$", "").trim();
        double doublePriceproductRemove = Double.parseDouble(priceProductRemove);

        String formatdoublePriceproductRemove = String.format("%.2f",doublePriceproductRemove);

        Log.printWarning("the price of product removed is: "+" " + doublePriceproductRemove);

        double totalPriceActual = totalPriceInitial - doublePriceproductRemove;
        actor.remember("totalPriceActual", totalPriceActual);

        Log.printWarning("the new price of total purchase actual is: "+" " + totalPriceActual);

        actor.attemptsTo(Click.on(ShoppingCartPage.LBL_REMOVE_PRODUCT.of(randomNumberString)));


    }
}
