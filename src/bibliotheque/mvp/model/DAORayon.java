package bibliotheque.mvp.model;

import bibliotheque.metier.Rayon;

import java.util.List;

public interface DAORayon {
    Rayon addRayon(Rayon ray);

    boolean removeRayon(Rayon ray);

    Rayon updateRayon(Rayon ray);

    Rayon readRayon(String codeRay);

    List<Rayon> getRayons();
}
