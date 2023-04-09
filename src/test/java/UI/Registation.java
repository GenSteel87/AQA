package UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Registation {

    @Test
    public void testFirst() throws InterruptedException {
        User user = new User(" ", "123456Test_1" );
        WebDriver driver = new FirefoxDriver();

        driver.get("https://pipedream.com");

        WebElement signUpButton1 = driver.findElement(By.xpath("//a[text() = 'Sign Up Free!']"));
        signUpButton1.click();
        Thread.sleep(3000);

        WebElement emailField = driver.findElement(By.xpath("//input [@placeholder = 'name@company.com']"));
        ((WebElement) emailField).sendKeys(user.getEmail());
        Thread.sleep(3000);

        WebElement passwordField = driver.findElement(By.xpath("//input [@type = 'password']"));
        passwordField.click();
        ((WebElement) passwordField).sendKeys(user.getPassword());

        WebElement signUpButton2 = driver.findElement(By.xpath("//button[@data-pd-t = 'sign up with password']"));
        signUpButton2.click();
        Thread.sleep(3000);

        WebElement checkMessage = driver.findElement(By.xpath("//h2[text() = 'Create a Workspace']"));
        String value = checkMessage.getText();
        assertEquals("Create a Workspace", value);

        //далее нужно написать степы для удаления этого аккаунта через юай, что бы тест всё время можно было пройти

        driver.quit();
    }

}
