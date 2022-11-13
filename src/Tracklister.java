import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Tracklister {
    private String website;
    private String[] data;
    private static String title;

    public Tracklister(String website) {
        this.website = website;
    }

    public static void getData(String Website) throws IOException {
        Document doc = Jsoup.connect(Website)
                .timeout(30000)
                .followRedirects(true)
                .get();
        String url = "http://t.co/i5dE1K4vSs";
        Connection.Response response = Jsoup.connect(url).followRedirects(true).execute();
        writeHTMLFile(doc.html());
        System.out.println(doc.html());
    }

    public static void getDataUwu(String Website) throws IOException {
        //TODO
    }

    public static void writeHTMLFile(String input){
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
