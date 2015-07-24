package ua.artcode.week3.decor;

/**
 * Created by serhii on 24.07.15.
 */
public class BodySceletWorkUnit extends WorkUnit {

    public BodySceletWorkUnit(WorkUnit next) {
        super(next);
    }

    @Override
    public String abstractUnitAction() {
        return "-skeleton-";
    }
}
