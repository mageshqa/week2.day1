package week2.day1;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {

		// initiate chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		System.out.println("Driver Initiated");

		// open testleaf site
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		System.out.println("URL Opened");

		// login credentials
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("Demosalesmanager");

		System.out.println("User Name Entered");

		WebElement userPassword = driver.findElement(By.id("password"));
		userPassword.sendKeys("crmsfa");

		System.out.println("Password Entered");

		// click submit
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();

		System.out.println("Login Clicked");

		// click CRM/SFA app
		WebElement crmsfaButton = driver.findElement(By.linkText("CRM/SFA"));
		crmsfaButton.click();

		System.out.println("Entered into CRM/SFA app");

		// click Leads tab
		WebElement leadsTab = driver.findElement(By.linkText("Leads"));
		leadsTab.click();

		System.out.println("Clicked Leads Tab");

		// click create new Leads
		WebElement createLeadLink = driver.findElement(By.linkText("Create Lead"));
		createLeadLink.click();

		System.out.println("Clicked Create Leads");

		// enter mandatory fields in Leads page
		WebElement companyName = driver.findElement(By.id("createLeadForm_companyName"));
		companyName.sendKeys("Wipro");

		System.out.println("Company Name Entered");

		WebElement foreName = driver.findElement(By.id("createLeadForm_firstName"));
		foreName.sendKeys("Magesh");

		System.out.println("Fore Name Entered");

		WebElement surName = driver.findElement(By.id("createLeadForm_lastName"));
		surName.sendKeys("Rajan");

		System.out.println("Sur Name Entered");

		// choose source droplist
		WebElement sourceDropList = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sourceList = new Select(sourceDropList);

		// Select sourceList = new Select();

		sourceList.selectByIndex(4);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		sourceList.selectByValue("LEAD_PARTNER");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		sourceList.selectByVisibleText("Conference");

		List<WebElement> listOptions = sourceList.getOptions();
		// display all options from droplist
		for (WebElement opt : listOptions) {
			System.out.println(opt.getText());
		}
		System.out.println("Total number of options in DropList is - " + listOptions.size());

		// enter Dept
		WebElement department = driver.findElement(By.id("createLeadForm_departmentName"));
		department.sendKeys("Food & Beverages");

		// enter description
		WebElement description = driver.findElement(By.id("createLeadForm_description"));
		description.sendKeys("I work in food & beverages department");

		// enter email
		WebElement email = driver.findElement(By.id("createLeadForm_primaryEmail"));
		email.sendKeys("abc@gmail.com");

		// select NY state
		WebElement stateProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateList = new Select(stateProvince);
		stateList.selectByVisibleText("New York");

		// submit form
		WebElement submitForm = driver.findElement(By.className("smallSubmit"));
		submitForm.click();

		System.out.println("Form Created");

		// get text of resulting page
		WebElement createPageTitle = driver.findElement(By.id("sectionHeaderTitle_leads"));
		System.out.println("Page Title of resulting page after creating Lead is " + createPageTitle.getText());

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		// click Duplicate Lead WebElement dupLeadButton =
		WebElement dupLeadButton = driver.findElement(By.linkText("Duplicate Lead"));
		dupLeadButton.click();

		// clear and reenter company name WebElement newCompName =
		WebElement newCompName = driver.findElement(By.id("createLeadForm_companyName"));
		newCompName.clear();
		newCompName.sendKeys("Wipro Limited");

		System.out.println("New Company Name Entered");

		// clear and reenter first name WebElement newForeName =
		WebElement newForeName = driver.findElement(By.id("createLeadForm_firstName"));
		newForeName.clear();
		newForeName.sendKeys("MageshOPST");
		System.out.println("New First Name Entered");

		// submit form after duplicate submitForm.click();
		WebElement dupSubmitForm = driver.findElement(By.className("smallSubmit"));
		dupSubmitForm.click();
		System.out.println("Create Lead button clicked after Duplicate operation");

		// get text of resulting page WebElement editPageTitle = createPageTitle; //

		WebElement newTitle = driver.findElement(By.id("sectionHeaderTitle_leads"));
		System.out.println("Page Title of resulting page after creating Lead is " + newTitle.getText());

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		// close browser driver.quit();
		driver.quit();
	}

}
