package ua.artcode.week3.decor;

public class ColorWorkUnit extends WorkUnit {

    public ColorWorkUnit(WorkUnit next) {
        super(next);
    }

    @Override
    public String abstractUnitAction() {
        return "-color red-";
    }
}
