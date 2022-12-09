import java.io.File;
import java.io.IOException;

public class Downloader {
    private String URL;
    private String title;
    private String fileName;
    private String filePath;

    public Downloader(String URL, String title) {
        this.URL = URL;
        this.title = title;
    }

    public Downloader() {
    }

    public void download(String URL, String title) throws IllegalStateException {
        if (URL == null) {
            throw new IllegalStateException("No URL has been given.");
        }
        this.setURL(URL);

        String projectPath = System.getProperty("user.dir");

        if (Dependencies.getYtDlp()) {
            try {
                String[] cmd = {
                        "cmd",
                        "/c",
                        "cd",
                        projectPath,
                        "&&",
                        "start",
                        "/wait",
                        "yt-dlp.exe",
                        "--embed-chapters",
                        "--extract-audio",
                        "-o",
                        String.format("\"%s%s\"", title,".%(ext)s"),
                        this.URL
                };
                Runtime.getRuntime().exec(cmd);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void download() throws IllegalStateException {
        if (this.URL == null) {
            throw new IllegalStateException("No URL has been set.");
        }
        download(this.URL, this.title);
    }

    public String getURL() {
        return URL;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
