package tests;

import org.testng.annotations.Test;

public class AuthorizationTest extends BaseTest {

    @Test
    public void login() {
        loginSteps.login(EMAIL, PASSWORD);
    }
}
