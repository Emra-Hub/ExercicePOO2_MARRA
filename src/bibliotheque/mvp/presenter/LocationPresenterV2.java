package bibliotheque.mvp.presenter;

import bibliotheque.metier.Location;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.view.ViewInterface;

public class LocationPresenterV2 extends Presenter<Location> {
    public LocationPresenterV2(DAO<Location> model, ViewInterface<Location> view) {
        super(model, view);
    }
}
