package com.seleniumautomation.ex_09_SVGElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium34_AdvanceSVGElements {
    @Description("Verify  armchart to zoom in state when clicked on svg")
    @Test
    public void svgElement() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.navigate().to("https://www.amcharts.com/svg-maps/?map=india");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        // States - //*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']
        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for(WebElement state: states){
            System.out.println(state.getAttribute("aria-label"));
            if (state.getAttribute("aria-label").contains("Tripura")){
                state.click();
            }
        }
    }
}
