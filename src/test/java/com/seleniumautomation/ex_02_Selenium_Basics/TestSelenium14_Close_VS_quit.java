package com.seleniumautomation.ex_02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium14_Close_VS_quit {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        //Thread.sleep(5000);
        //driver.close();

        // Close - will close the current tab, not the session (not the all tabs)
        // session id != null

        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null
    }
}
