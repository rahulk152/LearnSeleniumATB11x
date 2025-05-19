package com.seleniumautomation.ex_04_Selenium_XPATH;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium24_StaticWebTable {

    @Description("Open the URL")
    @Test
    public void testStaticWebTable() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();
        //Thread.sleep(5000);
        String first_part = "//table[@id ='customer']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        int row = driver.findElements(By.xpath("//table[@id ='customer']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id ='customer']/tbody/tr[2]/td")).size();

        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= col ; j++) {
                String dyanmic_path = first_part+i+second_part+j+third_part;
                System.out.println(dyanmic_path);
                String data = driver.findElement(By.xpath(dyanmic_path)).getText();
                System.out.println(data);
                if (data.contains("Helen Bennett")){
                    String country_path = dyanmic_path+"/following-sibling::td";
                    String country_text  = driver.findElement(By.xpath(country_path)).getText();
                    System.out.println("--------------");
                    System.out.println("Helen Bennett is In "+country_text);

                }

            }

        }

        //driver.quit();
    }

}
