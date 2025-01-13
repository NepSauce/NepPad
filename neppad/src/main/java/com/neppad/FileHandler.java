package com.neppad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("FieldMayBeFinal")
public class FileHandler{
    private JFrame frame;
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public FileHandler(JFrame frame, JTextArea textArea){
        this.frame = frame;
        this.textArea = textArea;
        this.fileChooser = new JFileChooser();
    }

    public void openFile(){
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                textArea.read(reader, null);
            }
            catch (IOException e){
                showError("Error Opening File: " + e.getMessage());
            }
        }
    }

    public void saveFile(boolean saveAs){
        File file;

        if (saveAs || fileChooser.getSelectedFile() == null){
            int result = fileChooser.showSaveDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION){
                file = fileChooser.getSelectedFile();
            }
            else{
                file = fileChooser.getSelectedFile();
            }

            if (file != null){
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                    textArea.write(writer);
                }
                catch (IOException e){
                    showError("Error Saving File: " + e.getMessage());
                }
            }
        }
    }

    private void showError(String message){
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
