package bibliotheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lecteur {
    private int numLecteur;
    private String nom, prenom;
    private LocalDate dateNaiss;
    private String mail, adresse, tel;
    private List<Location> llou = new ArrayList<>();

    public Lecteur(int numLecteur, String nom, String prenom, LocalDate dateNaiss, String mail, String adresse, String tel) {
        this.numLecteur = numLecteur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.mail = mail;
        this.adresse = adresse;
        this.tel = tel;
    }

    public int getNumLecteur() {
        return numLecteur;
    }

    public void setNumLecteur(int numLecteur) {
        this.numLecteur = numLecteur;
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

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Location> getLlou() {
        return llou;
    }

    public void setLlou(List<Location> llou) {
        this.llou = llou;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecteur lecteur = (Lecteur) o;
        return numLecteur == lecteur.numLecteur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numLecteur);
    }

    @Override
    public String toString() {
        return "Lecteur{" +
                "numLecteur =" + numLecteur +
                ", nom ='" + nom + '\'' +
                ", prenom ='" + prenom + '\'' +
                ", dateNaiss =" + dateNaiss +
                ", mail ='" + mail + '\'' +
                ", adresse ='" + adresse + '\'' +
                ", tel ='" + tel + '\'' +
                '}';
    }

    public List<Exemplaire> listerExemplairesEnLocation() {
        //TODO coder liste des exemplaires en location
        return null;
    }

    public List<Exemplaire> listerExemplairesLoues() {
        //TODO coder liste des exemplaires déjà loués
        return null;
    }
}
