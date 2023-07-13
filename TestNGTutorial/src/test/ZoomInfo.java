package test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
public class ZoomInfo extends Objects{
	@BeforeTest()
	public void beforeTest(){
		openWeb();
		setTime(10);
		getUrl("https://web2.0calc.com/");
		clickXpath("//button[contains(text(),'Consent')]");
	}

	@Test(priority=1)
	public void Plus(){
		plusAction(driver, "Btn2", "Btn3");
		Assert.assertEquals(getExercise() + "=" + getResult(), "2+3=5");
		//Answer is 5
	}
	
	@Test(priority=2)
	public void Minus(){
		clear();
		click("Btn1");
		minusAction(driver,"Btn0", "Btn2", "8", false);
		Assert.assertEquals(getExercise() + "=" + getResult(), "10-2=8");
		//Answer is 8
	}
	@Test(priority=3)
	public void notEqual() {
		clear();
		click("BtnParanL");
		click("Btn1");
		minusAction(driver,"Btn0", "Btn2", "8", true);
		multification(driver,null, "Btn2", "16");
		Assert.assertNotEquals(getExercise() + "=" + getResult(), "20");
	}
	@Test(priority=4)
	public void sin() {
		clear();
		sinus(driver, "Btn3", "Btn0", "0.5");
		Assert.assertEquals(getExercise() + "=" + getResult(), "sin(30)=0.5");
	}
	
	@Test(priority=5)
	public void historyCheckStepFour() {
		click("hist");
		Assert.assertEquals(getLeftLine("1")+getRightLine("1"), "sin(30)= 0.5");
	}
	
	@Test(priority=6)
	public void historyCheckStepThree() {
		Assert.assertEquals(getLeftLine("2")+getRightLine("2"), "(10-2)*2= 16");
	}
	
	@Test(priority=7)
	public void historyCheckStepTwo() {
		Assert.assertEquals(getLeftLine("3")+getRightLine("3"), "10-2= 8");
	}
	
	@Test(priority=8)
	public void historyCheckStepOne() {
		Assert.assertEquals(getLeftLine("4")+getRightLine("4"), "2+3= 5");
	}
	@AfterTest
	public void afterTest() {
		closeWeb();
	}

}
