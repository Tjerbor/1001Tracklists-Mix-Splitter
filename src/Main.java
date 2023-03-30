import java.io.IOException;
import java.util.logging.Level;

public class Main {
    static String tracklist = "https://www.1001tracklists.com/tracklist/16l4c32t/curbi-alternative-arena-creamfields-chile-2022-11-06.html";
    static String stream = "https://www.youtube.com/watch?v=qSdJTjWE9Do";


    public static void main(String[] args) throws IOException {
        //Prework
        loadDependecies();
        supressWarnings();

        //Getting Tracklist
        Tracklister tr = new Tracklister();
        tr.scrape(tracklist);
        tr.printSongs();

        //Downloading audio
        //Downloader downloader = new Downloader(stream, tr.getTitle());
        //downloader.download();

        /*
        Tracklister tracks = new Tracklister("https://www.1001tracklists.com/track/18uj2vdx/john-summit-show-me/index.html");
        String url = "https://www.1001tracklists.com/tracklist/nsgpmht/curbi-tape-06-2021-03-12.html";
        tracks.scrape(url);
        System.out.println("uwu");
        */

        Splitter.createCUE(tr.getSongs(), tr.getTitle() + ".opus");

        //https://www.1001tracklists.com/tracklist/nsgpmht/curbi-tape-06-2021-03-12.html
    }

    public static void supressWarnings() {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    }

    public static void loadDependecies() {
        //TODO
    }
}
