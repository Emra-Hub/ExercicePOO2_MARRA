package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.model.DAOOuvrage;
import bibliotheque.mvp.model.SpecialOuvrage;
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
        view.setListDatas(getAll());
    }

    public List<Ouvrage> getAll() { return model.getOuvrages(); }

    public void addOuvrage(Ouvrage ouvrage) {
        Ouvrage ouv = model.addOuvrage(ouvrage);
        if(ouv!=null) view.affMsg("création de : "+ouv);
        else view.affMsg("erreur de création");
        //List<Ouvrage> ouvrages = model.getOuvrages();
        //view.setListDatas(ouvrages);
    }


    public void removeOuvrage(Ouvrage ouvrage) {
        boolean ok = model.removeOuvrage(ouvrage);
        if(ok) view.affMsg("ouvrage effacé");
        else view.affMsg("ouvrage non effacé");
        //List<Ouvrage> ouvrages = model.getOuvrages();
        //view.setListDatas(ouvrages);
    }

    public void update(Ouvrage ouvrage){
        Ouvrage ouv = model.updateOuvrage(ouvrage);
        if(ouv!=null) view.affMsg("Modification de : "+ouv);
        else view.affMsg("erreur de modification");
        //List<Ouvrage> ouvrages = model.getOuvrages();
        //view.setListDatas(ouvrages);
    }

    public void search(String title) {
        Ouvrage o = model.readOuvrage(title);
        if(o==null) view.affMsg("recherche infructueuse");
        else view.affMsg(o.toString());
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
