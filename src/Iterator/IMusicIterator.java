package Iterator;

import Struct.Music;

// Interface comum para todos os iteradores
public interface IMusicIterator {
    Music getNext();
    boolean hasMore();
}
