

package com.appium.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target_TestNG/Pixel4API30/cucumber-report.html", "summary","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, features = {
		"src/test/resources/features/frontpage.feature"}, glue = {
		"com.appium.stepDefinitions" }, dryRun = false)
public class TestNGRunner_Pixel3 extends RunnerBase {
}