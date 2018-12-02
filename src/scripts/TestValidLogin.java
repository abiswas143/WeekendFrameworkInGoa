package scripts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestValidLogin extends BaseTest{
	@Test
	public void testValidLogin(){
		
		Logger log = LogManager.getLogger(TestValidLogin.class.getName());
		log.debug("Creating an object of LoginPage pom  class");
		LoginPage lp =  new LoginPage(driver);
		log.info("Object of LoginPage pom  class is created successfully");
		//enter username
		log.debug("Retrieving username from excel file");
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		log.info("username retrieved successfully....");
		lp.setUsername(username);
		//enter password
		String password = Lib.getCellValue("ValidLogin", 1, 1);
		lp.setPassword(password);
		//click on login button
		lp.clickLogin();
		/*String aHPTitle = driver.getTitle();
		if (aHPTitle.equals("I dont know")) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed..");
		}*/
		//Explicit wait to wait till the home page is loaded
		WebDriverWait wait = new WebDriverWait(driver, 12);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track123"));
		
		String aHPTitle = driver.getTitle();
		Assert.assertEquals(aHPTitle, "actiTIME - Enter Time-Track");
	}
}
