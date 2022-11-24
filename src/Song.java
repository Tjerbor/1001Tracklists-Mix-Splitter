public class Song {
    private final String artists;
    private final String title;
    private final int track;
    private final int duration;
    private final String start;
    private final String publisher;

    private final String genre;

    public Song(String artists, String title, int track, int duration, String start, String publisher, String genre) {
        this.artists = artists;
        this.title = title;
        this.track = track;
        this.duration = duration;
        this.start = start;
        this.publisher = publisher;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song{" +
                track + ": " +
                "artists='" + artists + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", start='" + start + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
