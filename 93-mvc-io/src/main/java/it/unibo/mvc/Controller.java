package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    void setNextString(String text) throws NullPointerException;
    String getNexString();
    List<String> getHistory();
    void printNextString();
}
