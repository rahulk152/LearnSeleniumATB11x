package com.seleniumautomation.Task;

import com.seleniumautomation.CommonToAll;
import org.assertj.core.api.AssertJProxySetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskSelenium_01_Katalon_Site extends CommonToAll {
    @Test
    public void test_browserStackfileupload() {

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement humburgerMenu = driver.findElement(By.id("menu-toggle"));
        humburgerMenu.click();

        WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
        login.click();

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("ThisIsNotAPassword").build().perform();

        WebElement loginCTA = driver.findElement(By.id("btn-login"));
        loginCTA.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement appointmentLabel = driver.findElement(By.xpath("//h2[text()='Make Appointment']"));
        String expectedText = "Make Appointment";
        String actualText = appointmentLabel.getText();

        Assert.assertEquals(actualText, expectedText, "Appointment label text matches");

        WebElement dropdown = driver.findElement(By.id("combo_facility"));
        dropdown.click();

        WebElement facilityDropdown = driver.findElement(By.xpath("//select[@id='combo_facility']/option[@value='Hongkong CURA Healthcare Center']"));
        facilityDropdown.click();

        WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
        checkbox.click();
        WebElement radio = driver.findElement(By.id("radio_program_medicaid"));
        radio.click();
        WebElement visit_date = driver.findElement(By.id("txt_visit_date"));
        visit_date.sendKeys("21/05/2025");
        WebElement comment = driver.findElement(By.id("txt_comment"));
        comment.sendKeys("take the medical aid");
        WebElement bookAppointmentCTA = driver.findElement(By.id("btn-book-appointment"));
        bookAppointmentCTA.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement confirmation = driver.findElement(By.xpath("//h2[text()='Appointment Confirmation']"));

        String expectedText1 = "Appointment Confirmation";
        String actualText1 = confirmation.getText();

        Assert.assertEquals(actualText1, expectedText1, "Appointment confrimation label text matches");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement humburgerMenu1 = driver.findElement(By.id("menu-toggle"));
        humburgerMenu1.click();


        WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
        logout.click();

    }
}
