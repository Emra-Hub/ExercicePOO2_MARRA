package bibliotheque;

import java.io.Console;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Gestion {
    private static List<Auteur> laut = new ArrayList<>();
    private static List<Lecteur> llect = new ArrayList<>();
    private static List<Ouvrage> louv= new ArrayList<>();
    private static List<Exemplaire> lex = new ArrayList<>();
    private static List<Rayon> lrayon= new ArrayList<>();
    private static List<Location> lloc = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    public static void populate(){
        Auteur a = new Auteur("Verne","Jules","France");
        laut.add(a);

        Livre l = new Livre("Vingt mille lieues sous les mers",(byte)10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350,TypeLivre.ROMAN,"histoire de sous-marin");
        louv.add(l);

        /*a.getOuvrages().add(l);
        l.getAuteurs().add(a);*/
        a.addOuvrage(l);

        a = new Auteur("Spielberg","Steven","USA");
        laut.add(a);

        DVD d = new DVD("AI", (byte) 12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l,LocalTime.of(2,0),(byte)2);
        d.getAutresLangues().add("français");
        d.getAutresLangues().add("italien");
        d.getSousTitres().add("néerlandais");
        louv.add(d);

        /*a.getOuvrages().add(d);
        d.getAuteurs().add(a);*/
        a.addOuvrage(d);

        a = new Auteur("Kubrick","Stanley","GB");
        laut.add(a);

        /*a.getOuvrages().add(d);
        d.getAuteurs().add(a);*/
        a.addOuvrage(d);

        CD c = new CD("The Compil 2023",(byte) 0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20, LocalTime.of(1,40));
        louv.add(c);

        Rayon r = new Rayon("r12","aventure");
        lrayon.add(r);

        Exemplaire e = new Exemplaire("m12","état neuf",l);
        lex.add(e);

        /*e.setRayon(r);
        r.getExemplaires().add(e);*/
        r.addExemplaire(e);

        r = new Rayon("r45","science fiction");
        lrayon.add(r);

        e = new Exemplaire("d12","griffé",d);
        lex.add(e);

        /*e.setRayon(r);
        r.getExemplaires().add(e);*/
        r.addExemplaire(e);

        Lecteur lec = new Lecteur(1,"Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        llect.add(lec);

        Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),100,e,lec);
        /*lec.getLocations().add(loc);
        e.getLocations().add(loc);*/
        lloc.add(loc);

        lec = new Lecteur(1,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        llect.add(lec);

        loc = new Location(LocalDate.of(2023,2,5),LocalDate.of(2023,3,5),100,e,lec);
        /*lec.getLocations().add(loc);
        e.getLocations().add(loc);*/
        lloc.add(loc);
    }
    public static void main(String[] args) {
        populate();

        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            System.out.println("1.Auteurs\n2.Ouvrages\n3.Lecteur\n4.Rayon\n5.Exemplaire\n6.Louer\n7.Rendre\n8.Fin");
            System.out.print("Votre choix : ");
            choix= sc.nextInt();
            switch(choix) {
                case 1 :gestAuteurs();
                    break;
                case 2 :gestOuvrages();
                    break;
                case 3 :gestLecteurs();
                    break;
                case 4 :gestRayons();
                    break;
                case 5 :gestExemplaires();
                    break;
                case 6 :louer();
                    break;
                case 7 :rendre();
                    break;
                case 8 : System.out.println("Au revoir et à bientôt !");
                    break;
            }
        }while(choix != 8);
    }

    private static void gestAuteurs() {
        System.out.println("---Ajout Auteur---");
        System.out.print("Nom : ");
        String nom = sc.nextLine();
        System.out.print("Prénom : ");
        String prenom = sc.nextLine();
        System.out.print("Nationalité : ");
        String nationalite = sc.nextLine();

        Auteur a = new Auteur(nom,prenom,nationalite);
        laut.add(a);
        System.out.println("Auteur ajouté.");
    }

    private static void gestOuvrages() {
        System.out.println("---Ajout Ouvrage---");
        System.out.println("Type d'ouvrage : ");
        for (int i = 0 ; i < TypeOuvrage.values().length ; i++) {
            System.out.println(i+1+"."+TypeOuvrage.values()[i]);
        }
        int choix;
        do {
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();
        } while (choix < 1 || choix > TypeOuvrage.values().length);

        if(choix == 1) {
            System.out.println("Ajout livre : ");
            System.out.print("Titre : ");
            String titre = sc.nextLine();

            System.out.print("Age minimum : ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("-->Date de parution<--");
            System.out.print("Année : ");
            int annee = sc.nextInt();
            System.out.print("Mois : ");
            int mois = sc.nextInt();
            System.out.print("Jour : ");
            int jour = sc.nextInt();
            sc.nextLine();

            System.out.print("Prix : ");
            double prix = sc.nextDouble();
            sc.nextLine();

            System.out.print("Langue : ");
            String langue = sc.nextLine();

            System.out.print("Genre : ");
            String genre = sc.nextLine();

            System.out.print("ISBN : ");
            String isbn = sc.nextLine();

            System.out.print("Nombre de pages : ");
            int nbrePages = sc.nextInt();

            System.out.println("Type livre : ");
            for (int i = 0 ; i < TypeLivre.values().length ; i++) {
                System.out.println(i+1+"."+TypeLivre.values()[i]);
            }
            int tLivre;
            do {
                System.out.print("Votre choix : ");
                tLivre = sc.nextInt();
            } while (tLivre < 1 || tLivre > TypeLivre.values().length);
            tLivre--; //Afin de correspondre au bon choix de l'énum
            sc.nextLine();

            System.out.print("Résumé : ");
            String resume = sc.nextLine();

            Livre l = new Livre(titre,(byte)age,LocalDate.of(annee,mois,jour),prix,langue,genre,isbn,nbrePages,TypeLivre.values()[tLivre],resume);
            louv.add(l);

            System.out.println("Auteur du livre : ");
            choixAuteur(l);
            System.out.println("Livre ajouté.");

            System.out.println(l);
            System.out.println(l.getLaut());

        } else if(choix == 2) {
            System.out.println("Ajout CD : ");
            System.out.print("Titre : ");
            String titre = sc.nextLine();

            System.out.print("Age minimum : ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("-->Date de parution<--");
            System.out.print("Année : ");
            int annee = sc.nextInt();
            System.out.print("Mois : ");
            int mois = sc.nextInt();
            System.out.print("Jour : ");
            int jour = sc.nextInt();
            sc.nextLine();

            System.out.print("Prix : ");
            double prix = sc.nextDouble();
            sc.nextLine();

            System.out.print("Langue : ");
            String langue = sc.nextLine();

            System.out.print("Genre : ");
            String genre = sc.nextLine();

            System.out.print("CODE : ");
            long code = sc.nextInt();

            System.out.print("Nombre de plages : ");
            int nbrePlages = sc.nextInt();

            System.out.println("-->Durée<--");
            System.out.print("Heure(s) : ");
            int heure = sc.nextInt();
            System.out.print("Minute(s) : ");
            int minute = sc.nextInt();
            sc.nextLine();

            CD c = new CD(titre,(byte)age,LocalDate.of(annee,mois,jour),prix,langue,genre,code,(byte)nbrePlages,LocalTime.of(heure,minute));
            louv.add(c);

            System.out.println("Auteur du CD : ");
            choixAuteur(c);
            System.out.println("CD ajouté.");

            System.out.println(c);
            System.out.println(c.getLaut());

        } else {
            System.out.println("Ajout DVD : ");
            System.out.print("Titre : ");
            String titre = sc.nextLine();

            System.out.print("Age minimum : ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("-->Date de parution<--");
            System.out.print("Année : ");
            int annee = sc.nextInt();
            System.out.print("Mois : ");
            int mois = sc.nextInt();
            System.out.print("Jour : ");
            int jour = sc.nextInt();
            sc.nextLine();

            System.out.print("Prix : ");
            double prix = sc.nextDouble();
            sc.nextLine();

            System.out.print("Langue : ");
            String langue = sc.nextLine();

            System.out.print("Genre : ");
            String genre = sc.nextLine();

            System.out.print("CODE : ");
            long code = sc.nextInt();

            System.out.println("-->Durée<--");
            System.out.print("Heure(s) : ");
            int heure = sc.nextInt();
            System.out.print("Minute(s) : ");
            int minute = sc.nextInt();
            sc.nextLine();

            System.out.print("Nombre bonus : ");
            int bonus = sc.nextInt();
            sc.nextLine();

            DVD d = new DVD(titre,(byte)age,LocalDate.of(annee,mois,jour),prix,langue,genre,code,LocalTime.of(heure,minute),(byte)bonus);
            louv.add(d);

            System.out.println("Auteur du DVD : ");
            choixAuteur(d);
            System.out.println("DVD ajouté.");

            System.out.println(d);
            System.out.println(d.getLaut());
        }
    }

    private static void choixAuteur(Ouvrage o) {
        int choixAut = -1; //Afin qu'il passe au moins 1x dans la boucle

        while(choixAut != laut.size()) {
            for(int i = 0 ; i < laut.size() ; i++) {
                System.out.println(i+1+". "+laut.get(i).getPrenom()+" "+laut.get(i).getNom());
            }
            System.out.println(laut.size()+1+". Fin");
            System.out.print("Votre choix : ");
            choixAut = sc.nextInt() - 1;
            if (choixAut >= 0 && choixAut < laut.size()) {
                laut.get(choixAut).addOuvrage(o);
            }
        }
    }

    private static void gestLecteurs() {
        System.out.println("---Ajout Lecteur---");
        System.out.print("Numéro lecteur : ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.print("Nom : ");
        String nom = sc.nextLine();
        System.out.print("Prénom : ");
        String prenom = sc.nextLine();

        System.out.println("-->Date de naissance<--");
        System.out.print("Année : ");
        int annee = sc.nextInt();
        System.out.print("Mois : ");
        int mois = sc.nextInt();
        System.out.print("Jour : ");
        int jour = sc.nextInt();
        sc.nextLine();

        System.out.print("Mail : ");
        String mail = sc.nextLine();
        System.out.print("Adresse : ");
        String adr = sc.nextLine();
        System.out.print("Téléphone : ");
        String tel = sc.nextLine();

        Lecteur l = new Lecteur(num,nom,prenom,LocalDate.of(annee,mois,jour),mail,adr,tel);
        llect.add(l);
        System.out.println("Lecteur ajouté.");
    }

    private static void gestRayons() {
        System.out.println("---Ajout Rayon---");
        System.out.print("Code rayon : ");
        String codeRayon = sc.nextLine();
        System.out.print("Genre : ");
        String genre = sc.nextLine();

        Rayon r = new Rayon(codeRayon,genre);
        lrayon.add(r);
        System.out.println("Rayon ajouté.");
    }

    private static void gestExemplaires() {
        //TODO coder méthode gestExemplaires
    }

    private static void louer() {
        //TODO coder méthode louer
    }

    private static void rendre() {
        //TODO coder méthode rendre
    }
}