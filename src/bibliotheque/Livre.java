package bibliotheque;

import java.time.LocalDate;
import java.util.Objects;

public class Livre extends Ouvrage{
    private String isbn;
    private int nombrePages;
    private TypeLivre typeLivre;
    private String resume;

    public Livre(String titre, byte ageMin, LocalDate dateParution, double prixLocation, String langue, String genre, String isbn, int nombrePages, TypeLivre typeLivre, String resume) {
        super(titre, ageMin, dateParution, TypeOuvrage.LIVRE, prixLocation, langue, genre);
        this.isbn = isbn;
        this.nombrePages = nombrePages;
        this.typeLivre = typeLivre;
        this.resume = resume;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    public TypeLivre getTypeLivre() {
        return typeLivre;
    }

    public void setTypeLivre(TypeLivre typeLivre) {
        this.typeLivre = typeLivre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return Objects.equals(isbn, livre.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Livre{" +
                "isbn ='" + isbn + '\'' +
                ", nombrePages =" + nombrePages +
                ", typeLivre =" + typeLivre +
                ", resume ='" + resume + '\'' +
                ", titre ='" + titre + '\'' +
                ", dateParution =" + dateParution +
                ", typeOuvrage =" + typeOuvrage +
                ", langue ='" + langue + '\'' +
                ", genre ='" + genre + '\'' +
                '}';
    }

    @Override
    public double amendeRetard(int njours) {
        //TODO coder la méthode amendeRetard
        return 0;
    }
}
