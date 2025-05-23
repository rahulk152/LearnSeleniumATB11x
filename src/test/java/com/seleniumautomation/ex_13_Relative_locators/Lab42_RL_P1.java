package com.seleniumautomation.ex_13_Relative_locators;

import com.seleniumautomation.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Lab42_RL_P1 extends CommonToAll {
    @Test
    public void test_js() {
        driver.get("https://awesomeqa.com/practice.html");
        WebElement span_element = driver.findElement(By.xpath("//span[text()=\"Years of Experience\"]"));
        driver.findElement((with(By.id("exp-2")).toRightOf(span_element))).click();
    }
}
