package com.luisautomation.tasks;

import com.luisautomation.userinterfaces.HomePage;
import com.luisautomation.userinterfaces.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Login implements Task {

    private String userName;
    private String userPassword;

    public Login (){
        Properties prop = new Properties();
        try {
            FileInputStream file = new FileInputStream("config_users.properties");
            prop.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.userName = prop.getProperty("user.name");
        this.userPassword = prop.getProperty("user.password");
    }

    public static Login inAdvantage(){
        return Tasks.instrumented(Login.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(ShoppingCartPage.BTN_CHECKOUT),Click.on(HomePage.BTN_USER),
                Enter.theValue(userName).into(HomePage.TXT_USERNAME),
                Enter.theValue(userPassword).into(HomePage.TXT_PASSWORD),
                Click.on(HomePage.BTN_SIGN_IN));

    }
}
