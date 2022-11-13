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
        Document doc = Jsoup.connect(Website).ignoreContentType(true)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .referrer("http://www.google.com")
                .cookie("euconsent-v2", "CPiH4tgPiH4tgDlBHBDECpCgAAAAAH_AACiQJHwAASPAJMNW4gC7EscCbaMIoEQIwrCQ6gUAFFAMLRAYQOrgp2VwE-sIEACAUARgRAhwBRgwCAAACAJCIgJAjwQCAAiAQAAgAVCIQAEbAIKACwMAgAFANCxRigCECQgyICIpTAgIkSCgnsqEEoP9DTCEOssAKDR_xUICJQAhWBEJCwchwRICXiyQLMUb5ACMEKAUSoVqAQAA")
                .timeout(120000)
                .followRedirects(true)
                .get();
        writeHTMLFile(doc.html());
        System.out.println(doc.html());
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
