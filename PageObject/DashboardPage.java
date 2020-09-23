/*
* This is pseudo-code and no actual code that's working.
* The purpose of this code is to illustrade the PageObject pattern commonly
* used when working with tests in an ever chaning environment.
*/

class DashboardPage {

    protected Webdriver driver;

    // Constructor, receives the driver as an argument and sets it to the protected field.
    public DashboardPage(WEebDriver _driver) {
        driver = _driver;
    }

    public DashboardPage verifyDashTitle() {
        string header = driver.findElement(By.cssSelector("h2")).text();
        Assert.equals("Awesome Dash!", header);
        return this;
    }
}