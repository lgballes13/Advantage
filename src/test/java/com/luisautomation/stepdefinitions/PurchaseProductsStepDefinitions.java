package com.luisautomation.stepdefinitions;

import com.luisautomation.questions.ValidateEliminated;
import com.luisautomation.questions.ValidateMessage;
import com.luisautomation.questions.ValidatePurchase;
import com.luisautomation.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.CoreMatchers;

import java.util.List;
import java.util.Map;

public class PurchaseProductsStepDefinitions {

    @Before
    public void before(){
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^the customer is on the homepage$")
    public void theCustomerIsOnTheHomepage() {
        OnStage.theActorCalled("luis").wasAbleTo(Open.url("https://advantageonlineshopping.com/#/"));
    }


    @When("^the customer selects the following products and adds them to the cart$")
    public void theCustomerSelectsTheFollowingProductsAndAddsThemToTheCart(List<Map<String, String>> products) {
        OnStage.theActorInTheSpotlight().attemptsTo(AddProducts.toCart(products));
    }

    @When("^the customer navigates to the shopping cart$")
    public void theCustomerNavigatesToTheShoppingCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(NavigateShopping.toCart());
    }

    @Then("^it is validated that the total purchase is equal to the sum of the selected products' prices$")
    public void itIsValidatedThatTheTotalPurchaseIsEqualToTheSumOfTheSelectedProductsPrices() {
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidatePurchase.total()));
    }


    @When("^remove products from cart$")
    public void removeProductsFromCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(RemoveProducts.ofList());
    }


    //@eliminated_product

    @When("^the customer eliminated a product what he was dont want buy$")
    public void theCustomerEliminatedAProductWhatHeWasDontWantBuy() {
        OnStage.theActorInTheSpotlight().attemptsTo(EliminatedProduct.ofCart());
    }


    @Then("^validate the new price total purchase$")
    public void validateTheNewPriceTotalPurchase() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateEliminated.ofCart()));
    }

    //@buy

    @When("^Enter the credentials for login$")
    public void enterTheCredentialsForLogin() {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.inAdvantage());
    }


    @When("^input the information for payment method$")
    public void inputTheInformationForPaymentMethod() {
        OnStage.theActorInTheSpotlight().attemptsTo(OrderPayment.advantage());
    }

    @Then("^visualize the message \"([^\"]*)\"$")
    public void visualizeTheMessage(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("validate message", ValidateMessage.thankYOu(), CoreMatchers.equalTo(message)));
    }






}
