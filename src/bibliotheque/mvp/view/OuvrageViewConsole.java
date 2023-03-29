package bibliotheque.mvp.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeOuvrage;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.utilitaires.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

public class OuvrageViewConsole implements OuvrageViewInterface {
    private OuvragePresenter presenter;
    private List<Ouvrage> louv;
    private Scanner sc = new Scanner(System.in);

    public OuvrageViewConsole() {
    }

    @Override
    public void setPresenter(OuvragePresenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void setListDatas(List<Ouvrage> ouvrages) {
        this.louv=ouvrages;
        affListe(louv);
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
        System.out.println("titre ouvrage ");
        String title = sc.nextLine();
        presenter.search(title);
    }

    private void modifier() {
        //Obligatoire d'écrire la date en format YYYY-MM-DD
        if(!louv.isEmpty()){
            affListe(louv);
            int choix = choixElt(louv);
            Ouvrage ouv = louv.get(choix-1);
            String ageMin = modifyIfNotBlank("age min",ouv.getAgeMin()+"");
            String dateParution = modifyIfNotBlank("date de parution",ouv.getDateParution()+"");
            String prixLocation = modifyIfNotBlank("prix location",ouv.getPrixLocation()+"");
            String langue = modifyIfNotBlank("langue",ouv.getLangue());
            String genre = modifyIfNotBlank("genre",ouv.getGenre());
            ouv.setAgeMin(Integer.parseInt(ageMin));
            ouv.setDateParution(LocalDate.parse(dateParution));
            ouv.setPrixLocation(Double.parseDouble(prixLocation));
            ouv.setLangue(langue);
            ouv.setGenre(genre);
            presenter.update(ouv);
        } else System.out.println("Aucun élément présent dans la liste");
    }

    private void retirer() {
        if(!louv.isEmpty()){
            affListe(louv);
            int choix = choixElt(louv);
            Ouvrage ouv = louv.get(choix-1);
            presenter.removeOuvrage(ouv);
        } else System.out.println("Aucun élément présent dans la liste");
    }

    private void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = choixListe(lto);
        Ouvrage o = null;
        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        o = lof.get(choix-1).create();
        presenter.addOuvrage(o);
    }

    private void special() {
        int choix = choixElt(louv);
        Ouvrage o = louv.get(choix-1);
        do {
            System.out.println("1.Exemplaires\n2.Exemplaires en location\n3.Amende\n4.menu principal");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    presenter.exemplaires(o);
                    break;
                case 2:
                    boolean ok;
                    List<Exemplaire> lex = new ArrayList<>();
                    lex.addAll(o.getLex());
                    int choice1 = choixListe(lex);
                    Exemplaire ex = lex.get(choice1-1);
                    ok = ex.enLocation();
                    presenter.exemplaires(o,ok);
                case 3:
                    int jour;
                    List<Exemplaire> lexe = new ArrayList<>();
                    lexe.addAll(o.getLex());
                    int choice = choixListe(lexe);
                    Exemplaire e = lexe.get(choice-1);
                    jour = e.joursRetard();
                    presenter.amandeRetard(o,jour);
                case 4: return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);
    }
}
