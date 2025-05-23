package com.seleniumautomation.ex_13_Relative_locators;

import com.seleniumautomation.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Lab43_RL_P3_REAL_EXAMPLE extends CommonToAll {

    @Test
    public void test_Aqi_index() {
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        waitForVisibility(driver,5000,"//input[@placeholder='Search']");

        // Scroll down by 300 pixels vertically
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);");

        WebElement serach = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        serach.sendKeys("India"+ Keys.ENTER);

        waitForJVM(5000);
        // Scroll down by 300 pixels vertically

        List<WebElement> locations = driver.findElements(By.xpath("//div[contains(@class,\"location-name\")]/p"));

        List<Integer> rankList = new ArrayList<>();

        for (WebElement location : locations){
            String rankText = driver.findElement(with(By.tagName("p")).toLeftOf(location)).getText();

            // Remove "+" and "." to get the numeric part
            String cleanRank = rankText.replace("+", "").replace(".", "").trim();

            // Convert to integer and add to list
            int rank = Integer.parseInt(cleanRank);
            rankList.add(rank);

            String aqi = driver.findElement(with(By.tagName("span")).toRightOf(location)).getText();

            System.out.println("| +" + rankText + " | " + location.getText() + " | " + aqi + " | ");

        }

        // Find and print the smallest rank
        int minRank = Collections.min(rankList);
        System.out.println("Smallest Rank: " + minRank);

        // Find and print the smallest rank
        int maxRank = Collections.max(rankList);
        System.out.println("Largest Rank: " + maxRank);

//        int minRank = Integer.MAX_VALUE; // Start with a very large number
//
//        for (int rank : rankList) {
//            if (rank < minRank) {
//                minRank = rank;
//            }
//        }


    }
}
