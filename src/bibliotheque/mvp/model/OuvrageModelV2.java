package bibliotheque.mvp.model;

import bibliotheque.metier.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OuvrageModelV2 implements DAO<Ouvrage>, SpecialOuvrage {
    private List<Ouvrage> louv = new ArrayList<>();

    public OuvrageModelV2() {
        populate();
    }

    @Override
    public Ouvrage add(Ouvrage ouvrage) {
        if (louv.contains(ouvrage)) return null;
        louv.add(ouvrage);
        return ouvrage;
    }

    @Override
    public boolean remove(Ouvrage ouvrage) {
        return louv.remove(ouvrage);
    }

    @Override
    public Ouvrage update(Ouvrage ouvrage) {
        int p = louv.indexOf(ouvrage);
        if (p < 0) return null;
        louv.set(p, ouvrage);
        return ouvrage;
    }

    @Override
    public Ouvrage read(Ouvrage rech) {
        int p = louv.indexOf(rech);
        if (p < 0) return null;
        return louv.get(p);
    }

    @Override
    public List<Ouvrage> getAll() {
        return louv;
    }

    private void populate() {
        try {
            Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350, TypeLivre.ROMAN,"histoire de sous-marin");
            louv.add(l);
            Exemplaire e = new Exemplaire("m12","état neuf",l);
            Exemplaire f = new Exemplaire("v2O","état neuf",l);
            DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l, LocalTime.of(2,0,0),(byte)2);
            louv.add(d);
            CD c = new CD("The Compil 2023",1,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,LocalTime.of(1,40,0));
            louv.add(c);
        } catch(Exception e) {
            System.out.println("Erreur survenue : "+e.getMessage());
        }
    }

    @Override
    public List<Exemplaire> exemplaires(Ouvrage o) {
        return o.listerExemplaires();
    }

    @Override
    public List<Exemplaire> exemplaires(Ouvrage o, boolean enLocation) {
        return o.listerExemplaires(enLocation);
    }

    @Override
    public double amandeRetard(Ouvrage o, int njours) {
        return o.amendeRetard(njours);
    }
}
