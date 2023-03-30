public class Song {
    private String artists;
    private String title;
    private final int track;
    private final int duration;
    private final String start; //mm:ss:msms
    private final String publisher;

    private final String genre;

    private final String type;

    private int MashupCount = 0;

    public Song(String artists, String title, int track, int duration, String start, String publisher, String genre, String type) {
        this.artists = artists;
        this.title = title;
        this.track = track;
        this.duration = duration;
        this.start = start;
        this.publisher = publisher;
        this.genre = genre;
        this.type = type;
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

    public int getMashupCount() {
        return MashupCount;
    }

    public String setArtists(String artists){
        String trash = this.artists;
        this.artists = artists;
        return trash;
    }

    public String setTitle(String title){
        String trash = this.title;
        this.title = title;
        return trash;
    }

    public void increaseMashupCount(){
        this.MashupCount++;
    }

}
