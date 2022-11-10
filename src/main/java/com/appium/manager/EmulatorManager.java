package com.appium.manager;

import com.appium.utils.TestUtils;

public class EmulatorManager {

    TestUtils utils = new TestUtils();

    public void initializeEmulator() throws Exception {
        Runtime runtime = Runtime.getRuntime();

        utils.log().info("starting emulator");

        try {
            runtime.exec("cmd.exe /K C:/Users/rteresa/AppData/Local/Android/Sdk/emulator/emulator -avd Pixel4API30 -no-snapshot-save");
            Thread.sleep(60000);
        } catch (Exception e) {
            e.printStackTrace();
            utils.log().fatal("Emulator initialization failure. ABORT !!!!  " + e.getMessage());
        }

        utils.log().info("Emulator is initialized");
    }
}
