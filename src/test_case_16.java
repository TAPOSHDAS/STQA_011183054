import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_case_16{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\88016\\Desktop\\cv\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //open source demo website
        driver.navigate().to("https://www.saucedemo.com");
        driver.manage().window().maximize();

        //locate username by id
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //locate password by name
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //locate login button
        driver.findElement(By.className("btn_action")).click();

        Thread.sleep(3000);

        JavascriptExecutor js=(JavascriptExecutor)driver;
        //Scrool till visibility of web page
        WebElement element= driver.findElement(By.linkText("Sauce Labs Fleece Jacket"));
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
}
