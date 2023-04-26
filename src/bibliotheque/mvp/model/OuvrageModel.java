package bibliotheque.mvp.model;

import bibliotheque.metier.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OuvrageModel implements DAOOuvrage, SpecialOuvrage {
    List<Ouvrage> ouvrages = new ArrayList<>();

    public OuvrageModel() { populate(); }

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
    public Ouvrage updateOuvrage(Ouvrage ouv) {
        int p = ouvrages.indexOf(ouv);
        if (p < 0) return null;
        ouvrages.set(p,ouv);
        return ouv;
    }

    @Override
    public Ouvrage readOuvrage(String title) {
        for(Ouvrage o : ouvrages) {
            if(o.getTitre().equals(title)) return o;
        }
        return null;
    }

    @Override
    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    private void populate() {
        try {
            Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350, TypeLivre.ROMAN,"histoire de sous-marin");
            ouvrages.add(l);
            Exemplaire e = new Exemplaire("m12","état neuf",l);
            Exemplaire f = new Exemplaire("v2O","état neuf",l);
            DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l, LocalTime.of(2,0,0),(byte)2);
            ouvrages.add(d);
            CD c = new CD("The Compil 2023",1,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,LocalTime.of(1,40,0));
            ouvrages.add(c);
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
