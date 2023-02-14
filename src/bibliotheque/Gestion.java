package bibliotheque;

import java.time.LocalDate;

public class Gestion {
    public static void main(String[] args) {
        Auteur a1 = new Auteur("Lenoir","Jean","Belge");
        Livre l1 = new Livre("Momo dans le désert",15, LocalDate.of(2020,4,15),5.50,"Français","Aventure","B412",50,TypeLivre.DOCUMENTAIRE,"Perdu dans le désert, il doit absolument survivre..");
        /*a1.getOuvrages().add(l1);
        l1.getAuteurs().add(a1);*/
        a1.add(l1);
        Rayon r1 = new Rayon("c15","Survie");
        Exemplaire e1 = new Exemplaire("c33","Neuf",l1);
        e1.setRayon(r1);
        r1.getExemplaires().add(e1);
        Lecteur d1 = new Lecteur(1,"Lejaune","Patrick",LocalDate.of(1980,5,20),"patrick.lejaune@condorcet.be","Rue du bois, 12","0497865432");
        Location y1 = new Location(LocalDate.of(2023,2,9),LocalDate.of(2023,2,10),10,e1,d1);
        d1.getLocations().add(y1);
        e1.getLocations().add(y1);
        System.out.println(a1);
        System.out.println(a1.getOuvrages());
        System.out.println(l1);
        System.out.println(l1.getAuteurs());
        System.out.println(r1);
        System.out.println(e1);
        System.out.println(d1);
        System.out.println(y1);
    }
}