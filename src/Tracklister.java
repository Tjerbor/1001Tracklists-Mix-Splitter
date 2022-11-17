import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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


//        driver.get(url);
        writeHTMLFile(doc.html(), "wholeSite");
    }

    public static void shietttt() throws IOException {
        try {
            File file = new File("fileName.html");
            extractData(Jsoup.parse(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void extractData(Document doc) {
        Element parent = doc.getElementById("tlTab");
        Elements els = parent.children();
        els.select("id :not(#playerWidget)");
        System.out.println(els.size());
        if (els.isEmpty()) {
            System.out.println("Empty Dipshit");
        }
    }

    private static void writeHTMLFile(String input, String fileName) {
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        try {
            fWriter = new FileWriter(fileName + ".html");
            writer = new BufferedWriter(fWriter);
            writer.write(input);
            writer.newLine(); //this is not actually needed for html files - can make your code more readable though
            writer.close(); //make sure you close the writer object
        } catch (Exception e) {
            //catch any exceptions here
        }
    }


}
