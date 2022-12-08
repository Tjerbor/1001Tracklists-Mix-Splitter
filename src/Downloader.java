public class Downloader {
    private String URL;
    private String fileName;
    private String filePath;

    public Downloader(String URL) {
        this.URL = URL;
    }

    public Downloader() {
    }

    public void download(String URL) throws IllegalStateException {
        if (URL == null) {
            throw new IllegalStateException("No URL has been given.");
        }
        this.setURL(URL);

        if (Dependencies.getYtDlp()) {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(
                    "yt-dlp.exe",
                    "--extract-audio",
                    "--audio-quality 0",
                    this.URL
            );
        }
    }

    public void download() throws IllegalStateException {
        if(this.URL == null){
            throw new IllegalStateException("No URL has been set.");
        }
        download(this.URL);
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
