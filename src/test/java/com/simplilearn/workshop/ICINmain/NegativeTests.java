package com.simplilearn.workshop.ICINmain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.simplilearn.workshop.ICINmain.*;

public class NegativeTests {
	@Test
	public void loginTest() {

		// create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-new.exe");
		WebDriver driver = new ChromeDriver();
		// sleep(2000);

		// open testpage
		String url = GlobalConstants.baseUrl;
		driver.get(url);
		System.out.println("page is opened");
		// sleep(2000);

		// maximize browser window
		driver.manage().window().maximize();

		/*********************************************************************/
		/****************************** Login Tests ****************************/
		/*********************************************************************/

		// enter username

		WebElement username = driver.findElement(By.xpath("//app-root/app-login//form//input[@type='text']"));
		username.sendKeys("incorrect user");
		// sleep(1000);

		// click login
		WebElement loginButton = driver
				.findElement(By.xpath("//app-root/app-login//form//button[@class='btn btn-primary']"));
		loginButton.click();
		sleep(2000);

		// verification on new url
		String expectedUrl = GlobalConstants.baseUrl + "login";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		// fields visible

		// screen messages
		WebElement pwEmptyMessage = driver.findElement(
				By.xpath("/html//app-root/app-login//form//div[@class='invalid-feedback']/div[.='Please enter a Password']"));
		String actualMessage = pwEmptyMessage.getText();
		String expectedMessage = "Please enter a Password";
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message. \n" + "Actual Message:" + actualMessage
						+ "\n Expected Message: " + expectedMessage);
		
		// enter password
		WebElement password = driver.findElement(By.xpath("//app-root/app-login//form//input[@type='password']"));
		password.sendKeys("incorrectpassword");
		sleep(1000);

		// click login
		WebElement loginButton2 = driver
				.findElement(By.xpath("//app-root/app-login//form//button[@class='btn btn-primary']"));
		loginButton2.click();
		sleep(2000);

		// verification on new url
		expectedUrl = GlobalConstants.baseUrl + "login";
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		// fields visible

		WebElement loginErr = driver.findElement(By.xpath("/html//h2[@id='swal2-title']"));
		Assert.assertTrue(loginErr.isDisplayed(), "Login Incorrect");
		// sleep(1000);

		
		// close browser
		driver.quit();
		
		

	}
	
	@Test
	public void transferTest() {

		// create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-new.exe");
		WebDriver driver = new ChromeDriver();
		// sleep(2000);

		// open testpage
		String url = GlobalConstants.baseUrl;
		driver.get(url);
		System.out.println("page is opened");
		// sleep(2000);

		// maximize browser window
		driver.manage().window().maximize();

		/*********************************************************************/
		/****************************** transfer test ****************************/
		/*********************************************************************/

		// enter username

				WebElement username = driver.findElement(By.xpath("//app-root/app-login//form//input[@type='text']"));
				username.sendKeys("user2");
				// sleep(1000);

				// enter password
				WebElement password = driver.findElement(By.xpath("//app-root/app-login//form//input[@type='password']"));
				password.sendKeys("user1234");
				sleep(1000);

				// click login
				WebElement loginButton = driver
						.findElement(By.xpath("//app-root/app-login//form//button[@class='btn btn-primary']"));
				loginButton.click();
				sleep(2000);
				
				// click Transfer Money
				WebElement transferButton = driver.findElement(By
						.xpath("//app-root/app-home/app-navbar//div[@class='collapse navbar-collapse']//a[@href='/transfer']"));
				transferButton.click();
				sleep(1000);
				
				// enter target account #

				WebElement targetAcc = driver.findElement(
						By.xpath("//app-root/app-transfer-between-accounts//form[@method='post']/div[3]/input[@type='text']"));
				targetAcc.sendKeys("12345678");
				// sleep(1000);

				// enter Transfer amount
				WebElement transferAmt = driver.findElement(
						By.xpath("//app-root/app-transfer-between-accounts//form[@method='post']/div[4]/input[@type='text']"));
				transferAmt.sendKeys("2");
				sleep(1000);

				// click transfer
				WebElement tButton = driver.findElement(By.xpath(
						"//app-root/app-transfer-between-accounts//form[@method='post']//button[@class='btn btn-info form-control']"));
				tButton.click();
				sleep(3000);

				WebElement transferfailMessage = driver.findElement(By.xpath("/html//div[@id='swal2-content']"));
				String actualMessage = transferfailMessage.getText();
				String expectedMessage = "Error code 1691: Account number is incorrect";
				Assert.assertTrue(actualMessage.contains(expectedMessage),
						"Actual message does not contain expected message. \n" + "Actual Message:" + actualMessage
								+ "\n Expected Message: " + expectedMessage);
				//
				WebElement tOKButton = driver
						.findElement(By.xpath("/html//div[@role='dialog']/div[@class='swal2-actions']/button[1]"));
				tOKButton.click();
				sleep(1000);

		
		// close browser
		driver.quit();
		
		

	}

	
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
