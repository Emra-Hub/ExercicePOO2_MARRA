package bibliotheque.mvp.model;

import bibliotheque.metier.*;

import java.util.ArrayList;
import java.util.List;

public class AuteurModelV2 implements DAO<Auteur>, SpecialAuteur {
    private List<Auteur> laut = new ArrayList<>();

    public AuteurModelV2() {
        populate();
    }

    @Override
    public Auteur add(Auteur auteur) {
        if (laut.contains(auteur)) return null;
        laut.add(auteur);
        return auteur;
    }

    @Override
    public boolean remove(Auteur auteur) {
        return laut.remove(auteur);
    }

    @Override
    public Auteur update(Auteur auteur) {
        int p = laut.indexOf(auteur);
        if (p < 0) return null;
        laut.set(p, auteur);
        return auteur;
    }

    @Override
    public Auteur read(Auteur rech) {
        int p = laut.indexOf(rech);
        if (p < 0) return null;
        return laut.get(p);
    }

    @Override
    public List<Auteur> getAll() {
        return laut;
    }

    private void populate() {
        try {
            Auteur a = new Auteur("Verne","Jules","France");
            add(a);
            a = new Auteur("Spielberg","Steven","USA");
            add(a);
        }catch(Exception e) {
            System.out.println("Erreur survenue : "+e.getMessage());
        }
    }

    @Override
    public List<Ouvrage> ouvrages(Auteur a) {
        return a.listerOuvrages();
    }

    @Override
    public List<Ouvrage> ouvragesParTypeOuvrage(Auteur a, TypeOuvrage to) {
        return a.listerOuvrages(to);
    }

    @Override
    public List<Livre> ouvragesParTypeLivre(Auteur a, TypeLivre tl) {
        return a.listerLivres(tl);
    }

    @Override
    public List<Ouvrage> ouvragesParGenre(Auteur a, String genre) {
        return a.listerOuvrages(genre);
    }
}
