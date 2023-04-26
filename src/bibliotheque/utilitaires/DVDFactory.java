package bibliotheque.utilitaires;

import bibliotheque.metier.DVD;
import bibliotheque.metier.Ouvrage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DVDFactory extends OuvrageFactory{
    public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre){
        try {
            System.out.println("code : ");
            long code= sc.nextLong();
            LocalTime dureeTotale=Utilitaire.lecTime();
            byte nbreBonus= sc.nextByte();
            DVD dvd =new DVD(titre,ageMin,dateParution,prixLocation,langue,genre,code,dureeTotale,nbreBonus);
            System.out.println("autres langues");
            List<String> langues = new ArrayList<>(Arrays.asList("anglais","français","italien","allemand","fin"));
            int choix;
            do{
                choix=Utilitaire.choixListe(langues);
                if(choix==langues.size())break;
                if(dvd.getLangue().equals(langues.get(choix-1))) System.out.println("Cette langue est déjà présente");
                else if(dvd.getAutresLangues().contains(langues.get(choix-1))) System.out.println("Cette langue est déjà présente");
                else dvd.getAutresLangues().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set et pas de doublon avec langue d'origine
            }while(true);
            System.out.println("sous-titres");
            do{
                choix=Utilitaire.choixListe(langues);
                if(choix==langues.size())break;
                if(dvd.getSousTitres().contains(langues.get(choix-1))) System.out.println("Cette langue est déjà présente");
                else dvd.getSousTitres().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set
            }while(true);
            return dvd;
        } catch (Exception e) {
            System.out.println("Erreur survenue : "+e.getMessage());
            return null;
        }
    }
}
