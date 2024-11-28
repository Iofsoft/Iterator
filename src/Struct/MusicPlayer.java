package Struct;

import Iterator.IMusicIterator;

public class MusicPlayer {
    public void play(IMusicIterator iterator) {
        while (iterator.hasMore()) {
            Music music = iterator.getNext();
            System.out.println("Playing: " + music);
        }
    }
}
