package com.example.appiumtestdemo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class TestDemo {
    AndroidDriver<AndroidElement> driver1;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc1 = new DesiredCapabilities();
        dc1.setCapability("deviceName", "Your device name");
        dc1.setCapability("platformName", "Android");
        dc1.setCapability("systemPort", "8200");
        dc1.setCapability("appPackage", "com.android.dialer");
        dc1.setCapability("appActivity", "com.android.dialer.main.impl.MainActivity");
        // It will launch Dialer app in android emulator-device.

        driver1 = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc1);
        try{Thread.sleep(6000);}catch(InterruptedException e){System.out.println(e);}

    }


    //public void hfnLogin(AndroidDriver<AndroidElement>)

    @Test
    public void login() {

        driver1.findElementById("com.android.dialer:id/main_options_menu_button").click();
        try{Thread.sleep(10000);}catch(InterruptedException e){System.out.println(e);}

    }

    @After
    public void End() {
        driver1.quit();

    }
}
