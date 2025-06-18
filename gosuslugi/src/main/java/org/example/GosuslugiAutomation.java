package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class GosuslugiAutomation {
    private WebDriver driver;
    private WebDriverWait wait;

    public GosuslugiAutomation() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void login(String phone, String password) {
        driver.get("https://gosuslugi.ru");

        // Кнопка входа
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Войти')]"))).click();

        // Ввод телефона
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("mobileOrEmail"))).sendKeys(phone);

        // Кнопка "Продолжить"
        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();

        // Ввод пароля (может потребоваться ввод кода из SMS)
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("password"))).sendKeys(password);

            // Кнопка "Войти"
            driver.findElement(By.xpath("//button[contains(text(),'Войти')]")).click();

            // Ожидание завершения входа
            wait.until(ExpectedConditions.urlContains("lk.gosuslugi.ru"));
        } catch (TimeoutException e) {
            System.out.println("Требуется ввод кода из SMS или CAPTCHA");
            // Здесь нужно вручную ввести код или решить CAPTCHA
        }
    }

    public void fillServiceForm(Map<String, String> formData) {
        // Навигация к нужной услуге
        // Пример для паспорта - измените под вашу услугу
        driver.get("https://www.gosuslugi.ru/10050/1");

        // Заполнение полей формы
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            try {
                WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='" + entry.getKey() + "']")));
                field.clear();
                field.sendKeys(entry.getValue());
            } catch (Exception e) {
                System.out.println("Не удалось найти поле: " + entry.getKey());
            }
        }

        // Отправка формы
        try {
            driver.findElement(By.xpath("//button[contains(text(),'Подать заявление')]")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        driver.quit();
    }
}