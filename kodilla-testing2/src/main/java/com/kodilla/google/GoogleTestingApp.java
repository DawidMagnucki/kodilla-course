package com.kodilla.google;

import com.kodilla.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "q";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//*[@id='L2AGLb']/div")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(SEARCHFIELD)));
        searchField.sendKeys("Kodilla");
        searchField.submit();
    }
}
