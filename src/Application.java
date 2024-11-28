import Struct.MusicPlayer;
import Iterator.IMusicIterator;
import Collections.SpotifyCollection;
import Collections.IMusicCollection;

public class Application {
    private IMusicCollection musicCollection;
    private MusicPlayer musicPlayer;

    public void config() {
        this.musicCollection = new SpotifyCollection();
        this.musicPlayer = new MusicPlayer();
    }

    public void playPlaylist(String playlistName) {
        IMusicIterator iterator = musicCollection.createPlaylistIterator(playlistName);
        musicPlayer.play(iterator);
    }

    public void playArtist(String artistName) {
        IMusicIterator iterator = musicCollection.createArtistIterator(artistName);
        musicPlayer.play(iterator);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.config();

        // Tocar todas as músicas de uma playlist
        System.out.println("\nPlaying playlist 'Rock Hits':");
        app.playPlaylist("Rock Hits");

        System.out.println("\nPlaying playlist 'Pop Favorites':");
        app.playPlaylist("Pop Favorites");

        // Tocar todas as músicas de um artista
        System.out.println("\nPlaying artist 'Queen':");
        app.playArtist("Queen");
    }
}
