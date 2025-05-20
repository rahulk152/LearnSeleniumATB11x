package com.seleniumautomation.ex_07_ShadowDOM;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium34_ShadowDOM {
    @Description("Verify  shadow dom")
    @Test
    public void shadowDomElement() throws InterruptedException {

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--start-maximized");


        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://selectorshub.com/xpath-practice-page/");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement div_to_scroll = driver.findElement(By.xpath("//div[@id ='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);",div_to_scroll);
        Thread.sleep(5000);

        WebElement inputbox =(WebElement)js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\");");
        inputbox.sendKeys("framehouse");

    }
}
