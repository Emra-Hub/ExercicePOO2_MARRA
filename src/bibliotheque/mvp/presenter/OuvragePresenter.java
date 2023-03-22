package bibliotheque.mvp.presenter;

import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.model.DAOOuvrage;
import bibliotheque.mvp.view.OuvrageViewInterface;

import java.util.List;

public class OuvragePresenter {
    private DAOOuvrage model;
    private OuvrageViewInterface view;

    public OuvragePresenter(DAOOuvrage model, OuvrageViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        List<Ouvrage> ouvrages = model.getOuvrages();
        view.setListDatas(ouvrages);
    }

    public void addOuvrage(Ouvrage ouvrage) {
        Ouvrage ouv = model.addOuvrage(ouvrage);
        if(ouv!=null) view.affMsg("création de : "+ouv);
        else view.affMsg("erreur de création");
        List<Ouvrage> ouvrages = model.getOuvrages();
        view.setListDatas(ouvrages);
    }


    public void removeOuvrage(Ouvrage ouvrage) {
        boolean ok = model.removeOuvrage(ouvrage);
        if(ok) view.affMsg("ouvrage effacé");
        else view.affMsg("ouvrage non effacé");
        List<Ouvrage> ouvrages = model.getOuvrages();
        view.setListDatas(ouvrages);
    }

    public void majOuvrage(Ouvrage ouvrage){
        Ouvrage ouv = model.majOuvrage(ouvrage);
        if(ouv!=null) view.affMsg("Modification de : "+ouv);
        else view.affMsg("erreur de modification");
        List<Ouvrage> ouvrages = model.getOuvrages();
        view.setListDatas(ouvrages);
    }
}
