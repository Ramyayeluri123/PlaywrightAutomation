package com.TestClass;

import BaseClass.Base1;
import com.OpenCart.HomePage;
import com.OpenCart.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    Base1 base1;
    Page page;

    HomePage homePage;
            LoginPage loginPage;
    OpenTestClass openTestClass;


    @BeforeTest
    public void setup() {
        base1 = new Base1();
        page = base1.initBrowser("firefox");
        homePage = new HomePage(page);
        loginPage=new LoginPage(page);
         openTestClass=new OpenTestClass();

    }
    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}

