package bibliotheque.mvp.presenter;

import bibliotheque.metier.Rayon;
import bibliotheque.mvp.model.DAORayon;
import bibliotheque.mvp.view.RayonViewInterface;

import java.util.List;

public class RayonPresenter {
    private DAORayon model;

    private RayonViewInterface view;

    public RayonPresenter(DAORayon model, RayonViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        List<Rayon> rayons = model.getRayons();
        view.setListDatas(rayons);
    }

    public void addRayon(Rayon rayon) {
        Rayon ray = model.addRayon(rayon);
        if(ray!=null) view.affMsg("création de : "+ray);
        else view.affMsg("erreur de création");
        List<Rayon> rayons = model.getRayons();
        view.setListDatas(rayons);
    }


    public void removeRayon(Rayon rayon) {
        boolean ok = model.removeRayon(rayon);
        if(ok) view.affMsg("rayon effacé");
        else view.affMsg("rayon non effacé");
        List<Rayon> rayons = model.getRayons();
        view.setListDatas(rayons);
    }

    public void majRayon(Rayon rayon){
        Rayon ray = model.majRayon(rayon);
        if(ray!=null) view.affMsg("Modification de : "+ray);
        else view.affMsg("erreur de modification");
        List<Rayon> rayons = model.getRayons();
        view.setListDatas(rayons);
    }
}
