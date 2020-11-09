package com.company;

import static com.company.MainFrame.jTable1;
import static com.company.MainFrame.selected;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Metasoft
 */
public class CheckBoxEditor extends DefaultCellEditor implements ItemListener {

    private static final long serialVersionUID = 1L;
    private JCheckBox checkBox;

    private int row;
    private int column;

    public CheckBoxEditor(JCheckBox checkBox) {
        super(checkBox);
        this.checkBox = checkBox;
        this.checkBox.addItemListener(this);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        this.row = row;
        this.column = column;
        checkBox.setSelected((Boolean) value);
        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
        //checkBox.setSize(10,10);
        //return checkBox;
    }

    //final int[] rows = new int[1];
    public void itemStateChanged(ItemEvent e) {
        try {
        this.fireEditingStopped();
        //rows[0] = jTable1.getSelectedRow(); // select a row
        String id = jTable1.getValueAt(row, 4).toString();
        System.out.println("Item Changed " + row + " value is: " + checkBox.isSelected());

        if (checkBox.isSelected() && (selected.indexOf(id) == -1)) {

            selected.add(id);
            for (int i = 0; i < selected.size(); i++) {
                System.out.println("Selected:" + selected.get(i));
            }
        }
        if (!checkBox.isSelected()) {
            selected.remove(selected.indexOf(id));
            for (int i = 0; i < selected.size(); i++) {
                System.out.println("Selected:" + selected.get(i));
            }
        }
        System.out.println("//////////////////" + selected.size());
        }catch(Exception ex) {
            
        }
    }
}
