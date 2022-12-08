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
import java.util.ArrayList;

public class Tracklister {
    private String website;
    private ArrayList<Song> songs = new ArrayList<Song>();
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
        //System.out.println(doc.html());

        extractData(doc);

        //writeHTMLFile(doc.html(), "wholeSite");
    }

    public void shietttt() throws IOException {
        try {
            File file = new File("fileName.html");
            extractData(Jsoup.parse(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void extractData(Document doc) {
        Element parent = doc.getElementById("tlTab");
        Elements songs = parent.children();
        songs = songs.select("[class^=tlpTog bItm tlpItem]");
        this.songs.clear();

        for (Element el : songs) {
            int track;
            String start;
            String artists = null;
            String title = null;
            int duration = -1;
            String publisher = null;
            String genre = null;
            String type = null;

            for (Element curr : el.getElementsByTag("meta")) {
                String itemprop = curr.attr("itemprop");
                if (itemprop.equals("duration")) {
                    duration = getDurationOf(curr.attr("content"));
                } else if (itemprop.equals("publisher")) {
                    publisher = curr.attr("content");
                } else if (itemprop.equals("genre")) {
                    genre = curr.attr("content");
                } else if (itemprop.equals("name")) {
                    String[] artistsAndTitle = getArtistsAndTitle(
                            curr.attr("content"));
                    artists = artistsAndTitle[0];
                    title = artistsAndTitle[1];
                }
            }
            start = el.select("[id^=cue]").text();
            String tracc = el.select("[id$=tracknumber_value]").text();
            try {
                track = Integer.parseInt(tracc);
            } catch (Exception e){
                Song curr = this.songs.get(this.songs.size()-1);
                track = curr.getTrack();
                type = "Mashup";
            }

            this.songs.add(new Song(
                    artists != null ? artists : "ID",
                    title != null ? title : "ID",
                    track,
                    duration, //unnecessary?
                    start,
                    publisher,
                    genre,
                    type));
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

    private static int getDurationOf(String intput) {
        int duration = -1;
        if (intput != null) {
            String[] split = intput.split("M");
            duration = Integer.parseInt(split[0].substring(2)) * 60
                    + Integer.parseInt(split[1].substring(0, split[1].length() - 1));
        }
        return duration;
    }

    public void printSongs() {
        for (Song song : this.songs) {
            System.out.println(song.toString());
        }
    }

}
