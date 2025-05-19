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

public class TestSelenium22_MiniProject_4 {
    @Owner("Rahul Kumar")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the Login Xpath for Organ CRM with invalid credentials")
    @Test
    public void testOrangeCRM() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement username_xath = driver.findElement(By.xpath("//input[@name = 'username']"));
        username_xath.sendKeys("admin");

        WebElement password_xpath = driver.findElement((By.xpath("//input[@name = 'password']")));
        password_xpath.sendKeys("123456");

        WebElement submit_xpath = driver.findElement((By.xpath("//button[normalize-space()='Login']")));
        submit_xpath.click();

        Thread.sleep(1000);
        WebElement errormessage_xpath = driver.findElement(By.xpath("//p[text() ='Invalid credentials']"));
        String actualErrorMessage = errormessage_xpath.getText();

        Assert.assertEquals(actualErrorMessage,"Invalid credentials","Error message does not match!");

        driver.quit();

    }
}
