package bibliotheque.mvp.view;

import bibliotheque.metier.*;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

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
        affListe(laut);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void affList(List<Ouvrage> louv) {
        affListe(louv);
    }

    @Override
    public void affListLivre(List<Livre> ll) {
        affListe(ll);
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
        System.out.println("nom ");
        String nom = sc.nextLine();
        System.out.println("prénom ");
        String prenom = sc.nextLine();
        System.out.println("nationalité ");
        String nationalite = sc.nextLine();
        presenter.search(nom,prenom,nationalite);
    }

    private void modifier() {
        if(!laut.isEmpty()){
            int choix = choixElt(laut);
            Auteur a = laut.get(choix-1);
            try{
                String nom = modifyIfNotBlank("nom",a.getNom());
                String prenom = modifyIfNotBlank("prénom",a.getPrenom());
                String nationalite = modifyIfNotBlank("nationalité",a.getNationalite());
                Auteur aut = new Auteur(nom,prenom,nationalite);
                presenter.update(aut);
            }catch(Exception e) {
                System.out.println("Erreur survenue : "+e.getMessage());
            }
            laut=presenter.getAll();//rafraichissemnt
            affListe(laut);
        } else System.out.println("Aucun élément présent dans la liste");
    }

    private void retirer() {
        if(!laut.isEmpty()){
            affListe(laut);
            int choix = choixElt(laut);
            Auteur auteur = laut.get(choix-1);
            presenter.removeAuteur(auteur);
        } else System.out.println("Aucun élément présent dans la liste");
    }

    private void ajouter() {
        try {
            System.out.println("nom ");
            String nom = sc.nextLine();
            System.out.println("prénom ");
            String prenom = sc.nextLine();
            System.out.println("nationalité ");
            String nationalite = sc.nextLine();
            Auteur aut = new Auteur(nom,prenom,nationalite);
            presenter.addAuteur(aut);
        }catch(Exception e) {
            System.out.println("Erreur survenue : "+e.getMessage());
        }
    }

    private void special() {
        int choix = choixElt(laut);
        Auteur aut = laut.get(choix-1);
        do {
            System.out.println("1.Ouvrages\n2.Ouvrages par type ouvrage\n3.Ouvrages par type livre\n4.Ouvrage par genre\n5.menu principal");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    presenter.ouvrages(aut);
                    break;
                case 2:
                    TypeOuvrage[] tto = TypeOuvrage.values();
                    List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
                    int choixOuv = choixListe(lto);
                    TypeOuvrage to = tto[choixOuv-1];
                    presenter.ouvragesParTypeOuvrage(aut,to);
                    break;
                case 3:
                    TypeLivre[] ttl = TypeLivre.values();
                    List<TypeLivre> ltl = new ArrayList<>(Arrays.asList(ttl));
                    int choixLiv = choixListe(ltl);
                    TypeLivre tl = ttl[choixLiv-1];
                    presenter.ouvragesParTypeLivre(aut,tl);
                    break;
                case 4:
                    System.out.print("Genre : ");
                    String genre = sc.nextLine();
                    presenter.ouvragesParGenre(aut,genre);
                    break;
                case 5: return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);
    }
}
