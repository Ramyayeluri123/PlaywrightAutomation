package Assignments;

import com.microsoft.playwright.*;

public class Assignment3 {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.navigate("https://testsheepnz.github.io/");
        Locator clickCalculator= page.locator("id=gotoBasicCalc");
        clickCalculator.click();
        Locator firstNumber=page.locator("id=number1Field");
        firstNumber.type("1");
        Locator secondNumber=page.locator("id=number2Field");
        secondNumber.type("5");
        Locator operation=page.locator("id=selectOperationDropdown");
        operation.selectOption("2");
        Locator clickingToCalculate=page.locator("id=calculateButton");
        clickingToCalculate.click();
        String answerDisplaying=page.locator("#numberAnswerField").textContent();
        System.out.println(answerDisplaying);








    }
}
