package ua.artcode.week3.decor;

import sun.nio.cs.StreamEncoder;

/**
 * Created by serhii on 24.07.15.
 */
public abstract class WorkUnit {

    private WorkUnit next;

    public WorkUnit(WorkUnit next) {
        this.next = next;
    }

    public String doWork(){
        return abstractUnitAction() + (next != null ? next.doWork() : "");
    }

    public abstract String abstractUnitAction();


}
