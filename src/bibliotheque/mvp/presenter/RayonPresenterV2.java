package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.DAORayon;
import bibliotheque.mvp.model.SpecialRayon;
import bibliotheque.mvp.view.RayonViewInterface;
import bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class RayonPresenterV2 extends Presenter<Rayon> {
    private DAORayon model;
    private RayonViewInterface view;

    public RayonPresenterV2(DAO<Rayon> model, ViewInterface<Rayon> view) {
        super(model, view);
    }

    public void start() {
        view.setListDatas(getAll());
    }

    public List<Rayon> getAll(){
        return model.getRayons();
    }

    public void exemplaires(Rayon r) {
        List<Exemplaire> lex = ((SpecialRayon)model).listerExemplaires(r);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
}
