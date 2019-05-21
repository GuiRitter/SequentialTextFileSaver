package io.github.guiritter.sequential_text_file_saver;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * @author Guilherme Alan Ritter
 */
public final class Main {

    private static final String ROOT_PATH = "D:\\social\\eu\\dinheiro\\backup";

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
        button.addActionListener(actionEvent -> {
            Path rootPath = Paths.get(ROOT_PATH);
            short name = (short) (Arrays.stream(rootPath.toFile().listFiles())
                    .map(file -> Short.parseShort(file.getName().substring(0, 5)))
                    .reduce((short) 0, (previous, current) -> (short) Math.max(previous, current)) + 1);
            try {
                Files.write(rootPath.resolve(String.format("%05d.txt", name)),
                        Arrays.asList(area.getText().split("\n")), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "check console", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            area.setText("");
        });
        frame.getContentPane().add(button, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
