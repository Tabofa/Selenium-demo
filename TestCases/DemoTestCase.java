/*
* This is pseudo-code and no actual code that's working.
* The purpose of this code is to illustrade the PageObject pattern commonly
* used when working with tests in an ever chaning environment.
*/

class DemoTestCase extends TestBase {
    
    @Test
    public void loginSuccess() {
        new LoginPage(driver)
            .writeUsername("Some@email.com")
            .writeUsername("password1234")
            .clickLogin()
            .verifyDashTitle();
    }

    @Test
    public void lofinFail() {
        new LoginPage(driver)
            .writeUsername("incorrect@email.com")
            .writeUsername("password1234")
            .clickLoginExpectFail()
            .verifyWrongPassword();
    }
}