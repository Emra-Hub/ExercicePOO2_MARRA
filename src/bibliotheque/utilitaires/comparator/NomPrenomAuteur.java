package bibliotheque.utilitaires.comparator;

import bibliotheque.metier.Auteur;

import java.util.Comparator;

public class NomPrenomAuteur implements Comparator<Auteur> {
    @Override
    public int compare(Auteur o1, Auteur o2) {
        int nameComparison = o1.getNom().compareTo(o2.getNom());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return o1.getPrenom().compareTo(o2.getPrenom());
    }
}
