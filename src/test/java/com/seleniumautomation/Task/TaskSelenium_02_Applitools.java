package com.seleniumautomation.Task;

import com.seleniumautomation.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskSelenium_02_Applitools extends CommonToAll {
    @Test
    public void test_browserStackfileupload() {

        driver.get("https://demo.applitools.com/");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password@123");

        WebElement sign = driver.findElement(By.id("log-in"));
        sign.click();

        String first_part = "//table[@class='table table-padded']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        int row = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr[1]/td")).size();

        double amount;
        double total = 0.0;
//        System.out.println(row);
//        System.out.println(col);
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (j==5){
                    String dyanmic_path = first_part + i + second_part + j + third_part;
                    // System.out.println(dyanmic_path);
                    String amountText = driver.findElement(By.xpath(dyanmic_path)).getText();
                    amountText = amountText.replace(" ","").replace(",", "")
                            .replace("$", "").replace("USD","").trim();
                    // System.out.println(amountText);
                    amount=Double.parseDouble(amountText);
                    total += amount;


                }

            }
        }
        System.out.println(total);
        Assert.assertEquals(total,1996.22,"Assertion verified");



    }
}
