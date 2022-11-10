
package com.appium.pages;

import com.appium.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class TopMenuPage extends BasePage {
    TestUtils utils = new TestUtils();
    private AppiumDriver<?> driver;

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/iv_news_image")
    private MobileElement mainNews;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'bol')]")
    private MobileElement topMenuFootballSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Motor')]")
    private MobileElement topMenuMotorSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'LaLiga Santander')]")
    private MobileElement topMenuLeagueSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'rmula 1')]")
    private MobileElement topMenuMotorCategorySection;


    public TopMenuPage() {
    }

    public void clickTopMenuFootballSection() {
        topMenuFootballSection.click();
    }

    public boolean mainNewsDisplayed() {
        return mainNews.isDisplayed();
    }

    public MobileElement getTopSectionSport(String sport) {
        if(sport.equals("Futbol")){
            return topMenuFootballSection;
        }else if(sport.equals("Motor")){
            return topMenuMotorSection;
        }
        return topMenuLeagueSection;
    }

    public MobileElement getTopSectionCategory(String category) {
        if(category.equals("LaLiga Santander")){
            return topMenuLeagueSection;
        }else if(category.equals("Formula 1")){
            return topMenuMotorCategorySection;
        }
        return topMenuLeagueSection;
    }

}
