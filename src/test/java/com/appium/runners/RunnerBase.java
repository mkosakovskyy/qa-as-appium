
package com.appium.runners;

import com.appium.pages.MainPage;
import io.cucumber.java.BeforeAll;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.*;
import com.appium.manager.DriverManager;
import com.appium.manager.GlobalParams;
import com.appium.manager.ServerManager;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import java.io.IOException;

public class RunnerBase {
	private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

	public static TestNGCucumberRunner getRunner() {
		return testNGCucumberRunner.get();
	}

	private static void setRunner(TestNGCucumberRunner testNGCucumberRunner1) {
		testNGCucumberRunner.set(testNGCucumberRunner1);
	}

	@Parameters({ "platformName", "udid", "deviceName", "systemPort", "chromeDriverPort", "wdaLocalPort",
			"webkitDebugProxyPort" })
	@BeforeClass(alwaysRun = true)
	public void setUpClass(String platformName, String udid, String deviceName, @Optional("Android") String systemPort,
			@Optional("Android") String chromeDriverPort, @Optional("iOS") String wdaLocalPort,
			@Optional("iOS") String webkitDebugProxyPort) throws Exception {

		ThreadContext.put("ROUTINGKEY", platformName + "_" + deviceName);

		GlobalParams params = new GlobalParams();
		params.setPlatformName(platformName);
		params.setUDID(udid);
		params.setDeviceName(deviceName);

		switch (platformName) {
		case "Android":
			params.setSystemPort(systemPort);
			params.setChromeDriverPort(chromeDriverPort);
			break;
		case "iOS":
			params.setWdaLocalPort(wdaLocalPort);
			params.setWebkitDebugProxyPort(webkitDebugProxyPort);
			break;
		}

		new ServerManager().startServer();
		new DriverManager().initializeDriver();

		setRunner(new TestNGCucumberRunner(this.getClass()));
	}


	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
		getRunner().runScenario(pickle.getPickle());
	}

	@DataProvider
	public Object[][] scenarios() {
		return getRunner().provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		DriverManager driverManager = new DriverManager();
		if (driverManager.getDriver() != null) {
			driverManager.getDriver().quit();
			driverManager.setDriver(null);
		}
		ServerManager serverManager = new ServerManager();
		if (serverManager.getServer() != null) {
			serverManager.getServer().stop();
		}
		if (testNGCucumberRunner != null) {
			getRunner().finish();
		}

		/*Runtime runtime = Runtime.getRuntime();

		try {
			runtime.exec("cmd.exe /K C:/Users/rteresa/AppData/Local/Android/Sdk/platform-tools  adb -s emulator-5554 emu kill");
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}
}
