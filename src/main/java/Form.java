package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Form extends JFrame implements ActionListener {

    JTextArea textArea;
    public Form(){
        super("Set value");
        this.setMinimumSize(new Dimension(300, 300));
        this.setVisible(true);

        Container pane = getContentPane();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("set text");
        textArea = new JTextArea(2,50);
        JButton button = new JButton("ok");
        button.addActionListener(this);

        panel.add(label);
        panel.add(textArea);
        panel.add(button);
        pane.add(panel);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Process process;
        Runtime runtime = Runtime.getRuntime();
        try {
            process = runtime.exec("java -jar artifact-1.jar " + textArea.getText());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        runtime.addShutdownHook(new Thread(process::destroy));
    }
}
