package bibliotheque.comparator;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Lecteur;

import java.util.Comparator;

public class NomPrenomLecteur implements Comparator<Lecteur> {
    @Override
    public int compare(Lecteur o1, Lecteur o2) {
        int nameComparison = o1.getNom().compareTo(o2.getNom());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return o1.getPrenom().compareTo(o2.getPrenom());
    }
}
