package bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Auteur {
    private String nom, prenom, nationalite;
    private List<Ouvrage> ouvrages = new ArrayList<>();

    public Auteur(String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
    }

    public void add (Ouvrage ouv){
        getOuvrages().add(ouv);
        ouv.getAuteurs().add(this);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public void setOuvrages(List<Ouvrage> ouvrages) {
        this.ouvrages = ouvrages;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "nom ='" + nom + '\'' +
                ", prenom ='" + prenom + '\'' +
                ", nationalite ='" + nationalite + '\'' +
                '}';
    }
}
