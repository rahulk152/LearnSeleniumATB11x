package com.seleniumautomation.ex_13_Relative_locators;

import com.seleniumautomation.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Lab42_RL_P2 extends CommonToAll {
    @Test
    public void test_js() {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.switchTo().frame("result");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        WebElement username_element = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement error_element = driver.findElement((with(By.tagName("small")).below(username_element)));
        String error_text = error_element.getText();
        Assert.assertEquals(error_text,"Email is not invalid");

    }
}
