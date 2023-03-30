public class Settings {
    private static boolean YT_DLP = true; //Youtube DL(P)
    private static boolean split_Mashups = true; //when tracklist is created or file is split Mashups get their own file if they have their own starting time

    public static boolean getYtDlp() {
        return YT_DLP;
    }

    public static boolean isSplit_Mashups() {
        return split_Mashups;
    }
}
