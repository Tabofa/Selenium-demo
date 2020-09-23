/*
* This is pseudo-code and no actual code that's working.
* The purpose of this code is to illustrade the PageObject pattern commonly
* used when working with tests in an ever chaning environment.
*/

class TestBase {

    public WebDriver driver;
    // BASE_URL could be handled by getting the value from a config file or an environmental variable.
    private const string BASE_URL = "http://awesome-app.com";

    // Setup needed before you execute each tests
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(); // makes sure you have a fresh driver with no "old" data.
        driver.manage().window().maximize();
        driver.get(BASE_URL); // navigates to your base url
    }

    // Happens after the test method has finnished.
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}