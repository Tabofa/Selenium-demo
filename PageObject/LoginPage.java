/*
* This is pseudo-code and no actual code that's working.
* The purpose of this code is to illustrade the PageObject pattern commonly
* used when working with tests in an ever chaning environment.
*/

public class LoginPage {

    /*
    * Protected to avoid interfarance from other classes/objects.
    * This field is accessable from all methods within the class
    * Could aswell be private. Would accomplish the same thing in this case.
    */
    protected WeBDriver driver;

    // Constructor, maps the driver to the protected frild
    public LoginPage(WebDriver _driver) {
        driver = _driver;
    }

    // Return type here is LoginPage (so returns itself with 'this' keyworld)
    public LoginPage writeUsername(string usr) {
        driver.findElement(By.id("username")).sendKeys(usr);
        return this;
    }

    public LoginPage writePassword(string pwd) {
        driver.findElement(By.cssSelector("#password")).sendKeys(pwd);
        return this;
    }

    /*
    * Here we expect the login to be successful.
    * We then return the DashboardPage instead of the Login as we have done before.
    * We creade a new object by using the new keyword, specifying the class we 
    * want to use and pass the driver as an argument.
    */
    public DashboardPage clickLogin() {
        driver.findElement(By.id("login-button")).click();
        return new DashboardPage(driver);
    }

    
    public LoginPage clickLoginExpectFail() {
        driver.findElement(By.id("login-button")).click();
        return this;
    }

    /*
    * Use an assert library of your liking.
    * it is debated weather or not to do this kind of evaluation in this way.
    * Personally I don't see a problem with it.
    */ 
    public LoginPage verifyWrongPassword() {
        string errorText = driver.findElement(By.id("errorMessage")).text(); 
        Assert.equals("Ooops, seems you have the wrong credentials there! :(", errorText);
        return this;
    }

}

