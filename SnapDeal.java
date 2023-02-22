package week7.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class SnapDeal {
public static void main(String[] args) throws IOException {
				
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.snapdeal.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
	driver.findElement(By.className("catText")).click();
				
	List<WebElement> Sportshoes = driver.findElements(By.className("linkTest"));
	int size = Sportshoes.size();
	System.out.println("Sportshoes count= "+size);
				
	driver.findElement(By.className("linkTest")).click();
	driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	
	List<WebElement> shoes = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
			    
	List<Integer> amt = new ArrayList<Integer>();
	for(int i=0;i<shoes.size();i++) 
	{
	String text = shoes.get(i).getText();
				  
	String replaceAll = text.replaceAll("[^0-9]","");
	System.out.println("replaceAll= "+replaceAll);
				     
	int parse = Integer.parseInt(replaceAll);
				     
	amt.add(parse);
	}
				
	Collections.sort(amt);
				
	Integer min= amt.get(0);
	System.out.println("The lowest price = "+min);
	
	Integer max = amt.get(amt.size()-1);
	System.out.println("The Highest price = "+max);
				
	WebElement range1 = driver.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
	range1.clear();
	range1.sendKeys("900");
				
	WebElement range2 = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
	range2.clear();
	range2.sendKeys("1200");
				
	driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn ')]")).click();
	
	WebElement element = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
	Actions actions = new Actions(driver);
	actions.moveToElement(element).build().perform();
					
	driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])/div")).click();
				
	WebElement cost = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
	String cost1 = cost.getText();
	System.out.println("Price of the Shoe= "+cost1);
				
	WebElement discount = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
	String offer = discount.getText();
	System.out.println("Shoe Offer= "+offer);
				
	File picture = driver.getScreenshotAs(OutputType.FILE);
				
	File fs = new File("./snap/img.png");
	
	//driver.close();
	driver.quit();
	}

}
