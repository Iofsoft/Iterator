package Struct;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final String name;
    private final List<Music> musicList;

    public Playlist(String name) {
        this.name = name;
        this.musicList = new ArrayList<>();
        // Adicionando músicas fictícias à playlist
        musicList.add(new Music("Bohemian Rhapsody", "Queen"));
        musicList.add(new Music("Shape of You", "Ed Sheeran"));
    }

    public String getName() {
        return name;
    }

    public List<Music> getMusicList() {
        return musicList;
    }
}
