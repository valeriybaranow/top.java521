package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public class BrowserAutomation {
    private WebDriver driver;

    public BrowserAutomation() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        this.driver = new ChromeDriver();
    }

    public void fillForm(String url, Map<String, String> formData) {
        driver.get(url);

        for (Map.Entry<String, String> entry : formData.entrySet()) {
            driver.findElement(By.id(entry.getKey())).sendKeys(entry.getValue());
        }

        // Пример клика по кнопке отправки
        driver.findElement(By.id("submit-button")).click();
    }

    public void close() {
        driver.quit();
    }
}