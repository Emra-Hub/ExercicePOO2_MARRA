package bibliotheque.mvp.model;

import bibliotheque.metier.*;

import java.util.List;

public interface SpecialAuteur {
    public List<Ouvrage> ouvrages(Auteur a);
    public List<Ouvrage> ouvragesParTypeOuvrage(Auteur a, TypeOuvrage to);
    public List<Livre> ouvragesParTypeLivre(Auteur a, TypeLivre tl);
    public List<Ouvrage> ouvragesParGenre(Auteur a, String genre);
}
