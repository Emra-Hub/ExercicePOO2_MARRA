package bibliotheque.mvp.model;

import bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.List;

public class OuvrageModel implements DAOOuvrage {
    List<Ouvrage> ouvrages = new ArrayList<>();

    @Override
    public Ouvrage addOuvrage(Ouvrage ouv) {
        boolean present = ouvrages.contains(ouv);
        if(!present){
            ouvrages.add(ouv);
            return ouv;
        }
        else return null;
    }

    @Override
    public boolean removeOuvrage(Ouvrage ouv) {
        return ouvrages.remove(ouv);
    }

    @Override
    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    @Override
    public Ouvrage majOuvrage(Ouvrage ouv) {
        boolean present = ouvrages.contains(ouv.getTitre());
        if(!present){
            return ouv;
        }
        else return null;
    }
}
