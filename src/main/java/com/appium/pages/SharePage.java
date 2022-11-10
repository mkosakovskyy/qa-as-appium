

package com.appium.pages;

import com.appium.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;



public class SharePage extends BasePage {
    TestUtils utils = new TestUtils();
    private AppiumDriver<?> driver;

    @AndroidFindBy(id = "//android.widget.TextView[contains(@text, 'Facebook')]")
    private MobileElement facebookButton;

    @AndroidFindBy(id = "android:id/resolver_list")
    private MobileElement shareMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Copy to clipboard')]")
    private MobileElement copyToclipboard;


    public SharePage() {
    }

    public MobileElement getFacebookButton(){
        return facebookButton;
    }
    public MobileElement getShareMenu(){return shareMenu;}
    public MobileElement getCopyToclipboard(){return copyToclipboard;}
    public void clickFacebookButton(){facebookButton.click();}


}
