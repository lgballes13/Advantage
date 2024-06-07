package com.luisautomation.tasks;

import com.luisautomation.userinterfaces.HomePage;
import com.luisautomation.utils.Log;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class AddProducts implements Task {


    private List<Map<String, String>> products;

    public static int sizeProduct;



    public AddProducts (List<Map<String, String>> products){
        this.products = products;
        sizeProduct = products.size();
    }

    public static AddProducts toCart(List<Map<String, String>> products){
        return Tasks.instrumented(AddProducts.class, products);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        double totalPrice = 0.0;

        for(int i=0; i<products.size(); i++){

            actor.attemptsTo(Click.on(HomePage.BTN_CATEGORY.of(products.get(i).get("category"))));

            String price = HomePage.LBL_PRODUCT_PRICE.of(products.get(i).get("product")).resolveFor(actor).getText();
            price = price.replace("$", "").replace(",","").trim();
            double doublePrice = Double.parseDouble(price);
            totalPrice += doublePrice;

            actor.remember("totalPrice", totalPrice);

            actor.attemptsTo( Click.on(HomePage.BTN_PRODUCT.of(products.get(i).get("product"))),
                    Click.on(HomePage.BTN_ADD_TO_CART),
                    Click.on(HomePage.BTN_HOME));
        }
        Log.printWarning("Total Price Expected: " + totalPrice);

    }

}
