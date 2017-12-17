package com.CRM.QA.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CRM.QA.Utils.Constant;
import com.CRM.QA.Utils.Xls_Reader;

public class BaseTest {

	public static WebDriver driver;
	public Properties prop;
	public Actions act;
	public Xls_Reader xls;

	public BaseTest() throws IOException {

		try {

			FileInputStream fs = new FileInputStream(
					System.getProperty("user.dir") + "//src//main//java//com//CRM//QA//Config//config.properties");
			prop = new Properties();
			prop.load(fs);
		} catch (Exception ex) {

			System.out.println("Error is :: " + ex.getMessage());
			System.out.println("Error is :: " + ex.getStackTrace());
		}

		xls = new Xls_Reader(
				System.getProperty("user.dir") + "//src//main//java//com//CRM//QA//TestData//FreeCrmTestData.xlsx");

	}

	public void openBrowser(String brName) {

		try {

			if (brName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(Constant.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(Constant.IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);

			}
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
		}

	}

	public static void navigate(String url) {
		driver.get(url);

	}

	// ************************ Generic Methods//
	// ***************************************

	public void explicitlyWait(WebElement elementt) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(elementt)).click();

	}

	public void click(WebElement element) {
		element.click();

	}

	public void hoverMouseandClick(WebElement element1, WebElement element2) throws InterruptedException {
		act = new Actions(driver);
		act.moveToElement(element1).build().perform();
		Thread.sleep(1000);
		act.moveToElement(element2).click().build().perform();

	}

	public void switchToFrame(String frm) {

		WebElement frame = driver.findElement(By.xpath(frm));
		driver.switchTo().frame(frame);

	}

}