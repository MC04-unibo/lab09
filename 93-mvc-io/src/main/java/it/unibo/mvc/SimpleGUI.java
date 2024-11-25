package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final JPanel canvas = new JPanel();
    SimpleGUI(){
        frame.setContentPane(canvas);
    }
    public static void main(String[] args){

    }
}
