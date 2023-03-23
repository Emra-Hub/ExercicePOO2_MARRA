package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;

import java.util.ArrayList;
import java.util.List;

public class AuteurModel implements DAOAuteur {
    private List<Auteur> auteurs = new ArrayList<>();

    public AuteurModel() {
        populate();
    }

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
    public Auteur updateAuteur(Auteur aut) {
        int p = auteurs.indexOf(aut);
        if (p < 0) return null;
        auteurs.set(p, aut);
        return aut;
    }

    @Override
    public Auteur readAuteur(String nom, String prenom, String nationalite) {
        for (Auteur aut : auteurs) {
            if (aut.getNom().equals(nom) && aut.getPrenom().equals(prenom) && aut.getNationalite().equals(nationalite))
                return aut;
        }
        return null;
    }

    @Override
    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    private void populate() {

    }
}
