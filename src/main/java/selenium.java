import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class selenium {
    @Test
    public void CheckPayment(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\SeleniumTest\\untitled\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://next.privat24.ua/money-transfer/card");

        By numberCard = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By exp = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By firstname = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By lastname = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        By numberReceiver = By.xpath("//input[@data-qa-node='numberreceiver']");
        By firstname1 = By.xpath("//input[@data-qa-node='firstNamereceiver']");
        By lastname1 = By.xpath("//input[@data-qa-node='lastNamereceiver']");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        By currency = By.xpath("//button[@data-qa-value='UAH']");
        By currencyUSD = By.xpath("//button[@data-qa-value='USD']");
        By commentclick = By.xpath("//span[@data-qa-node='toggle-comment']");
        By comment = By.xpath("//textarea[@data-qa-node='comment']");
        By submitbtn = By.xpath("//button[@class='sc-VigVT hcHAAV']");


        driver.findElement(numberCard).sendKeys("4558032855841715");
        driver.findElement(exp).sendKeys("1128");
        driver.findElement(cvv).sendKeys("156");
        driver.findElement(firstname).sendKeys("Mariia");
        driver.findElement(lastname).sendKeys("Mariia");
        driver.findElement(numberReceiver).sendKeys("5309233034765085");
        driver.findElement(firstname1).sendKeys("Bobik");
        driver.findElement(lastname1).sendKeys("Bobovich");
        driver.findElement(amount).sendKeys("600");
        driver.findElement(currency).click();
        driver.findElement(currencyUSD).click();
        driver.findElement(commentclick).click();
        driver.findElement(comment).sendKeys("Переказ власних коштів");
        driver.findElement(submitbtn).click();

        Assert.assertEquals("4558 0328 5584 1715", driver.findElement(By.xpath("//span[@data-qa-node='payer-card']")).getText());
        Assert.assertEquals("600 USD", driver.findElement(By.xpath("//div[@data-qa-node='payer-amount']")).getText());
        Assert.assertEquals("14.95 USD", driver.findElement(By.xpath("//div[@data-qa-node='payer-currency']")).getText());
        Assert.assertEquals("BOBIK BOBOVICH", driver.findElement(By.xpath("//div[@data-qa-node='receiver-name']")).getText());
        Assert.assertEquals("5309 2330 3476 5085", driver.findElement(By.xpath("//span[@data-qa-node='receiver-card']")).getText());
        Assert.assertEquals("600 USD", driver.findElement(By.xpath("//div[@data-qa-node='receiver-amount']")).getText());
        Assert.assertEquals("0 USD", driver.findElement(By.xpath("//div[@data-qa-node='receiver-currency']")).getText());
        Assert.assertEquals("614.95 USD", driver.findElement(By.xpath("//div[@class='sc-chPdSV iiqwfv']")).getText());

        driver.close();
    }
}
