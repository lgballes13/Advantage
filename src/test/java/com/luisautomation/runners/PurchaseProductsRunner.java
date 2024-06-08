package com.luisautomation.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/purchase_of_products.feature", glue = "com.luisautomation", snippets = SnippetType.CAMELCASE)
public class PurchaseProductsRunner {
}
