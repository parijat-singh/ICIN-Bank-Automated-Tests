package com.simplilearn.workshop.ICINmain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.simplilearn.workshop.ICINmain.*;

public class PositiveTests {
	@Test
	public void positiveTest() {

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
		sleep(1000);

		// verification on new url
		String expectedUrl = GlobalConstants.baseUrl + "home";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		// fields visible

		WebElement homeButton = driver.findElement(By.xpath("//app-root/app-home/app-navbar//a[@href='/home']"));
		Assert.assertTrue(homeButton.isDisplayed(), "ICIN Bank Home button is not visible");
		// sleep(1000);

		// WebElement logoutButton =
		// driver.findElement(By.xpath("//app-root/app-home/app-navbar/nav/div[@class='collapse
		// navbar-collapse']//div[@class='dropdown-menu show']/a[2]"));
		// Assert.assertTrue(logoutButton.isDisplayed(),"Logout button is not visible");

		// screen messages
		WebElement welcomeMessage = driver.findElement(
				By.xpath("//app-root/app-home/body[@class='landing']//h2[.='Welcome to ICIN Bank user2']"));
		String actualMessage = welcomeMessage.getText();
		String expectedMessage = "Welcome to ICIN Bank user2";
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message. \n" + "Actual Message:" + actualMessage
						+ "\n Expected Message: " + expectedMessage);

		/*********************************************************************/
		/************************ Transfer Money Tests *************************/
		/*********************************************************************/

		// click Transfer Money
		WebElement transferButton = driver.findElement(By
				.xpath("//app-root/app-home/app-navbar//div[@class='collapse navbar-collapse']//a[@href='/transfer']"));
		transferButton.click();
		sleep(1000);

		// verification on new url
		expectedUrl = GlobalConstants.baseUrl + "transfer";
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		// fields visible

		WebElement xferButton = driver.findElement(By.xpath(
				"//app-root/app-transfer-between-accounts//form[@method='post']//button[@class='btn btn-info form-control']"));
		Assert.assertTrue(xferButton.isDisplayed(), "ICIN Bank Home button is not visible");
		// sleep(1000);

		// WebElement logoutButton =
		// driver.findElement(By.xpath("//app-root/app-home/app-navbar/nav/div[@class='collapse
		// navbar-collapse']//div[@class='dropdown-menu show']/a[2]"));
		// Assert.assertTrue(logoutButton.isDisplayed(),"Logout button is not visible");

		// screen messages
		WebElement transferMessage = driver.findElement(
				By.xpath("//app-root/app-transfer-between-accounts//form[@method='post']//h3[.='Transfer Money']"));
		actualMessage = transferMessage.getText();
		expectedMessage = "Transfer Money";
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message. \n" + "Actual Message:" + actualMessage
						+ "\n Expected Message: " + expectedMessage);

		// enter target account #

		WebElement targetAcc = driver.findElement(
				By.xpath("//app-root/app-transfer-between-accounts//form[@method='post']/div[3]/input[@type='text']"));
		targetAcc.sendKeys("50000000001");
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
		// 
		WebElement transferSuccMessage = driver.findElement(
				By.xpath("/html//h2[@id='swal2-title']"));
		actualMessage = transferSuccMessage.getText();
		expectedMessage = "Transaction Completed Successfully";
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message. \n" + "Actual Message:" + actualMessage
						+ "\n Expected Message: " + expectedMessage);
		// 
		WebElement tOKButton = driver.findElement(By.xpath(
				"/html//div[@role='dialog']/div[@class='swal2-actions']/button[1]"));
		tOKButton.click();
		sleep(3000);

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
