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
        int track;
        String start;
        String artists;
        String title;

        Element parent = doc.getElementById("tlTab");
        Elements els = parent.children();
        els = els.select("[class^=tlpTog bItm tlpItem]");
        System.out.println(els.size());
        System.out.println(els.first().getElementsByTag("meta").first().attr("content"));
        start = els.first().select("[id^=cue]").text();
        track = Integer.parseInt(els.first().select("[id$=tracknumber_value]").text());
        String[] artistsAndTitle = getArtistsAndTitle(
                els.
                        first().
                        getElementsByTag("meta").
                        first().attr("content"));
        artists = artistsAndTitle[0];
        title = artistsAndTitle[1];
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

    private static int getSecondsOf(String timeStamp) {
        String[] split = timeStamp.split(":");
        switch (split.length) {
            case 1:
                return Integer.parseInt(split[0]);
            case 2:
                return Integer.parseInt(split[0]) * 60
                        + Integer.parseInt(split[1]);
            case 3:
                return Integer.parseInt(split[0]) * 3600
                        + Integer.parseInt(split[1]) * 60
                        + Integer.parseInt(split[2]);
        }
        return -1;
    }

    private static String[] getArtistsAndTitle(String input) {
        String[] split = input.split(" - ");
        String[] result = new String[2];
        if (split.length == 0) {
            return null;
        } else if (split.length == 1) {
            result[0] = split[0];
            result[1] = split[1];
        } else if (split.length > 1) {
            result[0] = "";
            for (int i = 0; i < split.length - 1; i++) {
                result[0] += split[i];
            }
            result[1] = split[split.length - 1];
        }
        return result;
    }


}
