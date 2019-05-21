package io.github.guiritter.sequential_text_file_saver;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * @author Guilherme Alan Ritter
 */
public final class Main {

    static {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Sequential Text File Saver");

        JTextArea area = new JTextArea();
        area.setColumns(20);
        area.setRows(10);
        frame.getContentPane().add(area, BorderLayout.CENTER);
        
        JButton button = new JButton("save");
        frame.getContentPane().add(button, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
