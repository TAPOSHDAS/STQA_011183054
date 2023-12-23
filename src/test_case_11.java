import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;

public class test_case_11{
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

        //Switch to product page
        String currentWindow=driver.getWindowHandle();
        driver.switchTo().window(currentWindow);

        WebElement element=driver.findElement(By.className("product_sort_container"));
        Select dropdown=new Select(element);


        dropdown.selectByValue("za");
        if(dropdown.isMultiple()){
            System.out.println("Dropdown is multiple");
        }else {
            System.out.println("Dropdown is not multiple");
        }
        List<WebElement> alldropdownoptios=dropdown.getOptions();
        for (WebElement el:alldropdownoptios){
            System.out.println(el.getText());
        }
    }
}
