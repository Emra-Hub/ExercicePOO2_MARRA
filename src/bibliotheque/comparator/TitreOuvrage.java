package bibliotheque.comparator;

import bibliotheque.metier.Ouvrage;

import java.util.Comparator;

public class TitreOuvrage implements Comparator<Ouvrage> {
    @Override
    public int compare(Ouvrage o1, Ouvrage o2) {
        return o1.getTitre().compareTo(o2.getTitre());
    }
}
