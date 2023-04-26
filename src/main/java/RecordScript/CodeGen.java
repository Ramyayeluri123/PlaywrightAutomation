package RecordScript;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class CodeGen {
        public static void main(String[] args) {
            try (Playwright playwright = Playwright.create()) {
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));
                BrowserContext context = browser.newContext();
                Page page = context.newPage();
                page.navigate("https://www.google.co.in/");
                page.frameLocator("iframe[name=\"callout\"]").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("No thanks")).click();
                page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).click();
                page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).fill("natural numbers code");
                page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).press("Enter");
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Natural Numbers GeeksforGeeks https://www.geeksforgeeks.org › natural-numbers")).click();
                page.locator("html").dblclick();
                page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("// C++ program to find the // sum of natural numbers up // to n using recursion #include <iostream> using namespace std; // Returns sum of first // n natural numbers int recurSum(int n) { if (n <= 1) return n; return n + recurSum(n - 1); } // Driver code int main() { int n = 5; cout << recurSum(n); return 0; }")).getByText("#include <iostream>").click();
                page.locator(".container > div:nth-child(15)").first().click();
                page.locator(".container > div:nth-child(15)").first().click();
                page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("// C++ program to find the // sum of natural numbers up // to n using recursion #include <iostream> using namespace std; // Returns sum of first // n natural numbers int recurSum(int n) { if (n <= 1) return n; return n + recurSum(n - 1); } // Driver code int main() { int n = 5; cout << recurSum(n); return 0; }")).getByText("n = 5;").click();
                page.getByText("15").nth(1).click();
                page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("// C++ program to find the // sum of natural numbers up // to n using recursion #include <iostream> using namespace std; // Returns sum of first // n natural numbers int recurSum(int n) { if (n <= 1) return n; return n + recurSum(n - 1); } // Driver code int main() { int n = 5; cout << recurSum(n); return 0; }")).getByText("// Returns sum of first").click();
                page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("// C++ program to find the // sum of natural numbers up // to n using recursion #include <iostream> using namespace std; // Returns sum of first // n natural numbers int recurSum(int n) { if (n <= 1) return n; return n + recurSum(n - 1); } // Driver code int main() { int n = 5; cout << recurSum(n); return 0; }")).getByText("return n + recurSum(n - 1);").click();
                page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("// C++ program to find the // sum of natural numbers up // to n using recursion #include <iostream> using namespace std; // Returns sum of first // n natural numbers int recurSum(int n) { if (n <= 1) return n; return n + recurSum(n - 1); } // Driver code int main() { int n = 5; cout << recurSum(n); return 0; }")).getByText("n + recurSum(n - 1);").click();
            }
        }
    }

