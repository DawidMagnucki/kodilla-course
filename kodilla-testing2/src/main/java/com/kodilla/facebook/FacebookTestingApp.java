package com.kodilla.facebook;

import com.kodilla.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    private static final String XPATH_COOKIES_ACCEPT_MAIN = "//*[@id=\"facebook\"]/body/div[4]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div/span/span";
    public static final String XPATH_CREATE_ACCOUNT = "//*[@id=\"login_form\"]/div/div[1]/div/div[5]/div/a/div/div[1]/div/span/span";
    public static final String XPATH_COOKIES_ACCEPT_REGISTRATION = "//*[@id=\"facebook\"]/body/div[4]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div/span/span";
    public static final String XPATH_SUBMIT_BUTTON = ".//div[@role='button' and contains(., 'Prześlij')]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/?locale=en_US");

        WebElement acceptCookies1 = driver.findElement(By.xpath(XPATH_COOKIES_ACCEPT_MAIN));
        acceptCookies1.click();

        WebElement createAccount = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT));
        createAccount.click();

        WebElement acceptCookies2 = driver.findElement(By.xpath(XPATH_COOKIES_ACCEPT_REGISTRATION));
        acceptCookies2.click();

        WebElement insertFirstName = driver.findElement(By.xpath(".//*[@id=\"_r_6_\"]"));
        insertFirstName.sendKeys("John");

        WebElement insertLastName = driver.findElement(By.xpath(".//*[@id=\"_r_9_\"]"));
        insertLastName.sendKeys("Smith");

        WebElement insertDobDay = driver.findElement(By.xpath(".//*[@id=\"_r_d_\"]"));
        insertDobDay.sendKeys("20", Keys.ENTER);

        WebElement insertDobMonth = driver.findElement(By.xpath(".//*[@id=\"_r_j_\"]"));
        insertDobMonth.sendKeys("marca", Keys.ENTER);

        WebElement insertDobYear = driver.findElement(By.xpath(".//*[@id=\"_r_p_\"]"));
        insertDobYear.sendKeys("1990", Keys.ENTER);

        WebElement chooseGender = driver.findElement(By.xpath(".//*[@id=\"_r_v_\"]"));
        chooseGender.sendKeys("Mężczyzna", Keys.ENTER);

        WebElement insertPhone = driver.findElement(By.xpath(".//*[@id=\"_r_14_\"]"));
        insertPhone.sendKeys("+48852654753", Keys.ENTER);

        WebElement insertPassword = driver.findElement(By.xpath(".//*[@id=\"_r_17_\"]"));
        insertPassword.sendKeys("Test1234", Keys.ENTER);

        WebElement submitButton = driver.findElement(By.xpath(XPATH_SUBMIT_BUTTON));
        submitButton.click();

    }
}
