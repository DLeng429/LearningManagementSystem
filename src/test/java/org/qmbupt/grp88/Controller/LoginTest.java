package org.qmbupt.grp88.Controller;

import org.junit.Assert;
import org.junit.Test;

import java.awt.event.ActionEvent;

public class LoginTest {

    @Test
    public void testLogin() {
        Login login = new Login();
        Assert.assertEquals(login.getLoginButton().getText(), "Login");
        Assert.assertEquals(login.getRegisterButton().getText(), "Register");
    }
}