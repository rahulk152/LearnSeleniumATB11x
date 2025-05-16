package com.seleniumautomation.ex_02_Selenium_Basics;

import org.openqa.selenium.edge.EdgeDriver;

public class TestSelenium13_NOHTTP {

    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();
//        driver.get("bing.com"); // HTTPs is important.
        driver.get("https://bing.com"); // HTTPs is important.

        driver.quit();

    }
}
