package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LecteurModel implements DAOLecteur, SpecialLecteur {
    private int numcli =0;
    private List<Lecteur> lecteurs = new ArrayList<>();

    public LecteurModel() {
        populate();
    }

    @Override
    public Lecteur addLecteur(Lecteur lec) {
        boolean present= lecteurs.contains(lec);
        if(!present){
            numcli++;
            lec.setNumlecteur(numcli);
            lecteurs.add(lec);
            return lec;
        }
        else return null;
    }

    @Override
    public boolean removeLecteur(Lecteur lec) {
        return lecteurs.remove(lec);
    }

    @Override
    public Lecteur updateLecteur(Lecteur lec) {
        int p = lecteurs.indexOf(lec);
        if (p < 0) return null;
        lecteurs.set(p, lec);//remplacement du lecteur à la même position
        return lec;
    }

    @Override
    public Lecteur readLecteur(int idLecteur) {
        for (Lecteur l : lecteurs) {
            if (l.getNumlecteur() == idLecteur) return l;
        }
        return null;
    }

    @Override
    public List<Lecteur> getLecteurs() {
        return lecteurs;
    }

    private void populate(){
        Lecteur lec = new Lecteur(0,"Dupont","Jean", LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        addLecteur(lec);
        lec = new Lecteur(0,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        addLecteur(lec);
    }

    @Override
    public List<Exemplaire> exemplairesEnLocation(Lecteur l) {
        return l.listerExemplairesEnLocation();
    }

    @Override
    public List<Exemplaire> exemplairesLoues(Lecteur l) {
        return new ArrayList<>(l.listerExemplairesLoues());
    }
}