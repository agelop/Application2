import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class RegressionTest {

    // This script was created against AOS 1.1.3.  Since it uses Xpath, you may need to update the script
    // if using against a different version.
    //private static final String ADV_WEBSITE  = "http://nimbusserver.aos.com:8000/#/";
    private static final String ADV_WEBSITE  = "http://www.advantageonlineshopping.com";

    //You will need to have an account created in AOS and will need to supply the credentials
    //These are known defaults as of 2018/sep/12
    private static final String ADV_LOGIN    = "Mercury"; //"insert login name here";
    private static final String ADV_PASSWORD = "Mercury"; //"insert password here";

    private static WebDriver driver;
    private static WebDriverWait wait;


    public RegressionTest() {
        //Change this constructor to private if you supply your own public constructor
    }


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //WebDriverManager.chromedriver().forceCache();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        driver = new ChromeDriver(options);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 60);
        wait.pollingEvery(10, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(ADV_WEBSITE);

    }

    @AfterClass
    public static void tearDownAfterClass() {
        //Clean up and dispose of the driver
        //Good explanation of close, quit, dispose here http://stackoverflow.com/questions/15067107/difference-between-webdriver-dispose-close-and-quit
        driver.quit();
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void checkTabletPrice() throws Exception {

        //Login to Advantage
        WebElement userButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("menuUser")));
        userButton.click();

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-view[1]/div/input")));
        usernameField.sendKeys(ADV_LOGIN);

        WebElement passwdField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-view[2]/div/input")));
        passwdField.sendKeys(ADV_PASSWORD);

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign_in_btnundefined")));
        signInButton.click();

        //Click on Tablets
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
        WebElement tabletsLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("tabletsTxt")));
        tabletsLink.click();

        //Click on specific tablet
        WebElement tabletItem = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("HP Pro Tablet 608 G1")));
        tabletItem.click();

        //Add Tablet to cart
        WebElement saveToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("save_to_cart")));
        saveToCartButton.click();

        //Go to Checkout
        WebElement shoppingCart = wait.until(ExpectedConditions.elementToBeClickable(By.id("shoppingCartLink")));
        shoppingCart.click();
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkOutButton")));
        checkoutButton.click();


        //Checkout
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("next_btn")));
        nextButton.click();

        //Check Price
        WebElement priceText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"userCart\"]/div[2]/label[2]/span")));
        String expectedPrice = "$479.00";
        String actualPrice = priceText.getText();
        Assert.assertEquals(expectedPrice, actualPrice);

        // Save screenshot
        //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileHandler.copy(scrFile, new File(".\\target\\screenshots\\tablet.png"));

        //Go to Cart to Remove
        Actions action = new Actions(driver);
        WebElement shoppingCart2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shoppingCartLink")));
        action.moveToElement(shoppingCart2).build().perform();
        action.release();

        //Remove Item
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product\"]/td[3]/div/div")));
        removeButton.click();


        //Sign out User
        //WebElement userButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("menuUser")));
        //userButton2.click();

        //WebElement signoutMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginMiniTitle\"]/label[3]")));
        //signoutMenu.click();

    }


}
