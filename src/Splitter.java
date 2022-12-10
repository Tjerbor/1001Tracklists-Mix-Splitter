import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Splitter {
    public static void createCUE(ArrayList<Song> songs, String title) {
        String result = String.format("REM COMMENT \"%s\"",title) +
                String.format("\nFILE \"%s\" WAVE", title);
        String tab = "  "; //2 Spaces
        String tab2 = "    "; //4 Spaces

        int track = 0;
        for (Song song : songs) {
            result += String.format("\n%sTRACK %s AUDIO",tab,++track);
            result += String.format("\n%sTITLE \"%s\"",tab2,song.getTitle());
            result += String.format("\n%sPERFORMER \"%s\"",tab2,song.getArtists());
            result += String.format("\n%sINDEX 01 %s",tab2,song.getStart());
        }

        writeCUEFile(result,title);
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
