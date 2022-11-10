package com.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ArticlePage extends BasePage {

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/ads_container_detail")
    private MobileElement stickyAdContainer;

    @AndroidFindBy(id = "es.mmip.prisacom.as:id/ads__robapaginas")
    private MobileElement mpuAdContainer;

    @AndroidFindBy(id = "Saber más")
    private MobileElement btnAdContainer;


    public MobileElement getStickyAdContainer() {
        return stickyAdContainer;
    }

    public MobileElement geMpuAdContainer() {
        return mpuAdContainer;
    }

    public MobileElement getBtnAdContainer() {
        return btnAdContainer;
    }

}
