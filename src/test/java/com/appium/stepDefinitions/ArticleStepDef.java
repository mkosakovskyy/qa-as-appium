package com.appium.stepDefinitions;

import com.appium.pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

public class ArticleStepDef {

    MainPage mainPage = new MainPage();
    ArticlePage articlePage = new ArticlePage();
    BasePage basePage = new BasePage();

    @Before("@firstarticle")
    public void openAppFirstTime() {
        mainPage.openAppFirstTime();
        mainPage.goToURL("https://argentina.as.com/futbol/la-argentina-de-messi-se-rompe-n/");

    }

    @Given("The user access the article")
    public void theUserAccessTheArticle() {
        System.out.println("User already in the news");
    }

    @Then("The sticky add is displayed in the article")
    public void theStickyAddIsDisplayedArticle() {
        articlePage.waitForVisibility(articlePage.getStickyAdContainer());
        Assert.assertTrue(articlePage.getStickyAdContainer().isDisplayed());
    }

    @Then("The  MPU add is displayed")
    public void theMPUAddIsDisplayed() throws InterruptedException {
        basePage.swipe(1030,1315,1040,350,2000,1);
        Assert.assertTrue(articlePage.geMpuAdContainer().isDisplayed());
    }

    @Then("The BTN add is displayed")
    public void theBTNAddIsDisplayed() {
        Assert.assertTrue(articlePage.getBtnAdContainer().isDisplayed());
    }

    @Then("The second MPU add is displayed")
    public void theSecondMPUAddIsDisplayed() throws InterruptedException {
        basePage.swipe(1030,1315,1040,350,2000,1);
        Assert.assertTrue(mainPage.getMPUAdContainer().isDisplayed());

    }



}
