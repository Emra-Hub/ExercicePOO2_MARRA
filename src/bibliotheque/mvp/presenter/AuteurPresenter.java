package bibliotheque.mvp.presenter;

import bibliotheque.metier.*;
import bibliotheque.mvp.model.DAOAuteur;
import bibliotheque.mvp.model.SpecialAuteur;
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
        view.setListDatas(getAll());
    }

    public List<Auteur> getAll() { return model.getAuteurs(); }

    public void addAuteur(Auteur auteur) {
        Auteur aut = model.addAuteur(auteur);
        if(aut!=null) view.affMsg("création de :"+aut);
        else view.affMsg("erreur de création");
        //List<Auteur> auteurs = model.getAuteurs();
        //view.setListDatas(auteurs);
    }


    public void removeAuteur(Auteur auteur) {
        boolean ok = model.removeAuteur(auteur);
        if(ok) view.affMsg("auteur effacé");
        else view.affMsg("auteur non effacé");
        //List<Auteur> auteurs = model.getAuteurs();
        //view.setListDatas(auteurs);
    }

    public void update(Auteur auteur) {
        Auteur aut = model.updateAuteur(auteur);
        if(aut!=null) view.affMsg("Modification de :"+aut);
        else view.affMsg("erreur de modification");
        //List<Auteur> auteurs = model.getAuteurs();
        //view.setListDatas(auteurs);
    }

    public void search(String nom, String prenom, String nationalite) {
        Auteur a = model.readAuteur(nom, prenom, nationalite);
        if(a==null) view.affMsg("recherche infructueuse");
        else view.affMsg(a.toString());
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
