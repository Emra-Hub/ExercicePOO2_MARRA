package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;

import java.util.ArrayList;
import java.util.List;

public class AuteurModel implements DAOAuteur {
    private List<Auteur> auteurs = new ArrayList<>();

    @Override
    public Auteur addAuteur(Auteur aut) {
        boolean present = auteurs.contains(aut);
        if(!present){
            auteurs.add(aut);
            return aut;
        }
        else return null;
    }

    @Override
    public boolean removeAuteur(Auteur aut) {
        return auteurs.remove(aut);
    }

    @Override
    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    @Override
    public Auteur majAuteur(Auteur aut) {
        boolean present = auteurs.contains(aut.getNom());
        if(!present){
            return aut;
        }
        else return null;
    }
}
