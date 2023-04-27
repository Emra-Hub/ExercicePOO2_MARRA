package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.view.ViewInterface;

public class ExemplairePresenterV2 extends Presenter<Exemplaire> {
    public ExemplairePresenterV2(DAO<Exemplaire> model, ViewInterface<Exemplaire> view) {
        super(model, view);
    }
}
