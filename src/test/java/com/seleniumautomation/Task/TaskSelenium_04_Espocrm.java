package com.seleniumautomation.Task;

import com.seleniumautomation.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class TaskSelenium_04_Espocrm extends CommonToAll {
    @Test
    public void test_browserStackfileupload() {
        //Goto Espocrm
        driver.get("https://demo.us.espocrm.com/");

        waitForVisibility(driver,3000,"//button[@id='btn-login']");

        WebElement login = driver.findElement(By.id("btn-login"));
        login.click();

//        WebElement expandMenu = driver.findElement(By.xpath("//a[@class='minimizer']"));
//        expandMenu.click();
        waitForJVM(5000);

        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav navbar-nav tabs']/li"));

        for (WebElement items : menuItems){
            String menuText = items.getText();
            //System.out.println(menuText);

            if (menuText.contains("Leads")){
                items.click();
            }
        }
        waitForJVM(3000);
        WebElement createLead = driver.findElement(By.xpath("//a[@data-name='create']"));
        createLead.click();
        waitForJVM(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropdown = driver.findElement(By.xpath("//div[@class='col-sm-3 col-xs-3']//input[@type='text'][@autocomplete='new-password']"));
        dropdown.isDisplayed();
        dropdown.click();

        WebElement select = driver.findElement(By.xpath("//div[text()='Mr.']"));
        select.isDisplayed();
        select.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@data-name='firstName']"));
        firstName.sendKeys("Ramu");
        WebElement lastName = driver.findElement(By.xpath("//input[@data-name='lastName']"));
        lastName.sendKeys("Kumar");
        WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
        save.click();
        waitForJVM(3000);
        WebElement leadLink = driver.findElement(By.xpath("//a[text()='Leads']"));
        leadLink.click();
        waitForJVM(3000);
        WebElement searchBox= driver.findElement(By.xpath("//input[@data-name='textFilter']"));
        searchBox.sendKeys("Ramu Kumar"+ Keys.ENTER);
        WebElement searchTerm = driver.findElement(By.xpath("//div[@class='list-container']/div[3]/table/tbody/tr/td[2]"));
        String term = searchTerm.getText();
        Assert.assertEquals(term,"Ramu Kumar");



    }
}