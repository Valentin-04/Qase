package tests;

import org.testng.annotations.Test;

public class AuthorizationTest extends BaseTest {

    @Test(description = "User authorization")
    public void login() {
        loginSteps.login(EMAIL, PASSWORD);
    }
}
