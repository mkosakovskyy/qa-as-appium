

package com.appium.pages;

import com.appium.utils.TestUtils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BottomMenuPage extends BasePage {
    TestUtils utils = new TestUtils();
    private AppiumDriver<?> driver;

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/main__go_to_home")
    private MobileElement homeSection;

    public BottomMenuPage() {
    }

    public void clickHomeSection(){
        homeSection.click();
    }
    public MobileElement getHomeSection(){
        return homeSection;
    }


}
