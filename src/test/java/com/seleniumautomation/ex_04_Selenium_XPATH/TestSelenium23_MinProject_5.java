package com.seleniumautomation.ex_04_Selenium_XPATH;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium23_MinProject_5 {
    @Owner("Rahul Kumar")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the forget Xpath for VWO with valid email")
    @Test
    public void testVwo() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://vwo.com/free-trial/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement bussinessEmail_xath = driver.findElement(By.xpath("//input[@data-qa='page-su-step1-v1-email']"));
        bussinessEmail_xath.sendKeys("admin@admin.com");

        WebElement checkbox_xpath = driver.findElement((By.xpath("//input[@id='page-free-trial-step1-cu-gdpr-consent-checkbox']")));
        checkbox_xpath.click();

        WebElement createFreeTrailAccount_xpath = driver.findElement(By.xpath("//button[contains(text(),'Create a Free Trial Account')]"));
        createFreeTrailAccount_xpath.click();

       driver.quit();
    }
}
