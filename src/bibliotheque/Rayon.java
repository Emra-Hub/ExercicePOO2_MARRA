package bibliotheque;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rayon {
    private String codeRayon, genre;
    private List<Exemplaire> lex = new ArrayList<>();

    public Rayon(String codeRayon, String genre) {
        this.codeRayon = codeRayon;
        this.genre = genre;
    }

    public String getCodeRayon() {
        return codeRayon;
    }

    public void setCodeRayon(String codeRayon) {
        this.codeRayon = codeRayon;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rayon rayon = (Rayon) o;
        return Objects.equals(codeRayon, rayon.codeRayon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeRayon);
    }

    @Override
    public String toString() {
        return "Rayon{" +
                "codeRayon ='" + codeRayon + '\'' +
                ", genre ='" + genre + '\'' +
                '}';
    }

    public void addExemplaire(Exemplaire e) {
        lex.add(e);
        e.setRayon(this);
    }

    public List<Exemplaire> listerExamplaires() {
        //TODO coder liste des exemplaires
        return null;
    }
}
