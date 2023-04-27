package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.DAOLecteur;
import bibliotheque.mvp.model.SpecialLecteur;
import bibliotheque.mvp.view.LecteurViewInterface;
import bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class LecteurPresenterV2 extends Presenter<Lecteur> {
    private DAOLecteur model;
    private LecteurViewInterface view;

    public LecteurPresenterV2(DAO<Lecteur> model, ViewInterface<Lecteur> view) {
        super(model, view);
    }

    public void start() {
        view.setListDatas(getAll());
    }

    public List<Lecteur> getAll(){
        return model.getLecteurs();
    }

    public void exemplairesEnLocation(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesEnLocation(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }

    public void exemplairesLoues(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesLoues(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
}
