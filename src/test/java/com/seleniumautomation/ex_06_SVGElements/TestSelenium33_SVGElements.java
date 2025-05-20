package com.seleniumautomation.ex_06_SVGElements;

import com.seleniumautomation.CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium33_SVGElements extends CommonToAll {
    @Description("Verify  flipkart search with svg search icon")
    @Test
    public void svgElement() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.navigate().to("https://www.flipkart.com/");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("macmini");
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));
        svgElements.get(0).click();
        List<WebElement> titleResult = driver.findElements(By.xpath("(//a[@class='wjcEIp'])"));
        for (WebElement title : titleResult){
            System.out.println(title.getText());
        }




    }
}
