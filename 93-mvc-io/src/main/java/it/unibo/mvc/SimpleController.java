package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public final class SimpleController implements Controller {
    String nextString = "";
    List<String> history = new ArrayList<String>();

    @Override
    public void setNextString(String text) throws NullPointerException {
        nextString = text;
    }

    @Override
    public String getNexString() {
        return nextString;
    }

    @Override
    public List<String> getHistory() {
        return history;
    }

    @Override
    public void printNextString() {
        history.add(nextString);
        System.out.println(nextString);
    }

}
