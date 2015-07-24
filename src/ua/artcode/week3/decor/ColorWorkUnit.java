package ua.artcode.week3.decor;

/**
 * Created by serhii on 24.07.15.
 */
public class ColorWorkUnit extends WorkUnit {

    public ColorWorkUnit(WorkUnit next) {
        super(next);
    }

    @Override
    public String abstractUnitAction() {
        return "-color red-";
    }
}
