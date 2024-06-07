package com.luisautomation.tasks;


import com.luisautomation.userinterfaces.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class NavigateShopping implements Task {


    public static NavigateShopping toCart (){
        return Tasks.instrumented(NavigateShopping.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ShoppingCartPage.BTN_SHOPPING_CART));
    }
}
