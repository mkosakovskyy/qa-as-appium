/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Appium Mobile Automation - Android & iOS + Frameworks + CICD (https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package com.appium.stepDefinitions;

import java.io.*;

import com.appium.pages.BasePage;
import com.appium.manager.VideoManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.BeforeSuite;

public class Hooks {
    BasePage basePage = new BasePage();

    @Before
    public void initialize() throws Exception {
        new VideoManager().startRecording();
    }



    @After
    public void quit(Scenario scenario) throws IOException {
        basePage.screenshot(scenario);
        new VideoManager().stopRecording(scenario.getName());
    }
}
