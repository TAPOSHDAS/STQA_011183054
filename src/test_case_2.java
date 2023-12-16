import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_case_2 {
    public static void main(String[] args) {

//        System.out.printf("Hello and welcome!");


        //Launch or open the  chrome browser
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\88016\\Desktop\\cv\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
//        ChromeDriverService service = new ChromeDriverService.Builder().build();
//        WebDriver driver = new ChromeDriver(service);

        //launch webpage or navigate to the url
        driver.navigate().to("https://www.saucedemo.com/");

        //capture title of webpage
        String title=driver.getTitle();
        System.out.println("Page Title: "+title);

        //capture url of the webpage
        System.out.println("Url: "+driver.getCurrentUrl());

        //Capture page source
        System.out.println("Page Source: "+driver.getPageSource());

        //close the webpage
        driver.close();




    }
}
