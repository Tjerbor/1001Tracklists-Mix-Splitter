import java.io.IOException;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) throws IOException {
        supressWarnings();
        Tracklister tr = new Tracklister();

        //tr.shietttt();
        tr.scrape("https://www.1001tracklists.com/tracklist/16l4c32t/curbi-alternative-arena-creamfields-chile-2022-11-06.html");
        tr.printSongs();


        /*
        Tracklister tracks = new Tracklister("https://www.1001tracklists.com/track/18uj2vdx/john-summit-show-me/index.html");
        String url = "https://www.1001tracklists.com/tracklist/nsgpmht/curbi-tape-06-2021-03-12.html";
        tracks.scrape(url);
        System.out.println("uwu");
        */

	 //https://www.1001tracklists.com/tracklist/nsgpmht/curbi-tape-06-2021-03-12.html
    }

    public static void supressWarnings(){
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    }
}
