package com.CRM.QA.Pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.QA.BaseTest.BaseTest;
import com.CRM.QA.Utils.Constant;

public class HomePage extends BaseTest {

	public LoginPage login;

	public HomePage() throws IOException {
		super();

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = Constant.CONTACTS_LINK_BTN /*"//a[text()='Contacts']"*/)
	WebElement contactLinks;

	@FindBy(xpath =  Constant.CONTACTS_CREATE_CONTACT_LINK_BTN/*"//a[text()='New Contact']"*/)
	WebElement createContacts;

	@FindBy(xpath =Constant.LOGO_TEXT /*"//div[@id='dispAlertMessage']/following-sibling::table[1]/descendant::td[@class='logo_text"*/)
	WebElement logoText;

	public String verifyHomePageTitle() {

		return driver.getTitle();

	}

	
	public CreateContactPage contactTest() throws InterruptedException, IOException {
//		WebElement frm = driver.findElement(By.xpath("//frame[@name='mainpanel']"));
//		driver.switchTo().frame(frm);
		
		switchToFrame(Constant.FRAME_ID);
		hoverMouseandClick(contactLinks, createContacts);
		return new CreateContactPage();

	}

}
