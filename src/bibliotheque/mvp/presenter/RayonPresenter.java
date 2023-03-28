package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;
import bibliotheque.mvp.model.DAORayon;
import bibliotheque.mvp.model.SpecialRayon;
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

    public void start() { view.setListDatas(getAll()); }

    public List<Rayon> getAll() { return model.getRayons(); }

    public void addRayon(Rayon rayon) {
        Rayon ray = model.addRayon(rayon);
        if(ray!=null) view.affMsg("création de : "+ray);
        else view.affMsg("erreur de création");
        //List<Rayon> rayons = model.getRayons();
        //view.setListDatas(rayons);
    }


    public void removeRayon(Rayon rayon) {
        boolean ok = model.removeRayon(rayon);
        if(ok) view.affMsg("rayon effacé");
        else view.affMsg("rayon non effacé");
        //List<Rayon> rayons = model.getRayons();
        //view.setListDatas(rayons);
    }

    public void update(Rayon rayon){
        Rayon ray = model.updateRayon(rayon);
        if(ray!=null) view.affMsg("Modification de : "+ray);
        else view.affMsg("erreur de modification");
        //List<Rayon> rayons = model.getRayons();
        //view.setListDatas(rayons);
    }

    public void search(String codeRay) {
        Rayon r = model.readRayon(codeRay);
        if(r==null) view.affMsg("recherche infructueuse");
        else view.affMsg(r.toString());
    }

    public void exemplaires(Rayon r) {
        List<Exemplaire> lex = ((SpecialRayon)model).exemplaires(r);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
}
