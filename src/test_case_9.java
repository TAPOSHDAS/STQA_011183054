import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class test_case_9 {
    public static void main(String[] args) {
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
        List<WebElement> LinkElements=driver.findElements(By.tagName("a"));
        System.out.println("Total links on webpage: "+LinkElements.size());

        for(WebElement el:LinkElements){
            System.out.println(el.getText());
        }
        driver.close();




    }
}
