package com.TestClass;

import BaseClass.Base1;
import BaseClass.LogInBase;
import com.OpenCart.HomePage;
import com.OpenCart.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

    @Test
    public void loginPageNavigationTest(){
      loginPage = homePage.navigateToLoginPage();
      String actLoginPageTitle=loginPage.getLoginPageTitle();
        System.out.println("page title:"+actLoginPageTitle);
        Assert.assertEquals(actLoginPageTitle,"Your Store");

  }
}
