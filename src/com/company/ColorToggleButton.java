/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JToggleButton;

/**
 *
 * @author Metasoft
 */
public class ColorToggleButton extends JToggleButton {
  
    public void paintComponent(Graphics g) {
        Color bg, text;
        if (isSelected()) {
            bg = Color.GRAY;
            text = Color.RED;
        } else {
            bg = Color.GRAY;
            text = Color.BLACK;
        }
        setBackground(bg);
        setForeground(text);
        super.paintComponent(g);
    }
}
