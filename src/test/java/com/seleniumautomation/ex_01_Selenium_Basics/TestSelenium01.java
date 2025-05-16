package com.seleniumautomation.ex_01_Selenium_Basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {

    @Test
    public void test_openVWOLoginPage() {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://app.vwo.com");
        System.out.println(chromeDriver.getTitle());


    }

}
