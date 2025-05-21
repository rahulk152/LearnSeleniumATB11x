package com.seleniumautomation.ex_09_File_Upload;

import com.seleniumautomation.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Lab38_BrowserStack_FileUpload extends CommonToAll {
    @Test
    public void test_browserStackfileupload() {

        driver.get("https://www.browserstack.com/users/sign_in");

        WebElement email = driver.findElement(By.id("user_email_login"));
        email.sendKeys("rahul.kumar1@wundermanthompson.com");
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("Welcome@rah");
        WebElement signIn = driver.findElement(By.id("user_submit"));
        signIn.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // waitForVisibility(driver,5,"//form[@id='upload_form']");
        //WebElement uploadApp = driver.findElement(By.id("//form[@id='upload_form']"));
       // uploadApp.click();
//        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));
//
//        String working_dir = System.getProperty("user.dir");
//        // /Users/promode/IdeaProjects/LearnSeleniumATB11x
//
//
//        String path_file = working_dir+"/src/test/java/com/seleniumautomation/Data.txt";
//
//        uploadFileInput.sendKeys(path_file);
//        driver.findElement(By.name("submit")).click();
    }
}
