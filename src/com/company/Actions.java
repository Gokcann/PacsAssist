/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import static com.company.MainFrame.jBugunTButton;
import static com.company.MainFrame.jTable1;
import static com.company.MainFrame.selected;
import java.awt.Desktop;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Metasoft
 */
public class Actions {

    public void openWeb(String argIP, String webPort, String patientId) {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            String webURL = "http://" + argIP + ":" + webPort + "/incele?id=" + patientId;
            URI oURL = new URI(webURL);
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectedComboBox(String queryMod, boolean filtCheck) {
        MainFrame.selected.clear();
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(sorter);
        //String queryMod = jModalityCombo.getSelectedItem().toString();

        RowFilter<DefaultTableModel, Object> firstFiler = null;

        List<RowFilter<DefaultTableModel, Object>> filters = new ArrayList<RowFilter<DefaultTableModel, Object>>();
        RowFilter<DefaultTableModel, Object> compoundRowFilter = null;
        try {
            firstFiler = RowFilter.regexFilter(queryMod, 1);

            filters.add(firstFiler);

            compoundRowFilter = RowFilter.andFilter(filters); // you may also choose the OR filter
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        if (filtCheck) {            
            sorter.setRowFilter(compoundRowFilter);
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                jTable1.setValueAt(true, i, 6);
            }
        } else if (MainFrame.jBirYilTButton.isSelected()) {

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                jTable1.setValueAt(false, i, 6);
                if (jTable1.getModel().getValueAt(i, 1).toString().contains(queryMod)) {
                    MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                    jTable1.setValueAt(true, i, 6);
                }
            }
            birYilFiltre(filtCheck);
        } else if (MainFrame.jAltiAyTButton.isSelected()) {

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                jTable1.setValueAt(false, i, 6);
                if (jTable1.getModel().getValueAt(i, 1).toString().contains(queryMod)) {
                    MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                    jTable1.setValueAt(true, i, 6);
                }
            }
            altiAyFiltre(filtCheck);
        }else if (MainFrame.jBirAyTButton.isSelected()) {

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                jTable1.setValueAt(false, i, 6);
                if (jTable1.getModel().getValueAt(i, 1).toString().contains(queryMod)) {
                    MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                    jTable1.setValueAt(true, i, 6);
                }
            }
            birAyFiltre(filtCheck);
        }else if (MainFrame.jDunTButton.isSelected()) {

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                jTable1.setValueAt(false, i, 6);
                if (jTable1.getModel().getValueAt(i, 1).toString().contains(queryMod)) {
                    MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                    jTable1.setValueAt(true, i, 6);
                }
            }
            dunFiltre(filtCheck);
        }else if (MainFrame.jBugunTButton.isSelected()) {

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                jTable1.setValueAt(false, i, 6);
                if (jTable1.getModel().getValueAt(i, 1).toString().contains(queryMod)) {
                    MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                    jTable1.setValueAt(true, i, 6);
                }
            }
            bugunFiltre(filtCheck);
        }else {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                jTable1.setValueAt(false, i, 6);
                if (jTable1.getModel().getValueAt(i, 1).toString().contains(queryMod)) {
                    MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                    jTable1.setValueAt(true, i, 6);
                }
            }
        }
    }

    public void tumZamanlarFiltre() {
        MainFrame.selected.clear();

        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> firstFiler = null;

        List<RowFilter<DefaultTableModel, Object>> filters = new ArrayList<RowFilter<DefaultTableModel, Object>>();
        RowFilter<DefaultTableModel, Object> compoundRowFilter = null;
        try {
            firstFiler = RowFilter.regexFilter("", 2);

            filters.add(firstFiler);

            compoundRowFilter = RowFilter.andFilter(filters); // you may also choose the OR filter
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(compoundRowFilter);

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
            if (MainFrame.jHepsiTButton.isSelected()) {
                jTable1.setValueAt(true, i, 6);
            } else {
                jTable1.setValueAt(false, i, 6);
                selected.clear();
            }
        }
    }

    public void birYilFiltre(boolean filtcheck) {
        String queryMod = MainFrame.jModalityCombo.getSelectedItem().toString();
        if (!queryMod.equals("")){  
        }
        else{
         MainFrame.selected.clear();
        }
            
        if (filtcheck) {            
            try {
                SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
                Date now = new Date();
                String a = formater.format(now);

                Date now2 = formater.parse(a);
                System.out.print(now2);

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MONTH, -12);
                Date endDate = cal.getTime();
                String b = formater.format(endDate);

                Date date4 = formater.parse(b);
                System.out.print(date4.toString());

                DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(table);
                jTable1.setRowSorter(sorter);
                List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(5);
                filters.add(RowFilter.dateFilter(ComparisonType.AFTER, date4));
                filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, now2));
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.andFilter(filters);
                sorter.setRowFilter(rf);
            } catch (ParseException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                if (MainFrame.jBirYilTButton.isSelected()) {
                    jTable1.setValueAt(true, i, 6);
                } else {
                    jTable1.setValueAt(false, i, 6);
                    selected.remove(jTable1.getValueAt(i, 4).toString());
                }
            }
        } else {
            for (int k = 0; k < 366; k++) {
                Calendar cal = Calendar.getInstance();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                cal.add(Calendar.DATE, -k);
                for (int i = 0; i < jTable1.getRowCount(); i++) {

                    if (jTable1.getModel().getValueAt(i, 2).equals(dateFormat.format(cal.getTime()))) {
                        MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                        if (MainFrame.jBirYilTButton.isSelected()) {
                            jTable1.setValueAt(true, i, 6);
                        } else {
                            jTable1.setValueAt(false, i, 6);
                            selected.remove(jTable1.getValueAt(i, 4).toString());
                        }
                    }
                }
            }
        }
    }

    public void altiAyFiltre(boolean filtcheck) {
        String queryMod = MainFrame.jModalityCombo.getSelectedItem().toString();
        if (!queryMod.equals("")){  
        }
        else{
         MainFrame.selected.clear();
        }
        if (filtcheck) {
            try {
                SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
                Date now = new Date();
                String a = formater.format(now);

                Date now2 = formater.parse(a);
                System.out.print(now2);

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MONTH, -6);
                Date endDate = cal.getTime();
                String b = formater.format(endDate);

                Date date4 = formater.parse(b);
                System.out.print(date4.toString());

                DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(table);
                jTable1.setRowSorter(sorter);
                List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(5);
                filters.add(RowFilter.dateFilter(ComparisonType.AFTER, date4));
                filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, now2));
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.andFilter(filters);
                sorter.setRowFilter(rf);
            } catch (ParseException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                if (MainFrame.jAltiAyTButton.isSelected()) {
                    jTable1.setValueAt(true, i, 6);
                } else {
                    jTable1.setValueAt(false, i, 6);
                    selected.remove(jTable1.getValueAt(i, 4).toString());
                }
            }
        } else {
            for (int k = 0; k < 185; k++) {
                Calendar cal = Calendar.getInstance();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                cal.add(Calendar.DATE, -k);
                for (int i = 0; i < jTable1.getRowCount(); i++) {

                    if (jTable1.getModel().getValueAt(i, 2).equals(dateFormat.format(cal.getTime()))) {
                        MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                        if (MainFrame.jAltiAyTButton.isSelected()) {
                            jTable1.setValueAt(true, i, 6);
                        } else {
                            jTable1.setValueAt(false, i, 6);
                            selected.remove(jTable1.getValueAt(i, 4).toString());
                        }
                    }
                }
            }
        }
    }

    public void birAyFiltre(boolean filtcheck) {
        String queryMod = MainFrame.jModalityCombo.getSelectedItem().toString();
        if (!queryMod.equals("")){  
        }
        else{
         MainFrame.selected.clear();
        }
        if (filtcheck) {
            try {
                SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
                Date now = new Date();
                String a = formater.format(now);

                Date now2 = formater.parse(a);
                System.out.print(now2);

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MONTH, -1);
                Date endDate = cal.getTime();
                String b = formater.format(endDate);

                Date date4 = formater.parse(b);
                System.out.print(date4.toString());

                DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(table);
                jTable1.setRowSorter(sorter);
                List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(5);
                filters.add(RowFilter.dateFilter(ComparisonType.AFTER, date4));
                filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, now2));
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.andFilter(filters);
                sorter.setRowFilter(rf);
            } catch (ParseException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                if (MainFrame.jBirAyTButton.isSelected()) {
                    jTable1.setValueAt(true, i, 6);
                } else {
                    jTable1.setValueAt(false, i, 6);
                    selected.remove(jTable1.getValueAt(i, 4).toString());
                }
            }
        } else {
            for (int k = 0; k < 32; k++) {
                Calendar cal = Calendar.getInstance();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                cal.add(Calendar.DATE, -k);
                for (int i = 0; i < jTable1.getRowCount(); i++) {

                    if (jTable1.getModel().getValueAt(i, 2).equals(dateFormat.format(cal.getTime()))) {
                        MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                        if (MainFrame.jBirAyTButton.isSelected()) {
                            jTable1.setValueAt(true, i, 6);
                        } else {
                            jTable1.setValueAt(false, i, 6);
                            selected.remove(jTable1.getValueAt(i, 4).toString());
                        }
                    }
                }
            }
        }
    }

    public void dunFiltre(boolean filtcheck) {
        //MainFrame.selected.clear();
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        cal.add(Calendar.DATE, -1);
        System.out.println("Yesterday's date was " + dateFormat.format(cal.getTime()));

        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(sorter);
        RowFilter<DefaultTableModel, Object> firstFiler = null;

        List<RowFilter<DefaultTableModel, Object>> filters = new ArrayList<RowFilter<DefaultTableModel, Object>>();
        RowFilter<DefaultTableModel, Object> compoundRowFilter = null;
        try {
            firstFiler = RowFilter.regexFilter(dateFormat.format(cal.getTime()), 2);

            filters.add(firstFiler);

            compoundRowFilter = RowFilter.andFilter(filters); // you may also choose the OR filter
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        if (filtcheck) {
            sorter.setRowFilter(compoundRowFilter);
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                if (MainFrame.jDunTButton.isSelected()) {
                    jTable1.setValueAt(true, i, 6);
                } else {
                    jTable1.setValueAt(false, i, 6);
                    selected.remove(jTable1.getValueAt(i, 4).toString());
                }
            }
        } else {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                //jTable1.setValueAt(false, i, 6);
                if (jTable1.getModel().getValueAt(i, 2).equals(dateFormat.format(cal.getTime()))) {
                    MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                    if (MainFrame.jDunTButton.isSelected()) {
                        jTable1.setValueAt(true, i, 6);
                    } else {
                        jTable1.setValueAt(false, i, 6);
                        selected.remove(jTable1.getValueAt(i, 4).toString());
                    }
                }
            }
        }
    }

    public void bugunFiltre(boolean filtcheck) {
        //MainFrame.selected.clear();
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        cal.add(Calendar.DATE, 0);
        System.out.println("Today " + dateFormat.format(cal.getTime()));

        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(sorter);
        RowFilter<DefaultTableModel, Object> firstFiler = null;

        List<RowFilter<DefaultTableModel, Object>> filters = new ArrayList<RowFilter<DefaultTableModel, Object>>();
        RowFilter<DefaultTableModel, Object> compoundRowFilter = null;
        try {
            firstFiler = RowFilter.regexFilter(dateFormat.format(cal.getTime()), 2);

            filters.add(firstFiler);

            compoundRowFilter = RowFilter.andFilter(filters); // you may also choose the OR filter
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }

        if (filtcheck) {
            sorter.setRowFilter(compoundRowFilter);
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                if (jBugunTButton.isSelected()) {
                    jTable1.setValueAt(true, i, 6);
                } else {
                    jTable1.setValueAt(false, i, 6);
                    selected.remove(jTable1.getValueAt(i, 4).toString());
                }
            }
        } else {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                //jTable1.setValueAt(false, i, 6);
                if (jTable1.getModel().getValueAt(i, 2).equals(dateFormat.format(cal.getTime()))) {
                    MainFrame.selected.add(jTable1.getValueAt(i, 4).toString());
                    if (jBugunTButton.isSelected()) {
                        jTable1.setValueAt(true, i, 6);
                    } else {
                        jTable1.setValueAt(false, i, 6);
                        selected.remove(jTable1.getValueAt(i, 4).toString());
                    }
                }
            }
        }
    }

}
