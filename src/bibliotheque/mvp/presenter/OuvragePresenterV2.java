package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.DAOOuvrage;
import bibliotheque.mvp.model.SpecialOuvrage;
import bibliotheque.mvp.view.OuvrageViewInterface;
import bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class OuvragePresenterV2 extends Presenter<Ouvrage> {
    private DAOOuvrage model;
    private OuvrageViewInterface view;

    public OuvragePresenterV2(DAO<Ouvrage> model, ViewInterface<Ouvrage> view) {
        super(model, view);
    }

    public void start() {
        view.setListDatas(getAll());
    }

    public List<Ouvrage> getAll(){
        return model.getOuvrages();
    }

    public void exemplaires(Ouvrage o) {
        List<Exemplaire> lex = ((SpecialOuvrage)model).exemplaires(o);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }

    public void exemplaires(Ouvrage o, boolean enLocation) {
        List<Exemplaire> lex = ((SpecialOuvrage)model).exemplaires(o,enLocation);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }

    public void amandeRetard(Ouvrage o, int njours) {
        double amande = ((SpecialOuvrage)model).amandeRetard(o,njours);
        if(amande==0) view.affMsg("aucune amende à payer");
        else view.affMsg("L'amande est de : "+amande);
    }
}
