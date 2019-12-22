package com.mercurytours.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class methods {
	
	 WebDriver driver;
	
	//browser launch
	public void applaunch() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.open('http://newtours.demoaut.com/','_blank')");
		//driver.get("http://newtours.demoaut.com/");
		
	
	}
	// application close 
	public void appclose()
	{
		driver.close();
	}
	//login using xpath
	public void login() throws InterruptedException
	{
		new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='userName']")));
		WebElement uname = driver.findElement(By.xpath("//input[@name='userName']"));
		uname.sendKeys("dasd");
		new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
		WebElement passwd=driver.findElement(By.xpath("//input[@name='password']"));
		passwd.sendKeys("dasd");
		new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='login']")));
		WebElement login =driver.findElement(By.xpath("//input[@name='login']"));
		login.click();
	
	}
	
	public void verifyValidLogin()
	{
		/* verifying valid login with URL*/
		
		/*String expectedurl = "http://newtours.demoaut.com/mercuryreservation.php?osCsid=1a39f418ce56b373bae995b9da9b403f";
		String actualurl = driver.getCurrentUrl();
		System.out.println("expecting title:" +" "+expectedurl);
		System.out.println("actual title:"+" "+actualurl);
		
		if(expectedurl.equals(actualurl))
		{
			System.out.println("login successful");
		}
		else
		{
			System.out.println("login failed");
		
		}
	}	*/
	
		/*verify login with element*/
		
		WebElement cont =driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]"));
		if(cont.isDisplayed())
		{
			System.out.println("login successful");
		}
		else
		{
			System.out.println("login failed");
		}
	}
		/*verify login with title*/
		/*
		String expectedtitle = "Find a Flight: Mercury Tours: ";
		String actualtitle = driver.getTitle();
		System.out.println("expecting title:" +" "+expectedtitle);
		System.out.println("actual title:"+" "+actualtitle);
		
		if(expectedtitle.equals(actualtitle))
		{
			System.out.println("login successful");
		}
		else
		{
			System.out.println("login failed");
		
		}
	}*/
	
		
	// flight finder details with xpath
	public void flightfinder() throws InterruptedException
	{
		WebElement oneway =driver.findElement(By.xpath("//input[@value='oneway']"));
		oneway.click();
		Thread.sleep(3000);
		WebElement passangers =driver.findElement(By.xpath("//select[@name='passCount']"));
		Select count =new Select(passangers);
		count.selectByValue("2");
		Thread.sleep(3000);
		WebElement departcity =driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select fromcity =new Select(departcity);
		fromcity.selectByValue("New York");
		Thread.sleep(3000);
		WebElement on =driver.findElement(By.xpath("//select[@name='fromMonth']"));
		Select month =new Select(on);
		month.selectByValue("5");
		Thread.sleep(3000);
		WebElement date =driver.findElement(By.xpath("//select[@name='fromDay']"));
		Select number= new Select(date);
		number.selectByValue("24");
		Thread.sleep(3000);
		WebElement toport =driver.findElement(By.xpath("//select[@name='toPort']"));
		Select tocity=new Select(toport);
		tocity.selectByValue("Portland");
		Thread.sleep(3000);	
		WebElement service =driver.findElement(By.xpath("//input[@value='First']"));
		service.click();
		WebElement cont = driver.findElement(By.xpath("//input[@name='findFlights']"));
		cont.click();
	}
	// login with action
	public void actionlogin() throws InterruptedException
	{
		WebElement uname = driver.findElement(By.xpath("//input[@name='userName']"));
		uname.sendKeys("dasd");
		Thread.sleep(3000);
		WebElement passwd=driver.findElement(By.xpath("//input[@name='password']"));
		passwd.sendKeys("dasd");
		Thread.sleep(3000);
		WebElement login =driver.findElement(By.xpath("//input[@value='Login']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(login).build().perform();
		builder.click(login).build().perform();	
		
	}
	
	//login with robot
	
	public void robotlogin() throws InterruptedException, AWTException
	{
		WebElement uname = driver.findElement(By.xpath("//input[@name='userName']"));
		uname.click();
		Robot r1=new Robot();
		r1.keyPress(KeyEvent.VK_D);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyPress(KeyEvent.VK_S);
		r1.keyPress(KeyEvent.VK_D);Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_TAB);
		r1.keyPress(KeyEvent.VK_D);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyPress(KeyEvent.VK_S);
		r1.keyPress(KeyEvent.VK_D);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_TAB);
		r1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		WebElement oneway =driver.findElement(By.xpath("//input[@value='oneway']"));
		oneway.click();
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		
	}
	
	//login_with_sikuli
	
	public void sikulilogin() throws InterruptedException, FindFailed
	{
		Screen Scr =new Screen();
		Pattern uname = new Pattern("./sikuli_images/Capture4.PNG");
		Scr.click(uname);
		Scr.type("dasd");
		Thread.sleep(3000);
		Pattern pswd =new Pattern("./sikuli_images/Capture5.PNG");
		Scr.click(pswd);
		Scr.type("dasd");
		Thread.sleep(3000);
		Pattern btnlgn =new Pattern("./sikuli_images/Capture.PNG");
		Scr.click(btnlgn);
	}
	
	public void loginwithtestdata() throws IOException, InterruptedException
	{
		File fle =new File("./testdata/testdata.properties");
		FileInputStream flstrm =new FileInputStream(fle);
		Properties pro = new Properties();
		pro.load(flstrm);
		Thread.sleep(3000);
		WebElement email =driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys(pro.getProperty("uname"));
		WebElement password =driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys(pro.getProperty("pward"));
		WebElement login=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		login.click();
	}
	
	public void rightclick()
	{
		Actions act3 =new Actions(driver);
		act3.contextClick();
	}
	
	public void loginDataDrivenExcelSheet() throws BiffException, IOException, InterruptedException {

        File src = new File("./testdata/exceldata.xls");
        Workbook wb = Workbook.getWorkbook(src);
        Sheet sh1 = wb.getSheet("Sheet1");
        int rows = sh1.getRows();
        for (int i = 1; i < rows; i++) 
        {
             String userNameDataFromExcel = sh1.getCell(0, i).getContents();
             String passwordDataFromExcel = sh1.getCell(1, i).getContents();
             Thread.sleep(2000);
             WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
             uName.sendKeys(userNameDataFromExcel);
             Thread.sleep(2000);
             WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
             pwd.sendKeys(passwordDataFromExcel);
             Thread.sleep(2000);
             WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
             login.click();
             Thread.sleep(5000);
             String expectedtitle = "Find a Flight: Mercury Tours:";
     		String actualtitle = driver.getTitle();
     		System.out.println("expecting title:" +" "+expectedtitle);
     		System.out.println("actual title:"+" "+actualtitle);
     		
     		if(expectedtitle.equals(actualtitle))
     		{
     			System.out.println("login successful");
     			 WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
                 home.click();
                 Thread.sleep(5000);
     		}
     		else
     		{
     			System.out.println("login failed");
     			WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
                home.click();
     		
     		}
            
        }
	}
	
	public void screenshot() throws InterruptedException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./screenshots/snap.png"));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}

		Thread.sleep(3000);
	}	
	
	/*
	 * Photo Upload with AutoIT
	 */
	public void autoTest() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://imgbb.com/");
		Thread.sleep(4000);
		WebElement btnStartUpload = driver.findElement(By.xpath("//a[@class='btn btn-big blue']"));
		btnStartUpload.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("./autoitexe/autoitfile.exe");
		Thread.sleep(6000);
		WebElement btnUpload = driver.findElement(By.xpath("//button[@class='btn btn-big green']"));
		btnUpload.click();
		Thread.sleep(5000);
	}
	
	
}
