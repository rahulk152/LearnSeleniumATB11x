package com.seleniumautomation.Task;

import com.seleniumautomation.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskSelenium_03_Ebay extends CommonToAll {
    @Test
    public void test_browserStackfileupload() {
        //Goto Ebay
        driver.get("https://www.ebay.com/");

        //Search Macmini Term and click on enter
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchTextBox.sendKeys("Macmini" + Keys.ENTER);

        //find all the prices of the serched macmini
        List<WebElement> priceElement = driver.findElements(By.xpath("//span[@class='s-item__price']"));

        List<Double> priceList = new ArrayList<>();
        for (WebElement price : priceElement) {
            String priceText = price.getText();

            if (!priceText.contains("to")) {
                // process price here
                String cleanPrice = priceText.replace("$", "").replace(",", "").trim();
                try {
                    Double listPrice = Double.parseDouble(cleanPrice);
                    priceList.add(listPrice);
                    // add name similarly...
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price format: " + priceText);
                }
            } else {
                // skip this price since it's a range or invalid
                continue;
            }
        }
        // Find and print the smallest price
        if (!priceList.isEmpty()) {
            Double minPrice = Collections.min(priceList);
            System.out.println("Smallest Price: " + minPrice);
        } else {
            System.out.println("No valid prices found.");
        }

    }
}
