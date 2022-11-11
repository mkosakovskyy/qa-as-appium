package com.appium.stepDefinitions;

import com.appium.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

public class ArticleStepDef {

    MainPage mainPage = new MainPage();
    ArticlePage articlePage = new ArticlePage();
    BasePage basePage = new BasePage();


    /*@Step("The  MPU add is displayed")
    @Then("The  MPU add is displayed")
    public void theMPUAddIsDisplayed() throws InterruptedException {
        basePage.swipe(1030,1315,1040,350,2000,1);
        Assert.assertTrue(articlePage.geMpuAdContainer().isDisplayed());
    }

    @Step("The BTN add is displayed")
    @Then("The BTN add is displayed")
    public void theBTNAddIsDisplayed() {
        Assert.assertTrue(articlePage.getBtnAdContainer().isDisplayed());
    }

    @Step("The second MPU add is displayed")
    @Then("The second MPU add is displayed")
    public void theSecondMPUAddIsDisplayed() throws InterruptedException {
        basePage.swipe(1030,1315,1040,350,2000,1);
        Assert.assertTrue(mainPage.getMPUAdContainer().isDisplayed());

    }*/

    @Step("El usuario accede al articulo")
    @When("El usuario accede al articulo {string}")
    public void elUsuarioAccedeAlArticulo(String url) {
        mainPage.openAppFirstTime();
        mainPage.goToURL(url);
    }

    @And("La aplicacion carga por completo")
    public void laAplicacionCargaPorCompleto() {
        articlePage.waitForVisibility(articlePage.getStickyAdContainer());
        Assert.assertTrue(articlePage.getStickyAdContainer().isDisplayed());
    }


    @Then("Aparece el elemento publicitario INTEXT con tamaño 1:1")
    public void apareceElElementoPublicitarioInText() {
    }

    @And("Aparece el elemento publicitario MLDB1")
    public void apareceElElementoPublicitarioMLDB() {
    }

    @And("Aparece el elemento publicitario MPU1 con su tamaño correspondiente")
    public void apareceElElementoPublicitarioMPU1() {
    }

    @And("Aparece el elemento publicitario MPU2 con su tamaño correspondiente")
    public void apareceElElementoPublicitarioMPU2() {
    }

    @And("Aparece el elemento publicitario MPU3 con su tamaño correspondiente")
    public void apareceElElementoPublicitarioMPU3() {
    }

    @And("Aparece el elemento publicitario BTN con su tamaño correspondiente")
    public void apareceElElementoPublicitarioBTNConTamañoXXPx() {
    }
}
