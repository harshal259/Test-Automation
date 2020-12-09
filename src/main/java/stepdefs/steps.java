package stepdefs;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import org.openqa.selenium.By;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class steps extends DriverFactory {
    public CommonUtils commonutils = null;

    public steps() {
        commonutils = new CommonUtils();
    }

    @Given("^user is on home page$")
    public void user_is_on_home_page() throws Throwable {
        verifyThatUserLandsOnPage(propReader.readProperty("homePage"));
    }

    @Then("^user created a new account by entering details$")
    public void user_created_a_new_account_by_entering_details() throws Throwable {
        driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys("your skill");
        driver.findElement(By.xpath("//input[@name = 'reg_email__']")).sendKeys("abc@abc.com");
        driver.findElement(By.xpath("//input[@name = 'reg_passwd__']")).sendKeys("test123");

        commonutils.selectDropdown(driver.findElement(By.xpath("//*[@id=\"day\"]"))).selectByValue("3");
        commonutils.selectDropdown(driver.findElement(By.xpath("//*[@id=\"month\"]"))).selectByValue("3");
        commonutils.selectDropdown(driver.findElement(By.xpath("//*[@id=\"year\"]"))).selectByValue("2015");

        driver.findElement(By.xpath("//input[@value='2']")).click();
    }

    @Then("^user click on Data policy link$")
    public void user_click_on_Data_policy_link() throws Throwable {
        String parentWindow = driver.getWindowHandle();
        //System.out.println(parentWindow);
        driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@id='privacy-link']")).click();
        System.out.println("clicked");

        Set<String> windows = driver.getWindowHandles();

        for (String w1 : windows) {

            if (w1.equalsIgnoreCase(parentWindow)) {
                continue;
            } else {
                driver.switchTo().window(w1);
                System.out.println(driver.getCurrentUrl());
            }

        }
        driver.switchTo().window(parentWindow);
        System.out.println("Hi we are at parent window " + driver.getCurrentUrl());
    }

    @Then("^I clear the entered data and reentered it through excel$")
    public void i_clear_the_entered_data_and_reentered_it_through_excel() throws Throwable {

        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\config\\test.xlsx";
        driver.findElement(By.xpath("//input[@name = 'firstname']")).clear();
        driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys(commonutils.ExcelInput(1, 0, 0, path));

        driver.findElement(By.xpath("//input[@name = 'lastname']")).clear();
        driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys(commonutils.ExcelInput(1, 1, 0, path));

        driver.findElement(By.xpath("//input[@name = 'reg_passwd__']")).clear();
        driver.findElement(By.xpath("//input[@name = 'reg_passwd__']")).sendKeys(commonutils.ExcelInput(1, 2, 0, path));

        driver.findElement(By.xpath("//input[@name = 'reg_email__']")).clear();
        driver.findElement(By.xpath("//input[@name = 'reg_email__']")).sendKeys(commonutils.ExcelInput(1, 3, 0, path));

    }

    @Then("^I execute select query on DB$")
    public void OperationalMethod() throws Throwable {
        try {
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("select * from world.country where name like 'IN%';");

            int i = 0;

            while (resultSet.next()) {
                String dbCell = resultSet.getString(i);
                System.out.println("DB Cell Data => " + dbCell);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @When("^user searches for \"([^\"]*)\"$")
    public void userSearchesFor(String searchText) throws Throwable {
        driver.findElement(By.xpath("//input[@id = 'search_query_top']")).sendKeys(searchText);
        driver.findElement(By.xpath("//input[@id = 'search_query_top']")).sendKeys(Keys.RETURN);
    }

    @And("^verify that user lands on page \"([^\"]*)\"$")
    public void verifyThatUserLandsOnPage(String pageName) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getTestURL());
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);
        Assert.assertEquals(pageName, title);
    }

    @And("^verify that top bar consists below menu items$")
    public void verifyThatTopBarConsistsBelowMenuItems(List<String> expmenuList) {
        List<WebElement> actMenuList;
        boolean flag = true;
        actMenuList = driver.findElements(By.xpath("//*[@id='block_top_menu']/ul/li/a"));
        for (int i = 0; i < expmenuList.size(); i++) {
            if (!actMenuList.get(i).getText().equalsIgnoreCase(expmenuList.get(i))) {
                flag = false;
                System.out.println("\nElements differ at index: " + i);
                System.out.println("\nExpected " + expmenuList.get(i) + " but found " + actMenuList.get(i).getText());
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @When("^user hovers on \"([^\"]*)\" and selects \"([^\"]*)\"$")
    public void userHoversOnAndSelects(String sectionName, String category) throws Throwable {
        Actions actions = new Actions(driver);
        WebElement hoverElement = driver.findElement(By.xpath("//a[@title='" + sectionName + "']"));
        actions.moveToElement(hoverElement).perform();
        WebElement clickElement = driver.findElement(By.xpath("//a[@title='" + sectionName + "']//parent::li//a[@title='" + category + "']"));
        clickElement.click();
    }

    @And("^verify that (\\d+) products are displayed$")
    public void verifyThatProductsAreDisplayed(int expProductCount) {
        int actProductCount = driver.findElements(By.xpath("//ul[@class='product_list grid row']/li")).size();
        String displayedCount = driver.findElement(By.xpath("//div[@class='product-count'][1]")).getText().split("-")[1].trim().split(" ")[0];

        System.out.println("\nexpProductCount is: " + expProductCount);
        System.out.println("\nactProductCount is: " + actProductCount);
        System.out.println("\ndisplayedCount is: " + displayedCount);

        Assert.assertEquals(expProductCount, actProductCount);
        Assert.assertEquals(expProductCount, Integer.parseInt(displayedCount));
    }

    @When("^user adds item (\\d+) to the card$")
    public void userAddsItemToTheCard(int itemIndex) {
        driver.findElement(By.xpath("//a[@title='Add to cart'][" + itemIndex + "]")).click();
        //WIP
    }

    @When("^user applies item filters for \"([^\"]*)\" as per excel sheet \"([^\"]*)\"$")
    public void userAppliesItemFilters(String tcID, String sheetName) throws Throwable {
        String path = System.getProperty("user.dir") + "/src/test/resources/config/test.xlsx";

        Map<String, String> excelData = commonutils.getExcelDataMap(path, sheetName).get(tcID);
        System.out.println("\n Parsing Excel Data: \n" + excelData);
        Set<String> keySet = excelData.keySet();
        for (String colName : keySet) {
            if (excelData.get(colName) != "")
                driver.findElement(By.xpath("//label/a[text()='" + excelData.get(colName) + "']//ancestor::li//input")).click();
        }
        Thread.sleep(2000);
        for (String colName : keySet) {
            if (excelData.get(colName) != "")
                Assert.assertTrue(driver.findElement(By.xpath("//label/a[text()='" + excelData.get(colName) + "']//ancestor::li//input")).isSelected());
        }
    }

    @Then("^I read data for (.*?)$")
    public void iReadDataFor(String CustType) throws Throwable {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/data/testData.xlsx";
        List<String> expectedList = new ArrayList<>();

        Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection(filePath);
        String strQuery = "Select " + CustType + " from Sheet1";
        Recordset recordset = connection.executeQuery(strQuery);
        while (recordset.next()) {
            ArrayList<String> dataCol = recordset.getFieldNames();
//            System.out.println("Printing Column Headers: " + dataColl);
            Iterator<String> itr = dataCol.iterator();
//            System.out.println("Printing Column Header Size: " + dataColl.size());

            while (itr.hasNext()) {
                for (int i = 0; i <= dataCol.size() - 1; i++) {
                    String data = itr.next();
                    String dataVal = recordset.getField(data);
//                    System.out.println("Printing DataVal: " + dataVal);
                    expectedList.add(dataVal);
                }
                break;
            }
        }
        System.out.println("Printing expected List: " + expectedList);
        recordset.close();
        connection.close();
    }

    @And("^I take a screenshot$")
    public void iTakeAScreenshot() throws Exception {
        System.out.println("\nCapturing Screenshot...\n");
        commonutils.waitForPageLoad();
        commonutils.takeSnapShot(driver);
    }
}