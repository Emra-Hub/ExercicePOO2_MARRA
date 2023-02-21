package bibliotheque;

import java.time.LocalDate;

public class Location {
    private LocalDate dateLoc, dateRestitution;
    private double amende;
    private Exemplaire exemplaire;
    private Lecteur loueur;

    public Location(LocalDate dateLoc, LocalDate dateRestitution, double amende, Exemplaire exemplaire, Lecteur loueur) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.amende = amende;
        this.exemplaire = exemplaire;
        this.exemplaire.getLloc().add(this);
        this.loueur = loueur;
        this.loueur.getLlou().add(this);
    }

    public LocalDate getDateLoc() {
        return dateLoc;
    }

    public void setDateLoc(LocalDate dateLoc) {
        this.dateLoc = dateLoc;
    }

    public LocalDate getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(LocalDate dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public double getAmende() {
        return amende;
    }

    public void setAmende(double amende) {
        this.amende = amende;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public Lecteur getLoueur() {
        return loueur;
    }

    public void setLoueur(Lecteur loueur) {
        this.loueur = loueur;
    }

    @Override
    public String toString() {
        return "Location{" +
                "dateLoc =" + dateLoc +
                ", dateRestitution =" + dateRestitution +
                ", amende =" + amende +
                ", exemplaire =" + exemplaire +
                ", loueur =" + loueur +
                '}';
    }

    public void calculerAmende() {
        //TODO coder la méthode calculerAmende
    }

    public void enregistrerRetour() {
        //TODO coder la méthode enregistrerRetour
    }
}
