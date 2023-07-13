package test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Objects {
	WebDriver driver;
	
	public void openWeb() {
		driver = new ChromeDriver();
	}
	
	public void getUrl(String url) {
		driver.get(url);
	}
	
	public void setTime(int timing) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timing));
	}
	
	public void click(String press) {
		driver.findElement(By.id(press)).click();
	}
	
	public void clickXpath(String press) {
		driver.findElement(By.xpath(press)).click();
	}
	
	public void clear() {
		driver.findElement(By.id("BtnClear")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBe(By.id("input"), ""));
	}
	
	public String getResult() {
		return driver.findElement(By.id("input")).getAttribute("value");
	}
	
	public String getExercise() {
		return driver.findElement(By.id("result")).getAttribute("title");
	}
	
	public String getRightLine(String option){
		return driver.findElement(By.cssSelector("li:nth-child("+option+") > p")).getText();
	}
	
	public String getLeftLine(String option) {
		return driver.findElement(By.cssSelector("li:nth-child("+option+") > p.l")).getText();
	}
	
	public void plusAction(WebDriver driver, String str1, String str2) {
		driver.findElement(By.id(str1)).click();
		driver.findElement(By.id("BtnPlus")).click();
		driver.findElement(By.id(str2)).click();
		driver.findElement(By.id("BtnCalc")).click();
		int num1 = Integer.parseInt(driver.findElement(By.id(str1)).getText());
		int num2 = Integer.parseInt(driver.findElement(By.id(str2)).getText());
		int sum = num1 + num2;
		String sumAsString = String.valueOf(sum);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeToBe(By.id("input"), "value",sumAsString));
	}
	
	public void minusAction(WebDriver driver, String num1, String num2,String ans, boolean parenR) {
		driver.findElement(By.id(num1)).click();
			driver.findElement(By.id("BtnMinus")).click();
		driver.findElement(By.id(num2)).click();
		if(parenR == true) {
			driver.findElement(By.id("BtnParanR")).click();
		}
		else {
			driver.findElement(By.id("BtnCalc")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.attributeToBe(By.id("input"), "value", ans));
		}
		
	}
	
	
	
	public void multification(WebDriver driver, String num1, String num2,String ans) {
		if(num1!=null) {
			driver.findElement(By.id(num1)).click();
		}
		driver.findElement(By.id("BtnMult")).click();
		driver.findElement(By.id(num2)).click();
		driver.findElement(By.id("BtnCalc")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeToBe(By.id("input"), "value", ans));
	}
	
	public void sinus(WebDriver driver, String num1, String num2,String ans) {
		driver.findElement(By.id("BtnSin")).click();
		driver.findElement(By.id(num1)).click();
		driver.findElement(By.id(num2)).click();
		driver.findElement(By.id("BtnParanR")).click();
		driver.findElement(By.id("BtnCalc")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeToBe(By.id("input"), "value", ans));
	}
	
	public void closeWeb() {
		driver.quit();
	}
}
