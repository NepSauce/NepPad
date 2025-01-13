package com.neppad;

import javax.swing.SwingUtilities;

import com.neppad.swing.PadFrame;

public class NepPad {
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                PadFrame frame = new PadFrame();
                frame.setVisible(true);
            }
        });
    }
}