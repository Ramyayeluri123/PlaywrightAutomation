package com.BrowserInit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class TestScript {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.navigate("https://bookcart.azurewebsites.net/login");
//        page.getByText("Login").click();
        page.getByLabel("Username").fill("ortoni");
        page.getByLabel("Password").fill("Pass1234$");
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Login")).last().click();
        page.getByPlaceholder("Search books").type("The Hate U Give");
        page.getByRole(AriaRole.OPTION).first().click();
        Thread.sleep(3000);
        page.getByAltText("Book cover image").click();
        System.out.println(page.url());
        playwright.close();


    }

}
