
package com.appium.manager;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.utils.TestUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {
	TestUtils utils = new TestUtils();

	public DesiredCapabilities getCaps() throws IOException {
		GlobalParams params = new GlobalParams();
		Properties props = new PropertyManager().getProps();

		try {
			utils.log().info("getting capabilities");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
			caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

			switch (params.getPlatformName()) {
			case "Android":
				caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
				caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
				caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
				caps.setCapability("systemPort", params.getSystemPort());
				caps.setCapability("avd", "test");
				caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
				caps.setCapability(AndroidMobileCapabilityType.AVD_READY_TIMEOUT, 140000);
				caps.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, 140000);
				caps.setCapability(AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT, 260);
				caps.setCapability(AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, 260);
				caps.setCapability(AndroidMobileCapabilityType.IS_HEADLESS, false);
				caps.setCapability(AndroidMobileCapabilityType.ADB_EXEC_TIMEOUT, 30000);
				String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "app" + File.separator + "AS.apk";
				utils.log().info("appUrl is " + androidAppUrl);
				caps.setCapability("app", androidAppUrl);
				break;
			case "iOS":
				caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
				String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "app" + File.separator + "SwagLabsMobileApp.app";
				utils.log().info("appUrl is" + iOSAppUrl);
				caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
				caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
				caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
				caps.setCapability("app", iOSAppUrl);
				break;
			}
			return caps;
		} catch (Exception e) {
			e.printStackTrace();
			utils.log().fatal("Failed to load capabilities. ABORT!! " + e.toString());
			throw e;
		}
	}
}
