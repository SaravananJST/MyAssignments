package week7.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceProposal {

public static void main(String[] args) {
	
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://dev140572.service-now.com\r\n");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.switchTo().frame(0);
	driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("P-qQ7@umSYz8");
	driver.findElement(By.id("sysverb_login")).click();
	driver.switchTo().defaultContent();
	driver.findElement(By.id("filter")).sendKeys("proposal");
	driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame(0);
	driver.findElement(By.id("sysverb_new")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame(0);
	WebElement findElement = driver.findElement(By.id("std_change_proposal.short_description"));
	findElement.sendKeys("SARAVANAN V M");
	driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
	}

}
