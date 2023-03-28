package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public class RayonModel implements DAORayon, SpecialRayon {

    private List<Rayon> rayons = new ArrayList<>();

    public RayonModel() { populate(); }

    @Override
    public Rayon addRayon(Rayon ray) {
        boolean present = rayons.contains(ray);
        if(!present){
            rayons.add(ray);
            return ray;
        }
        else return null;
    }

    @Override
    public boolean removeRayon(Rayon ray) {
        return rayons.remove(ray);
    }

    @Override
    public Rayon updateRayon(Rayon ray) {
        int p = rayons.indexOf(ray);
        if (p < 0) return null;
        rayons.set(p,ray);
        return ray;
    }

    @Override
    public Rayon readRayon(String codeRay) {
        for (Rayon r: rayons) {
            if(r.getCodeRayon().equals(codeRay)) return r;
        }
        return null;
    }

    @Override
    public List<Rayon> getRayons() {
        return rayons;
    }

    private void populate() {
        Rayon r = new Rayon("r12","aventure");
        addRayon(r);
        r = new Rayon("r45","science fiction");
        addRayon(r);
    }

    @Override
    public List<Exemplaire> exemplaires(Rayon r) {
        return r.listerExemplaires();
    }
}
