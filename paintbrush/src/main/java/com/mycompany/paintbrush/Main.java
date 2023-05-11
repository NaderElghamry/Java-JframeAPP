
package com.mycompany.paintbrush;

import java.awt.Color;
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {

        JFrame j= new JFrame();
        PaintBrush brush =new PaintBrush();
        j.setContentPane(brush);
        j.setVisible(true);
        j.setTitle("Paint Brush");
        j.setSize(1800, 1000);
        j.setBackground(Color.WHITE);
    //    brush.setBackground(Color.BLACK);


    }



}