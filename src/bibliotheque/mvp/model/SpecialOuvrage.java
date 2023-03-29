package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.List;

public interface SpecialOuvrage {
    public List<Exemplaire> exemplaires(Ouvrage o);
    public List<Exemplaire> exemplaires(Ouvrage o, boolean enLocation);
    public double amandeRetard(Ouvrage o, int njours);
}
