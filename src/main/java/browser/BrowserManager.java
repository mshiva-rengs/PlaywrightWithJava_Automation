package browser;

import com.microsoft.playwright.*;

import java.awt.*;

public class BrowserManager {
    public Playwright playwright;
    public Page page;

    public BrowserContext context;
    public Browser browser;


    public void setUp(){

        System.out.println("Setting Up Playwright");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        page = context.newPage();
        System.out.println("Playwright Set Up is complete!");

    }
    public void tearDown(){
        System.out.println("Tearing down Playwright");

        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();

        System.out.println("Tearing down complete");
     }
}
