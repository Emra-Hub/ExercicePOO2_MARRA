package bibliotheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Ouvrage {
    protected String titre;
    protected byte ageMin;
    protected LocalDate dateParution;
    protected TypeOuvrage typeOuvrage;
    protected double prixLocation ;
    protected String langue;
    protected String genre;
    protected List<Exemplaire> lex = new ArrayList<>();
    protected List<Auteur> laut = new ArrayList<>();

    public Ouvrage(String titre, byte ageMin, LocalDate dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre) {
        this.titre = titre;
        this.ageMin = ageMin;
        this.dateParution = dateParution;
        this.typeOuvrage = typeOuvrage;
        this.prixLocation = prixLocation;
        this.langue = langue;
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public byte getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(byte ageMin) {
        this.ageMin = ageMin;
    }

    public LocalDate getDateParution() {
        return dateParution;
    }

    public void setDateParution(LocalDate dateParution) {
        this.dateParution = dateParution;
    }

    public TypeOuvrage getTypeOuvrage() {
        return typeOuvrage;
    }

    public void setTypeOuvrage(TypeOuvrage typeOuvrage) {
        this.typeOuvrage = typeOuvrage;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Exemplaire> getLex() {
        return lex;
    }

    public void setLex(List<Exemplaire> lex) {
        this.lex = lex;
    }

    public List<Auteur> getLaut() {
        return laut;
    }

    public void setLaut(List<Auteur> laut) {
        this.laut = laut;
    }

    @Override
    public String toString() {
        return "Ouvrage{" +
                "titre ='" + titre + '\'' +
                ", ageMin =" + ageMin +
                ", dateParution =" + dateParution +
                ", typeOuvrage =" + typeOuvrage +
                ", prixLocation =" + prixLocation +
                ", langue ='" + langue + '\'' +
                ", genre ='" + genre + '\'' +
                '}';
    }

    public List<Exemplaire> listerExemplaires() {
        //TODO coder liste exemplaires
        return null;
    }

    public List<Exemplaire> listerExemplaires(boolean enLocation) {
        //TODO coder liste exemplaires en location
        return null;
    }

    public abstract double amendeRetard(int njours);
}
