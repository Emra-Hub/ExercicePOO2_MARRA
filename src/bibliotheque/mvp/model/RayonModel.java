package bibliotheque.mvp.model;

import bibliotheque.metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public class RayonModel implements DAORayon {

    private List<Rayon> rayons = new ArrayList<>();

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
    public List<Rayon> getRayons() {
        return rayons;
    }

    @Override
    public Rayon majRayon(Rayon ray) {
        boolean present = rayons.contains(ray.getCodeRayon());
        if(!present){
            return ray;
        }
        else return null;
    }
}
