package com.example.appiumtestdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class TestDemo2 {
    public AndroidDriver<AndroidElement> driver1, driver2;

    public AndroidDriver<AndroidElement> createAndroidDriver (String deviceName,
                                                           String appPackage,
                                                           String appActivity,
                                                           String appiumHost)throws MalformedURLException{
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", deviceName);
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", appPackage);
        dc.setCapability("appActivity", appActivity);
        // It will launch Dialer app in android emulator-device.
        return new AndroidDriver<AndroidElement>(new URL(appiumHost),dc);

    }

    @Before
    public void setUp() throws MalformedURLException {

        driver1 = createAndroidDriver("emulator-5556",//deviceName
                "com.google.android.dialer",//appPackage
                "extensions.GoogleDialtactsActivity",//appActivity
                "http://127.0.0.1:4725/wd/hub");//appiumHost
        //try{Thread.sleep(5000);}catch(InterruptedException e){System.out.println(e);}

        driver2 = createAndroidDriver("emulator-5554",
                "com.android.dialer",
                "com.android.dialer.main.impl.MainActivity",
                "http://127.0.0.1:4723/wd/hub");//appiumHost second
        try{Thread.sleep(5000);}catch(InterruptedException e){System.out.println(e);}
    }


    @Test
    public void login() {//com.google.android.dialer:id/icon

        driver1.findElementById("com.google.android.dialer:id/empty_list_view_action").click();
        driver2.findElementById("com.android.dialer:id/main_options_menu_button").click();
        try{Thread.sleep(10000);}catch(InterruptedException e){System.out.println(e);}

    }

    @After
    public void End() {
        driver1.quit();
        driver2.quit();

    }
}
