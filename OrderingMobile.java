package week7.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderingMobile {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev140572.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("P-qQ7@umSYz8");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("Service catalog");
		driver.findElement(By.xpath("(//div[text()='Service Catalog'])[1]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("Mobiles")).click();
		driver.findElement(By.xpath("//td[text()='iPhone 6s']")).click();
		WebElement findElement = driver.findElement(By.xpath("//select[contains(@class,'form-control cat_item_option ')]"));
		Select colour = new Select(findElement);
		colour.selectByIndex(3);
		WebElement findElement2 = driver.findElement(By.xpath("(//select[contains(@class,'form-control cat_item_option ')])[2]"));
		Select ram=new Select(findElement2);
		ram.selectByIndex(2);
		//driver.switchTo().frame(1);
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		WebElement print = driver.findElement(By.id("requesturl"));
		String text = print.getText();
		System.out.println("Request Number:"+text);
		WebElement print1 = driver.findElement(By.xpath("(//dl[@class='dl-horizontal sc-dl-horizontal'])//dd"));
		String text2 = print1.getText();
		System.out.println("Order Placed:"+text2);
	}

}
