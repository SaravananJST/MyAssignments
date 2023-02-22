package week7.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Nykaa {
public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.nykaa.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Actions brands=new Actions(driver);
	
	WebElement element = driver.findElement(By.xpath("//a[text()='brands']"));
	brands.moveToElement(element).build().perform();
	
	driver.findElement(By.xpath("(//div[@class='css-ov2o3v']//a)[6]")).click();
	
	String title = driver.getTitle();
	System.out.println(title);
	
	driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
	driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
	
	driver.findElement(By.xpath("//span[text()='Category']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[text()='Hair']")).click();
	
	driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
	driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
	
	driver.findElement(By.xpath("//span[text()='Concern']")).click();
	driver.findElement(By.xpath("//span[text()='Color Protection']")).click();

	driver.findElement(By.xpath("//div[@class='css-43m2vm']")).click();
	
	Set<String>parentWindow=driver.getWindowHandles();
	
	List<String> window =new ArrayList<String>(parentWindow);
	driver.switchTo().window(window.get(1));

	WebElement size=driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
	Select select=new Select(size);
	select.selectByValue("2");
	
    WebElement amount=driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]"));
    String mrprice=amount.getText();
    String replaceamount= mrprice.replaceAll("[^0-9]", "");
	
    System.out.println("amount="+replaceamount);
	
	driver.findElement(By.xpath("(//button[@class=' css-1qvy369']//span)[1]")).click();
	
	driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
	
	driver.switchTo().frame(0);
	
	WebElement ra=driver.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']/span"));
	String rate=ra.getText();
	System.out.println(rate);
	
	String price1 = rate.replaceAll("[^0-9]", "");
	System.out.println(price1);
	
	driver.findElement(By.xpath("(//button[@class='css-guysem e8tshxd0'])[2]")).click();
	driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
	driver.findElement(By.xpath("//div[@class='css-gecnnw eqr1d9n12']")).click();
	driver.findElement(By.xpath("(//span[@class='css-1b232xc ehes2bo3'])[2]")).click();
	
	WebElement check3=driver.findElement(By.xpath("(//p[@class='css-masf0q eka6zu20'])[2]"));
	String rate2=check3.getText();
	System.out.println(rate2);
	
	String price2 = rate2.replaceAll("[^0-9]", "");
	System.out.println(price2);
	
	if (price1.equals(price2)) 
	{
		System.out.println(" the grand total is same in step 14");
	}
	else
	{
		System.out.println("It is not same");
	}
	driver.quit();
}
}
