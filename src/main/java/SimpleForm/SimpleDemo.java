package SimpleForm;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class SimpleDemo {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.lambdatest.com/selenium-playground/");
        Thread.sleep(3000);
        page.locator("a[href=\"https://www.lambdatest.com/selenium-playground/simple-form-demo\"]").click();
        Thread.sleep(3000);
        System.out.println(page.url());
        page.locator("//input[@id=\"user-message\"]").type("Welcome To LambdaTest");
//        String userMessage="Welcome To LambdaTest";
//        System.out.println(userMessage);
        page.locator("#showInput").click();
        System.out.println(page.locator("//p[@id=\"message\"]").textContent());
        assertThat(page.locator("//p[@id=\"message\"]")).isEnabled();
        System.out.println(page.title());
        page.close();
        playwright.close();
    }
}