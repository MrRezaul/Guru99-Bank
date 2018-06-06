package com.guru99.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	
	static WebDriver driver;
	static Properties prop;
	
	public TestBase () {
		prop= new Properties ();
		try {
			FileInputStream file= new FileInputStream("C:\\Users\\MONIKA\\eclipse-workspace\\Guru99bankTest\\src\\main\\java\\com\\guru99\\qa\\confiq\\config.properties");
	
			prop.load(file);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void initializaion () {
		
		String browsername= prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\MONIKA\\Downloads\\chromedriver.exe");
 
			driver=new ChromeDriver();
		}else if (browsername.equals("FireFox")) {
			System.setProperty("webdriver.geko.driver", "C:\\Users\\MONIKA\\Downloads\\gekodriver\\chromedriver.exe");
			   driver=new FirefoxDriver();	
			   
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 
		
		driver.get(prop.getProperty("url"));
	
		
		
	}
}

