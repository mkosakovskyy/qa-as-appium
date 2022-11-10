
package com.appium.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = { "pretty", "html:target_TestNG/iPhone_13/cucumber-report.html", "summary"
		// "de.monochromata.cucumber.report.PrettyReports:target/Pixel_3/cucumber-html-reports"}
		, "me.jvt.cucumber.report.PrettyReports:target_TestNG/iPhone_13/" }, features = {
				"src/test/resources/features" }, glue = {
						"com.appium.stepDefinitions" }, dryRun = false, monochrome = true
// ,strict=true
		, tags = "@login-feature")
public class TestNGRunner_iPhone13 extends RunnerBase {
}