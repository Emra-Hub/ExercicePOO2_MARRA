package bibliotheque.mvp.presenter;

import bibliotheque.metier.Auteur;
import bibliotheque.mvp.model.DAOAuteur;
import bibliotheque.mvp.view.AuteurViewInterface;

import java.util.List;

public class AuteurPresenter {
    private DAOAuteur model;
    private AuteurViewInterface view;

    public AuteurPresenter(DAOAuteur model, AuteurViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        List<Auteur> auteurs = model.getAuteurs();
        view.setListDatas(auteurs);
    }

    public void addAuteur(Auteur auteur) {
        Auteur aut = model.addAuteur(auteur);
        if(aut!=null) view.affMsg("création de :"+aut);
        else view.affMsg("erreur de création");
        List<Auteur> auteurs = model.getAuteurs();
        view.setListDatas(auteurs);
    }


    public void removeAuteur(Auteur auteur) {
        boolean ok = model.removeAuteur(auteur);
        if(ok) view.affMsg("auteur effacé");
        else view.affMsg("auteur non effacé");
        List<Auteur> auteurs = model.getAuteurs();
        view.setListDatas(auteurs);
    }

    public void majAuteur(Auteur auteur){
        Auteur aut = model.majAuteur(auteur);
        if(aut!=null) view.affMsg("Modification de :"+aut);
        else view.affMsg("erreur de modification");
        List<Auteur> auteurs = model.getAuteurs();
        view.setListDatas(auteurs);
    }
}
