public class Song {
    private final String artists;
    private final String title;
    private final int track;
    private final int duration;
    private final String start;
    private final String publisher;

    private final String genre;

    private String type;

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
        String result = "Song{";
        if (this.type != null && this.type.equals("Mashup")) {
            result += "w/" + track + ": ";
        } else {
            result += track + ": ";
        }
        result += "artists='" + artists + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", start='" + start + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                '}';

        return result;
    }

    public String getArtists() {
        return artists;
    }

    public String getTitle() {
        return title;
    }

    public int getTrack() {
        return track;
    }

    public int getDuration() {
        return duration;
    }

    public String getStart() {
        return start;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
