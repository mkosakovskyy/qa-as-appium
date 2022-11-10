
package com.appium.pages;

import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;


public class MainPage extends BasePage {

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/button_agree")
    private MobileElement acceptCookiesButton;

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/showcase__label__button_skip")
    private MobileElement skipTutorialButton;

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/iv_news_image")
    private MobileElement mainNewsImage;

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/share")
    private MobileElement shareButton;

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/ads__label__ad")
    private MobileElement adContainer;

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/ads__robapaginas")
    private MobileElement mpuAdContainer;

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/ad_sticky_container")
    private MobileElement stickyAdContainer;

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/btnAccept")
    private MobileElement acceptButton;

    public MainPage() {
    }

    public void clickAcceptCookiesButton() {
        acceptCookiesButton.click();
    }

    public void clickSkipTutorialButton() {
        skipTutorialButton.click();
    }

    public void clickShareButton() {
        shareButton.click();
    }

    public MobileElement getAcceptCookiesButton() {
        return acceptCookiesButton;
    }

    public MobileElement getSkipTutorialButton() {
        return skipTutorialButton;
    }

    public void clickAcceptButton(){
        acceptButton.click();
    }

    public MobileElement getMainNewsImage() {
        return mainNewsImage;
    }

    public MobileElement getShareButton() {
        return shareButton;
    }

    public MobileElement getAdContainer() {
        return adContainer;
    }

    public MobileElement getStickyAdContainer() {
        return stickyAdContainer;
    }


    public MobileElement getMPUAdContainer() {
        return mpuAdContainer;
    }

    public void openAppFirstTime(){
        try {
            clickAcceptButton();
            waitForVisibility(getAcceptCookiesButton());
            clickAcceptCookiesButton();
            waitForVisibility(getSkipTutorialButton());
            clickSkipTutorialButton();
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            System.out.println("App already opened");
        }
    }


}
