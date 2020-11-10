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
            text = Color.RED;
        } else {            
            text = Color.BLACK;
        }        
        setForeground(text);
        super.paintComponent(g);
    }
}
