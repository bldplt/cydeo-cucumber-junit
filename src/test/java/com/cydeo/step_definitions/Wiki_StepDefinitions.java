package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.Driver;
import com.cydeo.pages.*;
import com.cydeo.utilities.*;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.Keys;

import java.util.List;

public class Wiki_StepDefinitions {

    WikiSearchPage wikiSearchPage ;

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        wikiSearchPage = new WikiSearchPage();
        Driver.getDriver().get("https://www.wikipedia.org");
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        BrowserUtils.sleep(2);
        wikiSearchPage.searchBox.sendKeys(string);

    }


    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        BrowserUtils.sleep(2);
        wikiSearchPage.searchButton.click();

    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        //verify actual title contains string (coming from feature file)
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));

    }

    @Then("User sees {string} is in the main header")
    public void userSeesSteveJobsIsInTheMainHeader(String string) {

        Assert.assertTrue(wikiSearchPage.mainHeader.isDisplayed());

        Assert.assertTrue(wikiSearchPage.mainHeader.getText().equals(string));
        //3.06 pm cst

    }
}