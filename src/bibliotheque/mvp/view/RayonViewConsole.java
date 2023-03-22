package bibliotheque.mvp.view;

import bibliotheque.metier.Rayon;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RayonViewConsole implements RayonViewInterface {
    private RayonPresenter presenter;
    private List<Rayon> lr;
    private Scanner sc = new Scanner(System.in);

    public RayonViewConsole() {
    }

    @Override
    public void setPresenter(RayonPresenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void setListDatas(List<Rayon> rayons) {
        this.lr=rayons;
        Utilitaire.affListe(lr);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information : " + msg);
    }

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "modifier", "fin"));
        do {
            int ch = Utilitaire.choixListe(options);
            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    modifier();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }

    private void modifier() {
        if(!lr.isEmpty()){
            Utilitaire.affListe(lr);
            int choix = Utilitaire.choixElt(lr);
            Rayon r = lr.get(choix-1);
            System.out.println("Nouveau genre : ");
            String genre = sc.nextLine();
            r.setGenre(genre);
            presenter.majRayon(r);
        } else System.out.println("Aucun élément présent dans la liste");
    }

    private void retirer() {
        if(!lr.isEmpty()){
            Utilitaire.affListe(lr);
            int choix = Utilitaire.choixElt(lr);
            Rayon r = lr.get(choix-1);
            presenter.removeRayon(r);
        } else System.out.println("Aucun élément présent dans la liste");
    }

    private void ajouter() {
        System.out.println("code rayon ");
        String codeR = sc.nextLine();
        System.out.println("genre ");
        String genre = sc.nextLine();
        Rayon r = new Rayon(codeR,genre);
        presenter.addRayon(r);
    }
}
