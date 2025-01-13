package com.neppad.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.neppad.FileHandler;

@SuppressWarnings("FieldMayBeFinal")
public class PadFrame extends JFrame{
    private JTextArea textArea;
    private FileHandler fileHandler;

    public PadFrame(){
        setTitle("Nep Pad");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        fileHandler = new FileHandler(this, textArea);

        setJMenuBar(new PadMenuBar(fileHandler));

        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }


    
}
