package com.seleniumautomation.ex_04_Selenium_XPATH;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium26_MiniProject_6 {
    @Description("Open the URL")
    @Test
    public void testdynamicWebTable1() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement username_xath = driver.findElement(By.xpath("//input[@name = 'username']"));
        username_xath.sendKeys("admin");

        WebElement password_xpath = driver.findElement((By.xpath("//input[@name = 'password']")));
        password_xpath.sendKeys("Hacker@4321");

        WebElement submit_xpath = driver.findElement((By.xpath("//button[normalize-space()='Login']")));
        submit_xpath.click();

        Thread.sleep(2000);

        WebElement employeelist_xpath = driver.findElement((By.xpath("//a[text()='Employee List']")));
        employeelist_xpath.click();

        Thread.sleep(2000);

        //WebElement table = driver.findElement(By.xpath("//div[@role ='table']/div[@class='oxd-table-body']"));
//       JavascriptExecutor js = (JavascriptExecutor) driver;
//       js.executeScript("arguments[100].scrollIntoView(true);", table);


        //first part -//div[@role ='table']/div[@class='oxd-table-body']/div[@class='oxd-table-card'][
        //i
        // ]//div[@role='cell'][
        //j
        // ]

        String first_part = "//div[@role ='table']/div[@class='oxd-table-body']/div[@class='oxd-table-card'][";
        String second_part = "]//div[@role='cell'][";
        String third_part = "]";

        int row = driver.findElements((By.className("oxd-table-card"))).size();
        int col = driver.findElements((By.xpath("//div[@role='cell']"))).size();

        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                String dyanmic_path = first_part+i+second_part+j+third_part;
                System.out.println(dyanmic_path);
                String data = driver.findElement(By.xpath(dyanmic_path)).getText();
               // System.out.println(data);
                if (data.contains("Terminated")){
                    String emp_status = dyanmic_path+"/following-sibling::td";
//                    String country_text  = driver.findElement(By.xpath(country_path)).getText();
//                    System.out.println("--------------");
//                    System.out.println("Helen Bennett is In "+country_text);

                }

            }

        }


//        List<WebElement> row = findElements(By.className("oxd-table-card"));
//        for (int i = 0; i < row.size(); i++) {
//            List<WebElement> col = row.get(i).findElements(By.xpath("//div[@role='cell']"));
//            for (WebElement c: col) {
//
//                System.out.println(c.getText());
//
//
//            }
//        }



    }
}
