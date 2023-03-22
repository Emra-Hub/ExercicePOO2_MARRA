package bibliotheque.mvp.model;

import bibliotheque.metier.Rayon;

import java.util.List;

public interface DAORayon {
    Rayon addRayon(Rayon ray);

    boolean removeRayon(Rayon ray);

    List<Rayon> getRayons();

    Rayon majRayon(Rayon ray);
}
