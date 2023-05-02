package bibliotheque.comparator;

import bibliotheque.metier.Rayon;

import java.util.Comparator;

public class GenreRayon implements Comparator<Rayon> {
    @Override
    public int compare(Rayon o1, Rayon o2) {
        return o1.getGenre().compareToIgnoreCase(o2.getGenre());
    }
}
