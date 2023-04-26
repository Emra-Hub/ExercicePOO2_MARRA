package bibliotheque.gestion;

import bibliotheque.metier.*;
import bibliotheque.utilitaires.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Gestion {
    Scanner sc = new Scanner(System.in);
//on a ôté static pour les listes qui n'est plus nécessaire
    private List<Auteur> laut = new ArrayList<>();
    private List<Lecteur> llect = new ArrayList<>();
    private List<Ouvrage> louv= new ArrayList<>();
    private List<Exemplaire> lex = new ArrayList<>();
    private List<Rayon> lrayon= new ArrayList<>();
    private List<Location> lloc = new ArrayList<>();


    public void populate(){
        try {
            Auteur a = new Auteur("Verne","Jules","France");
            laut.add(a);

            Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350,TypeLivre.ROMAN,"histoire de sous-marin");
            louv.add(l);

            a.addOuvrage(l);

            a = new Auteur("Spielberg","Steven","USA");
            laut.add(a);

            DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l,LocalTime.of(2,0,0),(byte)2);
            d.getAutresLangues().add("français");
            d.getAutresLangues().add("italien");
            d.getSousTitres().add("néerlandais");
            louv.add(d);

            a.addOuvrage(d);

             a = new Auteur("Kubrick","Stanley","GB");
            laut.add(a);

            a.addOuvrage(d);


            CD c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,LocalTime.of(1,40,0));
            louv.add(c);

            Rayon r = new Rayon("r12","aventure");
            lrayon.add(r);

            Exemplaire e = new Exemplaire("m12","état neuf",l);
            lex.add(e);
            e.setRayon(r);


            r = new Rayon("r45","science fiction");
            lrayon.add(r);

            e = new Exemplaire("d12","griffé",d);
            lex.add(e);

            e.setRayon(r);


            Lecteur lec = new Lecteur(1,"Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
            llect.add(lec);

            Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lec,e);
            lloc.add(loc);
            loc.setDateRestitution(LocalDate.of(2023,2,4));

            lec = new Lecteur(1,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
            llect.add(lec);

            loc = new Location(LocalDate.of(2023,2,5),LocalDate.of(2023,3,5),lec,e);
            lloc.add(loc);
        }catch (Exception e) {
            System.out.println("Erreur survenue : "+e.getMessage());
        }
    }

    private void menu() {
        List options = new ArrayList<>(Arrays.asList("auteurs","ouvrages","exemplaires","rayons","lecteurs","locations","restitution","fin"));
      do{
        int choix = Utilitaire.choixListe(options);

            switch (choix){
                case 1 : gestAuteurs(); break;
                case 2 : gestOuvrages();break;
                case 3 : gestExemplaires();break;
                case 4 : gestRayons();break;
                case 5 : gestLecteurs();break;
                case 6 : gestLocations();break;
                case 7 : gestRestitution();break;
                default:System.exit(0);
            }
        }  while (true);
    }

    private void gestRestitution() {
        //TODO lister exemplaires en location , choisir l'un d'entre eux, enregistrer sa restitution et éventuellement changer état
        List<Exemplaire> le = new ArrayList<>();
        //System.out.println(lloc);
        for (Location l: lloc) {
            if(l.getDateRestitution()==null) le.add(l.getExemplaire());
        }
        if(!le.isEmpty()) {
            System.out.println("Quelle location voulez-vous rendre : ");
            int choix = Utilitaire.choixListe(le);
            for(int i = 0 ; i < lloc.size() ; i++) {
                if (lloc.get(i).getExemplaire().equals(le.get(choix - 1)) && lloc.get(i).getDateRestitution() == null){
                    lloc.get(i).setDateRestitution(LocalDate.now());
                    System.out.println("Modifier état ? (o/n)");
                    String etat = sc.nextLine();
                    if (etat.equalsIgnoreCase("o")){
                        System.out.println("Comment est l'état : ");
                        String et = sc.nextLine();
                        lloc.get(i).getExemplaire().setDescriptionEtat(et);
                    }
                    System.out.println("Restitution éfféctuée");
                }
            }
        }
        else System.out.println("Aucune location en cours.");
        //System.out.println(lloc);
    }

    private void gestLocations() {
        int choix;
        //TODO ne lister que les exemplaires libres et les trier par matricule
        /*for (int i = 0; i < lex.size(); i++) {
            if(!lex.get(i).getLloc().isEmpty() || lex.get(i).getLloc().isEmpty())
                //System.out.println((i + 1) + ". " + lex.get(i));
            for (int j = 0; j < lex.get(i).getLloc().size(); j++) {
                if (lex.get(i).getLloc().get(j).getDateRestitution()!=null) le.add(lex.get(i));
            }
        }*/
        List<Exemplaire> le = new ArrayList<>();
        for (Exemplaire e: lex) {
            if (!e.enLocation()) le.add(e);
        }
        Collections.sort(le);
        choix = Utilitaire.choixListe(le);
        /*if(lex.get(choix-1).enLocation()){
            System.out.println("exemplaire en location");
            return;
        }*/
        Exemplaire ex = le.get(choix-1);
        choix=Utilitaire.choixListe(llect);
        Lecteur lec = llect.get(choix-1);
        lloc.add(new Location(lec,ex));
    }

    private void gestLecteurs() {
        try {
            System.out.println("numéro");
            int num=sc.nextInt();
            sc.skip("\n");
            System.out.println("nom ");
            String nom=sc.nextLine();
            System.out.println("prénom ");
            String prenom=sc.nextLine();
            System.out.println("date de naissance");
            String[] jma = sc.nextLine().split(" ");
            int j = Integer.parseInt(jma[0]);
            int m = Integer.parseInt(jma[1]);
            int a = Integer.parseInt(jma[2]);
            LocalDate dn= LocalDate.of(a,m,j);
            System.out.println("adresse");
            String adr=sc.nextLine();
            System.out.println("mail");
            String mail=sc.nextLine();
            System.out.println("tel ");
            String tel=sc.nextLine();
            Lecteur lect = new Lecteur(num,nom,prenom,dn,adr,mail,tel);
            llect.add(lect);
            System.out.println("lecteur créé");
        }catch(Exception e) {
            System.out.println("Erreur survenue : "+e.getMessage());
        }
    }

    private void gestRayons() {
        try {
            System.out.println("code ");
            String code=sc.next();
            System.out.println("genre ");
            String genre=sc.next();
            Rayon r = new Rayon(code,genre);
            System.out.println("rayon créé");
            //TODO attribuer exemplaire, les exemplaires sont triés par ordre de titre de l'ouvrage , empêcher doublons sur l'exemplaire
        } catch (Exception e) {
            System.out.println("Erreur survenue : "+e.getMessage());
        }
    }

    private void gestExemplaires() {
        try {
            System.out.println("matricule ");
            String mat=sc.next();
            System.out.println("etat  ");
            String etat=sc.next();
            System.out.println("ouvrage ");
            int choix = Utilitaire.choixListe(louv);
            Exemplaire ex = new Exemplaire(mat,etat,louv.get(choix-1));
            lex.add(ex);
            System.out.println("exemplaire créé");
            //TODO attribuer rayon , les rayons sont triès par ordre de code
            Collections.sort(lrayon);
            System.out.println("Liste des rayons : ");
            int choix2 = Utilitaire.choixListe(lrayon);
            Rayon r = lrayon.get(choix2-1);
            r.addExemplaire(ex);
            System.out.println("Exemplaire ajouté au rayon");
            System.out.println("Liste des exemplaire déjà existant : ");
            for (int i = 0; i < lex.size(); i++) {
                System.out.println((i + 1) + ". " + lex.get(i));
            }
        } catch (Exception e) {
            System.out.println("Erreur survenue : "+e.getMessage());
        }
    }

    private void gestOuvrages() {
      /*  Ouvrage o = null;
        System.out.println("titre");
        String titre= sc.nextLine();
        System.out.println("age minimum");
        int ageMin= sc.nextInt();
        sc.skip("\n");
        System.out.println("date de parution");

        LocalDate dp= Utilitaire.lecDate();
        System.out.println("prix de location");
        double ploc = sc.nextDouble();
        sc.skip("\n");
        System.out.println("langue");
        String langue=sc.nextLine();
        System.out.println("genre");
        String genre=sc.nextLine();
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        switch (choix){
                case 1 :
                           System.out.println("isbn ");
                           String isbn = sc.next();
                           System.out.println("pages ");
                           int nbrePages = sc.nextInt();
                           sc.skip("\n");
                           TypeLivre[] ttl = TypeLivre.values();
                           List<TypeLivre> ltl = new ArrayList<>(Arrays.asList(ttl));
                            choix = Utilitaire.choixListe(ltl);
                            TypeLivre tl = ttl[choix-1];
                           System.out.println("résumé du livre :");
                           String resume = sc.nextLine();
                           o=new Livre(titre,ageMin,dp,ploc,langue,genre,isbn,nbrePages,tl,resume);
                           ;break;
                case 2 :
                            System.out.println("code : ");
                            long code= sc.nextLong();
                            System.out.println("nombre de plages :");
                            byte nbrePlages= sc.nextByte();
                            LocalTime dureeTotale = Utilitaire.lecTime();
                            o=new CD(titre,ageMin,dp,ploc,langue,genre,code,nbrePlages,dureeTotale);
                            ;break;
                case 3 :
                            System.out.println("code : ");
                            code= sc.nextLong();
                            dureeTotale=Utilitaire.lecTime();
                            byte nbreBonus= sc.nextByte();
                            o=new DVD(titre,ageMin,dp,ploc,langue,genre,code,dureeTotale,nbreBonus);
                            System.out.println("autres langues");
                            List<String> langues = new ArrayList<>(Arrays.asList("anglais","français","italien","allemand","fin"));
                            do{
                                choix=Utilitaire.choixListe(langues);
                                if(choix==langues.size())break;
                                ((DVD)o).getAutresLangues().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set et pas de doublon avec langue d'origine
                            }while(true);
                           System.out.println("sous-titres");
                            do{
                             choix=Utilitaire.choixListe(langues);
                             if(choix==langues.size())break;
                             ((DVD)o).getSousTitres().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set
                             }while(true);
                            ;break;
            }*/



        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage o = null;

     /*switch(choix) {
            case 1 : o = new LivreFactoryBeta().create();break;
            case 2 : o = new CDFactoryBeta().create();break;
            case 3 : o = new DVDFactoryBeta().create();break;
        }*/
        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        o = lof.get(choix-1).create();
        louv.add(o);
        System.out.println("ouvrage créé");
        //TODO attribuer auteurs, les auteur sont triés par odre de nom et prénom, empêcher doublons

    }

    private void gestAuteurs() {
        try {
            System.out.println("nom ");
            String nom=sc.nextLine();
            System.out.println("prénom ");
            String prenom=sc.nextLine();
            System.out.println("nationalité");
            String nat=sc.nextLine();
            Auteur a  = new Auteur(nom,prenom,nat);
            laut.add(a);
            System.out.println("écrivain créé");
            //TODO attribuer ouvrages , les ouvrages sont triés par ordre de titre
            Collections.sort(louv);
            System.out.println("Liste des ouvrages : ");
            int choix = Utilitaire.choixListe(louv);
            Ouvrage o = louv.get(choix-1);
            o.addAuteur(a);
            System.out.println("Auteur ajouté à l'ouvrage");
            System.out.println("Liste des auteurs avec leurs ouvrages : ");
            for (int i = 0; i < laut.size(); i++) {
                if(!laut.get(i).getLouvrage().isEmpty())
                System.out.println((i + 1) + ". " + laut.get(i));
                for (int j = 0; j < laut.get(i).getLouvrage().size(); j++) {
                    System.out.println("   ==>" + laut.get(i).getLouvrage().get(j));
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur survenue : "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        Gestion g = new Gestion();
        g.populate();
        g.menu();
    }

  
}
