package com.BrowserInit;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PageAssertions;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.setDefaultAssertionTimeout;
public class AssertionsInPlaywright {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://letcode.in/edit");
        Locator locator=page.locator("h1");
        assertThat(locator).hasText("Input");
        String textContent=locator.textContent();
        System.out.println(textContent);
        /*page assert*/
//        assertThat(page).hasURL("https://letcode.in/edit");
        assertThat(page.locator("#join")).hasAttribute("value","I am good");
        setDefaultAssertionTimeout(10000);
        page.navigate("https://letcode.in/radio");
        assertThat(page.locator("#notfoo")).isChecked();
        page.close();
        playwright.close();
    }
}
