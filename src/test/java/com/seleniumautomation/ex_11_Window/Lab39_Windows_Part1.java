package com.seleniumautomation.ex_11_Window;

import com.seleniumautomation.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class Lab39_Windows_Part1 extends CommonToAll {

    @Test
    public void test_window() {

        driver.get("https://the-internet.herokuapp.com/windows");

        String parent = driver.getWindowHandle();
        System.out.println(parent);

        WebElement link_parent = driver.findElement(By.xpath("//a[text()=\"Click Here\"]"));
        link_parent.click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        for (String handle: windowHandles){
            driver.switchTo().window(handle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Case Passed!");
            }
            driver.switchTo().window(parent);
        }
    }
}
