package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AuteurViewConsole implements AuteurViewInterface {
    private AuteurPresenter presenter;

    private List<Auteur> laut;

    private Scanner sc = new Scanner(System.in);

    public AuteurViewConsole() {

    }

    @Override
    public void setPresenter(AuteurPresenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void setListDatas(List<Auteur> auteurs) {
        this.laut=auteurs;
        Utilitaire.affListe(laut);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
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

    public void opModification(Auteur auteur){
        List options = new ArrayList<>(Arrays.asList("nom", "prenom", "nationalité", "fin"));
        do {
            int ch = Utilitaire.choixListe(options);
            switch (ch) {
                case 1:
                    System.out.println("nom ");
                    String nom = sc.nextLine();
                    auteur.setNom(nom);
                    break;
                case 2:
                    System.out.println("prénom ");
                    String prenom = sc.nextLine();
                    auteur.setPrenom(prenom);
                    break;
                case 3:
                    System.out.println("nationalité ");
                    String nationalite = sc.nextLine();
                    auteur.setNationalite(nationalite);
                    break;
                case 4:
                    return;
            }
            presenter.majAuteur(auteur);
        } while (true);
    }

    private void modifier() {
        if(!laut.isEmpty()){
            Utilitaire.affListe(laut);
            int choix = Utilitaire.choixElt(laut);
            Auteur auteur = laut.get(choix-1);
            opModification(auteur);
        } else System.out.println("Aucun élément présent dans la liste");
    }

    private void retirer() {
        if(!laut.isEmpty()){
            Utilitaire.affListe(laut);
            int choix = Utilitaire.choixElt(laut);
            Auteur auteur = laut.get(choix-1);
            presenter.removeAuteur(auteur);
        } else System.out.println("Aucun élément présent dans la liste");
    }

    private void ajouter() {
        System.out.println("nom ");
        String nom = sc.nextLine();
        System.out.println("prénom ");
        String prenom = sc.nextLine();
        System.out.println("nationalité ");
        String nationalite = sc.nextLine();
        Auteur aut = new Auteur(nom,prenom,nationalite);
        presenter.addAuteur(aut);
    }
}
