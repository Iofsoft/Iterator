package Iterator;

import Struct.Music;
import Struct.Playlist;
import Collections.SpotifyCollection;

public class SpotifyIterator implements IMusicIterator {
    private final SpotifyCollection spotify;
    private String playlistName;
    private String artistName;
    private final String type;
    private int currentPosition;

    // Construtor para inicializar o iterador
    public SpotifyIterator(SpotifyCollection spotify, String name, String type) {
        this.spotify = spotify;
        this.type = type;
        if ("playlist".equals(type)) {
            this.playlistName = name;
        } else if ("artist".equals(type)) {
            this.artistName = name;
        }
    }

    @Override
    public Music getNext() {
        if (hasMore()) {
            Music music = null;
            if ("playlist".equals(type)) {
                // Itera sobre as playlists e encontra a playlist que corresponde ao nome
                for (Playlist playlist : spotify.getPlaylists()) {
                    if (playlist.getName().equals(playlistName)) {
                        music = playlist.getMusicList().get(currentPosition);
                        break;
                    }
                }
            } else if ("artist".equals(type)) {
                // Itera sobre as músicas e encontra as que correspondem ao artista
                for (Music musicItem : spotify.getMusicCollection()) {
                    if (musicItem.getArtist().equals(artistName)) {
                        if (currentPosition == 0) {
                            music = musicItem;
                            break;
                        }
                        currentPosition--;
                    }
                }
            }

            currentPosition++;
            return music;
        }
        return null;
    }

    @Override
    public boolean hasMore() {
        // Verifica se há mais músicas, iterando diretamente sem cache
        if ("playlist".equals(type)) {
            for (Playlist playlist : spotify.getPlaylists()) {
                if (playlist.getName().equals(playlistName)) {
                    return currentPosition < playlist.getMusicList().size();
                }
            }
        } else if ("artist".equals(type)) {
            int count = 0;
            for (Music music : spotify.getMusicCollection()) {
                if (music.getArtist().equals(artistName)) {
                    count++;
                }
            }
            return currentPosition < count;
        }
        return false;
    }
}
