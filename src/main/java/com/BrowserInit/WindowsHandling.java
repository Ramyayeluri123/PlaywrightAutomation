package com.BrowserInit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class WindowsHandling {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.navigate("https://letcode.in/windows");
        /*1.single window*/
//        page.locator("id=home").click();
//      Page popup=page.waitForPopup(()->{
//            page.locator("id=home").click();
//          page.locator("id=multi").click();
//
//      });
//      popup.waitForLoadState();
//        System.out.println(popup.title());
//        System.out.println(popup.url());
        /*2.multiple Windows*/

//        page.locator("id=home").click();
//        Thread.sleep(3000);
//        Page popup=page.waitForPopup(()->{
//            page.locator("id=multi").click();
//
//        });
//        popup.waitForLoadState();
//        System.out.println(popup.title());
//        System.out.println(popup.url());
        /*Wait for no of tabs*/
        page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(p->p.context().pages().size()==3),()->{
            page.locator("id=multi").click();});
        List<Page> pages=page.context().pages();
        for (Page tabs:pages){
           tabs.waitForLoadState();
            System.out.println(tabs.url());

        }
        Page alertpage=pages.get(1);
        Page dropdown=pages.get(2);
        System.out.println(dropdown.url());
        System.out.println(alertpage.textContent("h1"));
        page.close();
        playwright.close();
    }
}
