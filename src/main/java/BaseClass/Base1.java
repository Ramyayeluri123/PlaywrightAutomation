package BaseClass;

import com.microsoft.playwright.*;

public class Base1 {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    public Page initBrowser(String browserName){
        System.out.println("browser name is:"+browserName);
       playwright=Playwright.create();
        switch (browserName.toLowerCase()){
            case "firefox":
                browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "Edge":
                browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "Chromium":
                browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
             break;
            default:
                System.out.println("please pass right browser");
                break;
        }
        browserContext=browser.newContext();
        page=browserContext.newPage();
        page.navigate("https://naveenautomationlabs.com/opencart/");
        return page;

    }
}
