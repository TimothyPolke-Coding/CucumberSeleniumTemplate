package com.timothypolke.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class SeleniumDriver{
	
	private WebDriver driver = null;
	private Wait<WebDriver> wait = null;
	
	public SeleniumDriver(int type, long polling, long timeout){
		setDriver(type);
		setWait(polling, timeout);
	}
	
	public void setDriver(int type){
		if (type == 0){
			String path = this.getClass().getClassLoader().getResource("edgedriver.exe").getPath().replace("%20", " ");
			System.setProperty("webdriver.edge.driver", path);
			driver = new EdgeDriver();
		}
		else if (type == 1) {
			System.setProperty("webdriver.firefox.driver", this.getClass().getClassLoader().getResource("firefoxdriver.exe").getPath().replace("%20", " ");
			driver = new FirefoxDriver();
		}
		else if (type == 2){
			System.setProperty("webdriver.chrome.driver", this.getClass().getClassLoader().getResource("chromedriver.exe").getPath().replace("%20", " ");
			driver = new ChromeDriver();
		}
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public void setWait(long polling, long timeout){
		wait = new FluentWait(driver).pollingEvery(Duration.ofSeconds(polling)).withTimeout(Duration.ofSeconds(timeout));
	}
	
	public Wait getWait(){ 
		return wait;
	}
}