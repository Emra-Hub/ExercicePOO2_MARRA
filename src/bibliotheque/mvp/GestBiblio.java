package bibliotheque.mvp;

import bibliotheque.mvp.model.*;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.mvp.view.*;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestBiblio {

    private DAOLecteur lm;
    private LecteurViewInterface lv;
    private LecteurPresenter lp;
    private DAOAuteur am;
    private AuteurViewInterface av;
    private AuteurPresenter ap;
    private DAORayon rm;
    private RayonViewInterface rv;
    private RayonPresenter rp;
    private DAOOuvrage om;
    private OuvrageViewInterface ov;
    private OuvragePresenter op;

    public void gestion() {

        lm = new LecteurModel();
        lv = new LecteurViewConsole();
        lp = new LecteurPresenter(lm, lv);//création et injection de dépendance

        am = new AuteurModel();
        av = new AuteurViewConsole();
        ap = new AuteurPresenter(am,av);

        rm = new RayonModel();
        rv = new RayonViewConsole();
        rp = new RayonPresenter(rm,rv);

        om = new OuvrageModel();
        ov = new OuvrageViewConsole();
        op = new OuvragePresenter(om,ov);

        List<String> options = Arrays.asList("Lecteur","Auteur","Rayon","Ouvrage","Fin");
        do {
            int ch = Utilitaire.choixListe(options);
            switch (ch) {
                case 1: lp.start();
                    break;
                case 2: ap.start();
                    break;
                case 3: rp.start();
                    break;
                case 4: op.start();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }

    public static void main(String[] args) {
        GestBiblio g = new GestBiblio();
        g.gestion();
    }

}
