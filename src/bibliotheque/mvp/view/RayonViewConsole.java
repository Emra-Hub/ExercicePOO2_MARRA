package bibliotheque.mvp.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;
import bibliotheque.mvp.presenter.RayonPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

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
        affListe(lr);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information : " + msg);
    }

    @Override
    public void affList(List<Exemplaire> lex) {
        affListe(lex);
    }

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "rechercher","modifier","special","fin"));
        do {
            int ch = choixListe(options);
            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    special();
                    break;
                case 6:
                    return;
            }
        } while (true);
    }

    private void rechercher() {
        System.out.println("code rayon ");
        String codeR = sc.nextLine();
        presenter.search(codeR);
    }

    private void modifier() {
        if(!lr.isEmpty()){
            int choix = choixElt(lr);
            Rayon r = lr.get(choix-1);
            String codeRay = modifyIfNotBlank("code rayon",r.getCodeRayon());
            String genre = modifyIfNotBlank("genre",r.getGenre());
            Rayon ray = new Rayon(codeRay,genre);
            presenter.update(ray);
            lr = presenter.getAll();
            affListe(lr);
        } else System.out.println("Aucun élément présent dans la liste");
    }

    private void retirer() {
        if(!lr.isEmpty()){
            affListe(lr);
            int choix = choixElt(lr);
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

    private void special() {
        int choix = choixElt(lr);
        Rayon r = lr.get(choix-1);
        do {
            System.out.println("1.Exemplaires en rayon\n2.menu principal");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    presenter.exemplaires(r);
                    break;
                case 2: return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);
    }
}
