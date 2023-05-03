package bibliotheque.mvp.view;

import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.Rayon;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.mvp.presenter.SpecialRayonPresenter;


import java.util.*;

import static bibliotheque.utilitaires.Utilitaire.*;

public class RayonViewConsole extends AbstractViewConsole<Rayon> implements SpecialRayonViewConsole {
    @Override
    public void setListDatas(List<Rayon> ldatas) {
        //ldatas.sort(new GenreRayon());
        Collections.sort(ldatas, new Comparator<Rayon>() {
            @Override
            public int compare(Rayon o1, Rayon o2) {
                return o1.getGenre().compareToIgnoreCase(o2.getGenre());
            }
        });
        super.setListDatas(ldatas);
    }

    @Override
    protected void rechercher() {
      System.out.println("code du rayon : ");
      String code = sc.nextLine();
      Rayon rech = new Rayon(code);
      presenter.search(rech);
    }

    @Override
    protected void modifier() {
        int choix = choixElt(ldatas);
       Rayon r= ldatas.get(choix-1);
        do {
            try {
                String genre = modifyIfNotBlank("nom", r.getGenre());
                r.setGenre(genre);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        presenter.update(r);
        ldatas=presenter.getAll();//rafraichissement
        affListe(ldatas);
    }

    @Override
    protected void ajouter() {
        Rayon r =null;
        do {
          try {
              System.out.println("code rayon ");
              String code = sc.nextLine();
              System.out.println("genre ");
              String genre = sc.nextLine();
              r = new Rayon(code, genre);
              presenter.add(r);
              ldatas=presenter.getAll();//rafraichissement
              affListe(ldatas);
              break;
          }
          catch (Exception e){
              System.out.println("une erreur est survenue : "+e);
          }
        }while(true);

    }

    @Override
    protected void special() {
        int choix =  choixElt(ldatas);
        Rayon r  = ldatas.get(choix-1);

        List options = new ArrayList<>(Arrays.asList("lister exemplaires","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    exemplaires(r);
                    break;
               case 2 :return;
            }
        } while (true);


    }

    @Override
    public void exemplaires(Rayon r) {
        ((SpecialRayonPresenter)presenter).listerExemplaires(r);
    }
}
