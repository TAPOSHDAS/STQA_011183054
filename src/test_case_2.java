import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_case_2{

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\88016\\Desktop\\cv\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();


        driver.navigate().to("https://www.saucedemo.com/v1/");


        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user\n");


        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("secret_sauce");



        driver.findElement(By.cssSelector("input.btn_action")).click();

    }
}
