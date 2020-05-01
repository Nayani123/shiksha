package seleniumPractiseSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day13_studyabroad {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.Chrome.driver", "./drivers/Chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable Notifications");
		WebDriverWait wait=new WebDriverWait(driver,30);
		JavascriptExecutor  js=(JavascriptExecutor) driver;  //page scrolldown
        js.executeScript("window.scrollBy(0,1000)");
		driver.manage().window().maximize();
		
		//1.Go to https://studyabroad.shiksha.com/
		driver.get("https://studyabroad.shiksha.com/");
		
		//2.mouseover on colleges and click in computer science& engg under MS colleges
		Thread.sleep(2000);
		WebElement college = driver.findElementByXPath("(//label[@class='menuTab-div fnt-wt melabel'])[3]");
		Actions colge=new Actions(driver);
		colge.moveToElement(college).perform();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='MS in Computer Science &Engg']").click();
		
		
		//3.select GRE Under Exam Accepted and score 300 & below
		Thread.sleep(2000);
        driver.findElementByXPath("//p[text()='GRE']").click();
        Thread.sleep(2000);
        WebElement score = driver.findElementByXPath("(//select[@class='score-select-field'])[1]");
        Select examscore=new Select(score);
		examscore.selectByValue("GRE--284--4");
		/*List<WebElement> options = examscore.getOptions();
		int size = options.size();
		System.out.println(size);
		for (WebElement webE : options) {
			System.out.println(webE.getText());
			
			
		}*/
		
		//4.Max 10 lakhs under 1st yr total fees,USA under countries
		Thread.sleep(2000);
		driver.findElementByXPath("//p[text()='Max 10 Lakhs']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='USA']/ancestor::label/span").click();
		
		
		//5.select sort by:low to high  1st yr total fees
		Thread.sleep(2000);
		WebElement sort = driver.findElementById("categorySorter");
		Select totalfee=new Select(sort);
		totalfee.selectByVisibleText("Low to high 1st year total fees");
		
		//6.click add to compare of the college having least fees with public university, scholarship and Accomadation facilities
       Thread.sleep(2000);
		List<WebElement> collegesList = driver.findElementsByXPath("//div[@class='tuple-box']");
		
     for (int i = 1; i <=collegesList.size() ; i++) {
    	 
			String university = driver.findElementByXPath("(//div[@class='detail-col flLt']/p[text()='Public university']/span)[" + i + "]").getAttribute("class");
			String scholarship = driver.findElementByXPath("(//div[@class='detail-col flLt']/p[text()='Scholarship']/span)[" + i + "]").getAttribute("class");
			String accomodation = driver.findElementByXPath("(//div[@class='detail-col flLt']/p[text()='Accommodation']/span)[" + i + "]").getAttribute("class");
			
			if ((university.equalsIgnoreCase("tick-mark")) && (scholarship.equalsIgnoreCase("tick-mark"))&& (accomodation.equalsIgnoreCase("tick-mark"))) {
			System.out.println("public university, scholarship and Accomadation facilities enabled");
			driver.findElementByXPath("(//p[text()='Add to compare'])[" + i + "]").click();
			break;
			
			} else {
				System.out.println(" facilities  are Not Enabled");
			}
		}
     
     //7.select the first college under compare with similar colleges
     Thread.sleep(2000);
     driver.findElementByXPath("(//a[@class='add-tag-title'])[1]").click();
     
     //8.click on compare colleges>
     Thread.sleep(2000);
     driver.findElementByXPath("//strong[text()='Compare Colleges >']").click();
     
	//9.select when to study as 2021
     Thread.sleep(2000);
     driver.findElementByXPath("//label[@for='year1']/span").click();
     
	//10.select preferred countries as USA
     Thread.sleep(2000);
     driver.findElementByXPath("(//div[@class='input'])[1]").click();
     Thread.sleep(2000);
     driver.findElementByXPath("//label[@class='nolnht']/span").click();
    // driver.findElementByXPath("//label[@for='USA_KedtHt']/span").click();
      driver.findElementByXPath(" //a[@class='ok-btn']").click();
     
     
     
     
	//11.select level of study as masters
     Thread.sleep(1000);
    driver.findElementByXPath("(//input[@value='Masters']/following::label/span)[1]").click();

	//12.select preferred course as MS
     Thread.sleep(2000);
     driver.findElementByXPath("(//div[@class='input'])[2]").click();
     driver.findElementByXPath("//li[text()='MS']").click();
     
	//13.select specialization as "computer science  & Engineering"
     Thread.sleep(2000);
     driver.findElementByXPath("//div[text()='All specializations']").click();
     driver.findElementByXPath("//li[text()='Computer Science & Engineering']").click();
     
     //14.click on signup
     Thread.sleep(2000);
     driver.findElementByXPath("//a[@id='signup']").click();
     
     
	//15.print all the warning messages displayed on the screen for missed mandatory fields
     List<WebElement> errormsgs = driver.findElementsByXPath("//div[@class='helper-text']");
     for (WebElement warnmsg : errormsgs) {
    	 if(warnmsg.getText().length()>1) {
    		 System.out.println(warnmsg.getText());
    	 }
		
	}
     driver.close();
     
     

	}

}
