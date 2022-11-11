package com.appium.stepDefinitions;

import com.appium.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

public class FrontPageStepDef {

    MainPage mainPage = new MainPage();
    TopMenuPage topMenuPage = new TopMenuPage();
    BottomMenuPage bottomMenuPage = new BottomMenuPage();
    BasePage basePage = new BasePage();



    @Step("The user access the front page")
    @Given("The user access the front page")
    public void theUserAccessTheFrontPage() {
        try {
            bottomMenuPage.waitForVisibility(bottomMenuPage.getHomeSection());
            bottomMenuPage.clickHomeSection();
        }catch(NoSuchElementException | TimeoutException | StaleElementReferenceException  e) {
            System.out.println("No se encontro el boton");
        }
    }

    @Step("The inter add is displayed")
    @Then("The inter add is displayed")
    public void theInterAddIsDisplayed() {
        boolean isDisplayed = false;
        try {
            topMenuPage.waitForVisibility(topMenuPage.getTopSectionSport("Futbol"));
            topMenuPage.waitForVisibility(topMenuPage.getTopSectionSport("Motor"));
        }catch(NoSuchElementException | TimeoutException | StaleElementReferenceException  e) {
            isDisplayed = true;
        }
        Assert.assertTrue(isDisplayed);
    }

    @After("@inter")
    public void closeInter(){
        mainPage.tapCancelAdWaitForElement(topMenuPage.getTopSectionSport("Futbol"),1018,62);
        mainPage.tapCancelAdWaitForElement(topMenuPage.getTopSectionSport("Futbol"),200,1538);
    }

    @Step("The sticky add is displayed")
    @Then("The sticky add is displayed")
    public void theStickyAddIsDisplayed() {
        basePage.waitForVisibility(mainPage.getStickyAdContainer());
        Assert.assertTrue(mainPage.getStickyAdContainer().isDisplayed());
    }

    @Step("The first MPU add is displayed")
    @Then("The first MPU add is displayed")
    public void theFirstMPUAddIsDisplayed() throws InterruptedException {
        basePage.swipe(1030,1315,1040,350,2000,2);
        Assert.assertTrue(mainPage.getMPUAdContainer().isDisplayed());
    }
}
