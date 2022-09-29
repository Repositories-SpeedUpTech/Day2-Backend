package com.certification.reqres.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature",
        glue = {"com.certification.reqres.stepdefinition"},
        snippets = SnippetType.CAMELCASE)
public class AllUserRunners {
}
