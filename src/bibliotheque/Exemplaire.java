package bibliotheque;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exemplaire {
    private String matricule;
    private String descriptionEtat;
    private Rayon rayon;
    private Ouvrage ouvrage;
    private List<Location> lloc = new ArrayList<>();


    public Exemplaire(String matricule, String descriptionEtat, Ouvrage ouvrage) {
        this.matricule = matricule;
        this.descriptionEtat = descriptionEtat;
        this.ouvrage = ouvrage;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setDescriptionEtat(String descriptionEtat) {
        this.descriptionEtat = descriptionEtat;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }

    public List<Location> getLloc() {
        return lloc;
    }

    public void setLloc(List<Location> lloc) {
        this.lloc = lloc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return Objects.equals(matricule, that.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "matricule ='" + matricule + '\'' +
                ", descriptionEtat ='" + descriptionEtat + '\'' +
                ", rayon =" + rayon +
                ", ouvrage =" + ouvrage +
                '}';
    }

    public void modifierEtat(String etat) {
        //TODO coder méthode modifier état
    }

    public Lecteur lecteurActuel() {
        //TODO coder le lecteur
        return null;
    }

    public List<Lecteur> lecteurs() {
        //TODO coder les lecteurs
        return null;
    }

    public void envoiMailLecteurActuel(Mail mail) {
        //TODO coder mail du lecteur
    }

    public void envoiMailLecteurs(Mail mail) {
        //TODO coder liste mails des lecteurs
    }

    public boolean enRetard() {
        //TODO coder méthode enRetard
        return false;
    }

    public int joursRetard() {
        //TODO coder méthode joursRetard
        return 0;
    }

    public boolean enLocation() {
        //TODO coder méthode enLocation
        return false;
    }
}
