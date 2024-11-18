package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final JFrame frame = new JFrame("FILE EDITOR");
    private final int PROPORTION = 4;
    private Controller controller;

    public SimpleGUIWithFileChooser() {
        this.controller = new Controller();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.setContentPane(mainPanel);

        /* File Select Panel */
        JPanel fileSelectPanel = new JPanel();
        fileSelectPanel.setLayout(new BorderLayout());
        mainPanel.add(fileSelectPanel, BorderLayout.NORTH);

        JTextArea fileTextArea = new JTextArea(controller.getCurrentFilePath());
        fileTextArea.setEditable(false);
        fileSelectPanel.add(fileTextArea, BorderLayout.CENTER);

        JButton browseButton = new JButton("BROWSE");
        fileSelectPanel.add(browseButton, BorderLayout.EAST);

        /* Edit Panel */        
        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BorderLayout());
        mainPanel.add(editPanel, BorderLayout.CENTER);
        
        JTextArea dataTextArea = new JTextArea();
        editPanel.add(dataTextArea, BorderLayout.CENTER);
        
        JButton saveButton = new JButton("SAVE");
        editPanel.add(saveButton, BorderLayout.SOUTH);
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.writeDataOnFile(dataTextArea.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showSaveDialog(mainPanel);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    fileTextArea.setText(chooser.getSelectedFile().getPath());
                    controller.setCurrentFile(fileTextArea.getText());
                }else{
                    if(returnVal == JFileChooser.CANCEL_OPTION){

                    }else{
                        JOptionPane.showMessageDialog(frame, null, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
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

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
       new SimpleGUIWithFileChooser().display();
    }
}