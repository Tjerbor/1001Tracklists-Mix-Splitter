import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Splitter {
    public static void createCUE(ArrayList<Song> songs, String filename) {
        String result = String.format("FILE \"%s\" WAVE", filename);
        String tab = "  "; //2 Spaces
        String tab2 = "    "; //4 Spaces

        int track = 0;
        for (Song song : songs) {
            result += String.format("\n%sTRACK %s AUDIO",tab,++track);
            result += String.format("\n%sTITLE \"%s\"",tab2,song.getTitle());
            result += String.format("\n%sPERFORMER \"%s\"",tab2,song.getArtists());
            result += String.format("\n%sINDEX 01 %s:00",tab2,song.getStart());
        }

        writeCUEFile(result,filename);
    }

    private static void writeCUEFile(String input, String fileName) {
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        try {
            fWriter = new FileWriter(fileName + ".cue");
            writer = new BufferedWriter(fWriter);
            writer.write(input);
            writer.newLine(); //this is not actually needed for html files - can make your code more readable though
            writer.close(); //make sure you close the writer object
        } catch (Exception e) {
            //catch any exceptions here
        }
    }
}
