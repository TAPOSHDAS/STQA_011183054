import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_case_3 {
    public static void main(String[] args) {

        //launch chrome browser
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\88016\\Desktop\\cv\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //open swag lab web page
        driver.navigate().to("https://www.saucedemo.com/v1/");

        //locate user name --tag#id
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("locked_out_user\n\n");

        //locate password -tag[attribute=value]
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("secret_sauce");

        //locate login  tag.value_of_class_name

        driver.findElement(By.cssSelector("input.btn_action")).click();


    }
}






