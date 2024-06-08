package com.luisautomation.tasks;

import com.luisautomation.userinterfaces.HomePage;
import com.luisautomation.userinterfaces.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RemoveProducts implements Task {

    public static RemoveProducts ofList(){
        return Tasks.instrumented(RemoveProducts.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        for(int i=1; i<AddProducts.sizeProduct+1; i++){
            actor.attemptsTo(Click.on(ShoppingCartPage.LBL_REMOVE_PRODUCT.of(String.valueOf(1))));
        }

    }
}
