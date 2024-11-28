package Collections;

import Struct.Music;
import Struct.Playlist;
import Iterator.IMusicIterator;
import Iterator.SpotifyIterator;

import java.util.ArrayList;
import java.util.List;

public class SpotifyCollection implements IMusicCollection {
    private final List<Playlist> playlists;
    private final List<Music> musicCollection;

    public SpotifyCollection() {
        // Inicializa com algumas playlists e músicas
        playlists = new ArrayList<>();
        musicCollection = new ArrayList<>();

        // Adicionando playlists e músicas fictícias
        playlists.add(new Playlist("Rock Hits"));
        playlists.add(new Playlist("Pop Favorites"));

        musicCollection.add(new Music("Bohemian Rhapsody", "Queen"));
        musicCollection.add(new Music("Shape of You", "Ed Sheeran"));
        musicCollection.add(new Music("Stairway to Heaven", "Led Zeppelin"));
        musicCollection.add(new Music("Blinding Lights", "The Weeknd"));
    }

    // Cria um iterador de playlist
    @Override
    public IMusicIterator createPlaylistIterator(String playlistName) {
        return new SpotifyIterator(this, playlistName, "playlist");
    }

    // Cria um iterador de artista
    @Override
    public IMusicIterator createArtistIterator(String artistName) {
        return new SpotifyIterator(this, artistName, "artist");
    }

    // Métodos para obter playlists e músicas
    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public List<Music> getMusicCollection() {
        return musicCollection;
    }
}
