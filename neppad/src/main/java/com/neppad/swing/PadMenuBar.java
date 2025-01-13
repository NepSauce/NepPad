package com.neppad.swing;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.neppad.FileHandler;

public class PadMenuBar extends JMenuBar{
    public PadMenuBar(FileHandler fileHandler){
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(createMenuItem("Open", e -> fileHandler.openFile()));
        fileMenu.add(createMenuItem("Save", e -> fileHandler.saveFile(false)));
        fileMenu.add(createMenuItem("Save As", e -> fileHandler.saveFile(true)));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem("Exit", e -> System.exit(0)));

        add(fileMenu);
    }

    private JMenuItem createMenuItem(String text, ActionListener action){
        JMenuItem item = new JMenuItem(text);
        item.addActionListener(action);
        return item;
    }
}
