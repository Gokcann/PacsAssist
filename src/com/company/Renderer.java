
package com.company;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Metasoft
 */
     //renderer classsi icon tipinde aldigi parametreyi render ederek jtable da kullanima hazir hale getiriyor
    class Renderer extends DefaultTableCellRenderer {

        public Renderer(Icon getIcon) {

        icon = getIcon;

    }
    Icon icon = new ImageIcon();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);


        int neededRow=0; // set the needed row here in which the icon to be dispayed
        int neededColumn=0; // set the needed column here in which the icon to be dispayed

        if(row==neededRow && column==neededColumn)
        {
            setIcon(icon);
        }

        return this;
    }


}
    

