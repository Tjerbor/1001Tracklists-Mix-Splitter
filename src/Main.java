import java.io.IOException;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) throws IOException {
        //Prework
        loadDependecies();
        supressWarnings();

        //Getting Tracklist
        Tracklister tr = new Tracklister();
        tr.scrape("https://www.1001tracklists.com/tracklist/1ng9kgjk/curbi-tape-07.-special-set-for-monstercattv-2021-05-29.html");
//        tr.printSongs();

        //Downloading audio
        Downloader downloader = new Downloader("https://www.youtube.com/watch?v=Rm_tI11eXXg", tr.getTitle());
        downloader.download();

        /*
        Tracklister tracks = new Tracklister("https://www.1001tracklists.com/track/18uj2vdx/john-summit-show-me/index.html");
        String url = "https://www.1001tracklists.com/tracklist/nsgpmht/curbi-tape-06-2021-03-12.html";
        tracks.scrape(url);
        System.out.println("uwu");
        */

        Splitter.createCUE(tr.getSongs(), tr.getTitle() + ".opus");

	 //https://www.1001tracklists.com/tracklist/nsgpmht/curbi-tape-06-2021-03-12.html
    }

    public static void supressWarnings(){
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    }

    public static void loadDependecies(){
        //TODO
    }
}
