package bibliotheque.mvp.model;

import bibliotheque.metier.Ouvrage;

import java.util.List;

public interface DAOOuvrage {
    Ouvrage addOuvrage(Ouvrage ouv);

    boolean removeOuvrage(Ouvrage ouv);

    List<Ouvrage> getOuvrages();

    Ouvrage majOuvrage(Ouvrage ouv);
}
