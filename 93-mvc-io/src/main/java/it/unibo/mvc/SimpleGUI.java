package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("TYPEWRITER");
    private final JPanel canvas = new JPanel();
    private final int PROPORTION = 3;

    SimpleGUI(){
        frame.setContentPane(canvas);
        canvas.setLayout(new BorderLayout());

        JTextField textField = new JTextField();        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        JButton clearButton = new JButton("CLEAR");
        JButton printButton = new JButton("PRINT");
        JButton showHistoryButton = new JButton("SHOW HISTORY");

        buttonPanel.add(printButton,BorderLayout.CENTER);
        buttonPanel.add(showHistoryButton,BorderLayout.EAST);
        buttonPanel.add(clearButton,BorderLayout.SOUTH);

        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(buttonPanel, BorderLayout.SOUTH);

        SimpleController controller = new SimpleController();

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setNextString(textField.getText());
                controller.printNextString();
                textArea.setText(controller.getNexString());
            }
        });

        showHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for(String str : controller.getHistory()){
                    textArea.append(str+"\n");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textField.setText("");
                controller.clearHistory();
                controller.setNextString("");
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setMinimumSize(new Dimension(sw / PROPORTION, sh / PROPORTION));
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }
    
    public static void main(String[] args){
        new SimpleGUI().display();
    }
}
