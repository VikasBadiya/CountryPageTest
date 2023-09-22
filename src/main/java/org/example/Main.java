package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void switchWindowByUrl(String url, WebDriver driver) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().equals(url)) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        try{
           WebDriverManager.chromedriver().setup();

            WebDriver driver = new ChromeDriver();

            driver.get("https://qacountrypage.ccbp.tech/");

            WebElement findPopulationButton = driver.findElement(By.id("findPopulationBtn"));
            findPopulationButton.click();

            WebElement answerQuestionBtn = driver.findElement(By.id("answerQuestionBtn"));
            answerQuestionBtn.click();

            switchWindowByUrl("https://qasearchpage.ccbp.tech/", driver);
            WebElement searchInputField = driver.findElement(By.id("searchInput"));
            searchInputField.sendKeys("Italy");

            WebElement populationText = driver.findElement(By.className("country-population"));
            System.out.println(populationText.getText());

            switchWindowByUrl("https://qaquestion.ccbp.tech/", driver);
            WebElement questionText = driver.findElement(By.className("question"));
            System.out.println(questionText.getText());

            WebElement delhiRadioButton = driver.findElement(By.id("cityDelhi"));
            delhiRadioButton.click();

            WebElement submitButton = driver.findElement(By.id("submitBtn"));
            submitButton.click();

            WebElement resultText = driver.findElement(By.id("resultMsg"));
            System.out.println(resultText.getText());

            driver.quit();

        }catch(Exception e){
        System.out.println("Error Message of "+ e);
    }


    }
}