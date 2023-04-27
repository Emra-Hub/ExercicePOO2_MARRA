package bibliotheque.mvp.presenter;

import bibliotheque.metier.*;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.DAOAuteur;
import bibliotheque.mvp.model.SpecialAuteur;
import bibliotheque.mvp.view.AuteurViewInterface;
import bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class AuteurPresenterV2 extends Presenter<Auteur> {
    private DAOAuteur model;
    private AuteurViewInterface view;

    public AuteurPresenterV2(DAO<Auteur> model, ViewInterface<Auteur> view) {
        super(model, view);
    }

    public void start() {
        view.setListDatas(getAll());
    }

    public List<Auteur> getAll(){
        return model.getAuteurs();
    }

    public void ouvrages(Auteur a) {
        List<Ouvrage> louv = ((SpecialAuteur)model).ouvrages(a);
        if(louv==null || louv.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(louv);
    }

    public void ouvragesParTypeOuvrage(Auteur a, TypeOuvrage to) {
        List<Ouvrage> louv = ((SpecialAuteur)model).ouvragesParTypeOuvrage(a,to);
        if(louv==null || louv.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(louv);
    }

    public void ouvragesParTypeLivre(Auteur a, TypeLivre tl) {
        List<Livre> louv = ((SpecialAuteur)model).ouvragesParTypeLivre(a,tl);
        if(louv==null || louv.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affListLivre(louv);
    }

    public void ouvragesParGenre(Auteur a, String genre) {
        List<Ouvrage> louv = ((SpecialAuteur)model).ouvragesParGenre(a,genre);
        if(louv==null || louv.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(louv);
    }
}
