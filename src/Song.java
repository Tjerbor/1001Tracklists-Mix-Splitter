public class Song {
    private final String artists;
    private final String title;
    private final int track;
    private final double duration;
    private final String start;
    private final String label;

    public Song(String artists, String title, int track, double duration, String start, String label) {
        this.artists = artists;
        this.title = title;
        this.track = track;
        this.duration = duration;
        this.start = start;
        this.label = label;
    }

    public Song(String artists, String title, int track, double duration, String start) {
        this(artists, title, track, duration, start, "N/A");
    }
}
