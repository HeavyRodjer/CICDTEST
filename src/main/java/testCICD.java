import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class testCICD {
    @Test
    public void main() {

        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.youtube.com/");


        WebElement el3  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
        el3.sendKeys("QQ");

        WebElement el4  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='search-icon-legacy']" )));

        el4.click();
        WebElement test = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()= 'Поменял Кабана на китайскую малолитражку. Обзор Chery QQ']")));
        String test3 = test.getAttribute("innerHTML");
        Assert.assertEquals(test3,test);




    }
}
