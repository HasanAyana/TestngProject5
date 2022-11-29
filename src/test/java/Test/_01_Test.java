package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class _01_Test extends BaseDriverParametre {


    POM p;

    @Test
    void TestCase1() {
        p=new POM(driver);
        Parent pp = new Parent();
        driver.get("https://admin-demo.nopcommerce.com/login");

        pp.sendKeysFunction(p.email, "admin@yourstore.com");
        pp.sendKeysFunction(p.password, "admin");
        pp.clickFunction(p.loginButton);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    void TestCase2() {
        Parent pp = new Parent();
        ArrayList<String> helpMenu = new ArrayList<>();
        pp.clickFunction(p.help);
        pp.clickFunction(p.reports);
        pp.clickFunction(p.system);
        pp.clickFunction(p.configuration);
        pp.clickFunction(p.contentmanager);
        pp.clickFunction(p.promotions);
        pp.clickFunction(p.customer);
        pp.clickFunction(p.sale);
        pp.clickFunction(p.catalog);
        for (WebElement w : p.helpText) {
            helpMenu.add(w.getText());
        }
        for (int i = 0; i < helpMenu.size(); i++) {
            Assert.assertTrue(p.helpText.get(i).getText().contains(helpMenu.get(i)));
        }

    }

    @Test()
    @Parameters("Data")
    void Testcase3(String email) {

        Parent pp = new Parent();
        Actions actions1=new Actions(driver);
        pp.clickFunction(p.customer);
        pp.clickFunction(p.customerss);
        pp.clickFunction(p.addButton);
        //pp.clickFunction(p.addButton);
        pp.sendKeysFunction(p.email, email);
        actions1.sendKeys(Keys.TAB);
        actions1.sendKeys("sdgdfrf");
        actions1.sendKeys(Keys.TAB);
        actions1.sendKeys("dfhrfd");
        actions1.sendKeys(Keys.TAB);
        actions1.sendKeys("gklsdfnjg");
        actions1.sendKeys(Keys.TAB).perform();
        pp.clickFunction(p.male);
        pp.sendKeysFunction(p.date, "10/20/2020");
        pp.clickFunction(p.save);
        Assert.assertTrue(p.onay.getText().contains("succes"));
    }
    @Test(dependsOnMethods = "Testcase3")
    @Parameters("Data")
    void TestCase4(String email) {

        Parent pp = new Parent();
        Actions actions1=new Actions(driver);
        pp.clickFunction(p.customerss);
        pp.sendKeysFunction(p.searchEmail,email);
        actions1.sendKeys(Keys.TAB);
        actions1.sendKeys("dfhrfd");
        actions1.sendKeys(Keys.TAB);
        actions1.sendKeys("gklsdfnjg").perform();
        pp.clickFunction(p.search);
        Assert.assertTrue(p.userControl.getAttribute("nop-value").contains("true"));
    }

    @Test(dependsOnMethods = "TestCase4")
    @Parameters("Data")
    void TestCase5(String email) {
        POM p = new POM(driver);
        Parent pp = new Parent();
        Actions actions1=new Actions(driver);
        pp.clickFunction(p.edit);
        pp.sendKeysFunction(p.email, email);
        actions1.sendKeys(Keys.TAB);
        actions1.sendKeys("sdgdfrf123");
        actions1.sendKeys(Keys.TAB);
        actions1.sendKeys("dfhrfd");
        actions1.sendKeys(Keys.TAB);
        actions1.sendKeys("gklsdfnjg");
        actions1.sendKeys(Keys.TAB).perform();
        pp.clickFunction(p.male);
        pp.sendKeysFunction(p.date, "10/20/2020");
        pp.clickFunction(p.save);
        Assert.assertTrue(p.onay.getText().contains("succes"));
    }

    @Test(dependsOnMethods = "TestCase5")
    @Parameters("Data")
    void TestCase6(String email) {
        POM p = new POM(driver);
        Parent pp = new Parent();
        Actions actions1=new Actions(driver);
        pp.clickFunction(p.customerss);
        pp.sendKeysFunction(p.searchEmail, email);
        actions1.sendKeys(Keys.TAB);
        actions1.sendKeys("dfhrfd");
        actions1.sendKeys(Keys.TAB);
        actions1.sendKeys("gklsdfnjg").perform();
        pp.clickFunction(p.search);
        pp.clickFunction(p.edit);
        pp.clickFunction(p.customerDelete);
        pp.clickFunction(p.delete2);
        Assert.assertTrue(p.onay.getText().contains("succes"));
    }

    @Test(dependsOnMethods = "TestCase6")
    void TestCase7() {
        POM p = new POM(driver);
        Parent pp = new Parent();
        Actions actions1=new Actions(driver);
        pp.sendKeysFunction(p.searchInput, "Shipments");
        actions1.sendKeys(Keys.ARROW_UP);
        actions1.sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(driver.getCurrentUrl().contains("ShipmentList"));
        driver.quit();
    }
}