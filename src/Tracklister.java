import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Tracklister {
    private String website;
    private String[] data;
    private String title;
    private WebClient webClient = new WebClient();
    private HtmlPage page;

    public Tracklister(String website) {
        this.website = website;
    }

    public Tracklister() {
    }

    public void scrape(String url) throws IOException {
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(8000);
        page = webClient.getPage(url);
        Document doc = Jsoup.parse(page.asXml());
        Elements tracks = doc.select("#tlp_5921274");


//        driver.get(url);
        writeHTMLFile(doc.html());
    }

    private static void writeHTMLFile(String input) {
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        try {
            fWriter = new FileWriter("fileName.html");
            writer = new BufferedWriter(fWriter);
            writer.write(input);
            writer.newLine(); //this is not actually needed for html files - can make your code more readable though
            writer.close(); //make sure you close the writer object
        } catch (Exception e) {
            //catch any exceptions here
        }
    }


}
