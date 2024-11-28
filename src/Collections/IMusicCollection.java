package Collections;

import Iterator.IMusicIterator;

public interface IMusicCollection {

        IMusicIterator createPlaylistIterator(String playlistName);
        IMusicIterator createArtistIterator(String artistName);

}
