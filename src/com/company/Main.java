package com.company;

import com.sun.tools.javac.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.activation.ActivationGroupDesc;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.*;

class JTableExamples{

    // frame
    JFrame f;
    // Table
    //JTable j;

    // Constructor
    JTableExamples(String[][] obj) throws IOException {

        Object[][] data = new Object[obj.length][16];
        //BufferedImage img = ImageIO.read(new URL("http://192.168.12.44:8080/dcm4chee-arc/aets/DCM4CHEE/rs/studies/2.16.840.114421.80563.9652876562/thumbnail"));
        //BufferedImage img = ImageIO.read(new URL("http://192.168.12.44:8080/dcm4chee-arc/aets/DCM4CHEE/rs/studies/1.2.792.20200921.142456.6.290.70.2.3947/thumbnail"));
        //ImageIcon[] myIcon = new ImageIcon[data.length];
        for (int i=0;i<obj.length;i++) {
            String s = obj[i][12].toString();
            BufferedImage img = ImageIO.read(new URL(CreateURL(s)));
            ImageIcon icon = new ImageIcon(resize(img));
            //java.net.URL imgUrl = getClass().getResource(CreateURL(s));
            //ImageIcon icon = new ImageIcon(imgUrl);
            //myIcon[i] = icon;
            data[i][0] = icon;
            data[i][1] = obj[i][5];
            data[i][2] = obj[i][12];
            //data[i][3] = obj[i][];
        }

        //BufferedImage img = ImageIO.read(new URL("http://192.168.12.132:8080/dcm4chee-arc/aets/DCM4CHEE_ADMIN/wado?requestType=WADO&studyUID=1.2.840.20200203.112320.022.0.192168.1282.3088"));

        // Frame initiallization
        f = new JFrame();

        // Frame Title
        f.setTitle("JTable Example");

        //add thumbnails
//        Icon icon1 = new ImageIcon("th1.png");
//        Icon icon2 = new ImageIcon("th2.png");
//        Icon icon3 = new ImageIcon("th3.png");

        // Data to be displayed in the JTable
//        Object[][] data = {
//                { "icon1", "4031", "CSE" },
//                { "icon2", "6014", "IT" }
//        };

        // Column Names
        String[] columnNames = { "Thumbnail", "Modality", "Date" };

        // Initializing the JTable
        //j = new JTable(data, columnNames);
        //j.setBounds(30, 40, 200, 300);
        //j.setRowHeight(100);
        //j.setValueAt(renderer(new ImageIcon(resize(img))),0,0);
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                switch(column) {
                    case 0: return ImageIcon.class;
                    case 1: return Object.class;
                    case 2: return Object.class;
                    default: return Object.class;
                }
            }
        };

        JTable j = new JTable(model);
        j.setDefaultEditor(Object.class, null);
        j.setRowHeight(100);

        //j.getColumn("Thumbnail").setCellRenderer(new renderer(new ImageIcon(resize(img))));


        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(1000, 500);
        // Frame Visible = true
        f.setVisible(true);

        final int[] row = new int[1];
        final int[] column = new int[1];
        final String[] commandString = new String[1];
        final Process[] process = new Process[1];
        //sadece tabloyu dinleyen click listener metodu
        j.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                if (me.getClickCount() == 1) {     // to detect doble click events
                    row[0] = j.getSelectedRow(); // select a row
                    column[0] = j.getSelectedColumn(); // select a column
                    //JOptionPane.showMessageDialog(null, j.getValueAt(row[0], 2)); // get the value of a row and column.
                    commandString[0] = "$dicom:get -w \"http://192.168.12.132:8080/weasis-pacs-connector/manifest?studyUID=" + j.getValueAt(row[0], 2) +"\"";
                    System.out.println(commandString[0]);
                    //auto open for directory
                    //goruntuAc(commandString);
                    try {
                        Process process = new ProcessBuilder("C:\\Program Files\\Weasis\\Weasis.exe", commandString[0]).start();
                        //Process process = new ProcessBuilder("C:\\Program Files\\Weasis\\Weasis.exe" , "$dicom:get -w \"http://192.168.12.132:8080/weasis-pacs-connector/manifest?studyUID=1.2.840.20200203.112320.022.0.192168.1282.3088\"").start();
                        //f.dispose();
                        System.exit(0);


                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }

            }
        });

    }
    public void goruntuAc(String[] s){

    }

    public String CreateURL(String s) throws MalformedURLException {

        String h = "http://192.168.12.132:8080/dcm4chee-arc/aets/DCM4CHEE_ADMIN/wado?requestType=WADO&studyUID=";
        String u = h + s;

        return u;
    }

    public static void main(String[] args) throws IOException {

        StudyQuery query = new StudyQuery();
        QueryProcess response = new QueryProcess();
        StudyData studyData = new StudyData();
        ArrayList<StudyData> dataList;
        //ArrayList<StudyData> dataList2 = new ArrayList<>();
        List<Integer> patient = new ArrayList<Integer>();
        //query.MwlQuery(response.QueryProcessMethod().toString());
        dataList=query.StudyQueryParse(response.QueryProcessMethod().toString());



        for (int i = 0 ; i<dataList.size();i++) {
            if( dataList.get(i).PatientsIDV2.equals("53713748738") ){
                
                patient.add(i);
//                System.out.println("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
//                System.out.println(dataList.get(i).SpecificCharacterSetV2);
//                System.out.println(dataList.get(i).StudyDateV2);
//                System.out.println(dataList.get(i).AccessionNumberV2);
//                System.out.println(dataList.get(i).RetrieveAETitleV2);
//                System.out.println(dataList.get(i).InstanceAvailabilityV2);
//                System.out.println(dataList.get(i).ModalitiesInStudyV2);
//                System.out.println(dataList.get(i).ReferringPhysiciansNameV2);
//                System.out.println(dataList.get(i).RetrieveURLV2);
//                System.out.println(dataList.get(i).PatientsNameV2);
//                System.out.println(dataList.get(i).PatientsIDV2);
//                System.out.println(dataList.get(i).PatientsBirthDateV2);
//                System.out.println(dataList.get(i).PatientsSexV2);
//                System.out.println(dataList.get(i).StudyInstanceUIDV2);
//                System.out.println(dataList.get(i).StudyIDV2);
//                System.out.println(dataList.get(i).NumberofStudyRelatedSeriesV2);
//                System.out.println(dataList.get(i).NumberofStudyRelatedInstancesV2);
//                System.out.println("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
            }

        }
        String[][] result =new String[patient.size()][16];

            for (int i=0;i<patient.size();i++) {
                result[i][0] = dataList.get(patient.get(i)).SpecificCharacterSetV2.toString();
                result[i][1] = dataList.get(patient.get(i)).StudyDateV2.toString();
                result[i][2] = dataList.get(patient.get(i)).AccessionNumberV2.toString();
                result[i][3] = dataList.get(patient.get(i)).RetrieveAETitleV2.toString();
                result[i][4] = dataList.get(patient.get(i)).InstanceAvailabilityV2.toString();
                result[i][5] = dataList.get(patient.get(i)).ModalitiesInStudyV2.toString();
                result[i][6] = dataList.get(patient.get(i)).ReferringPhysiciansNameV2.toString();
                result[i][7] = dataList.get(patient.get(i)).RetrieveURLV2.toString();
                result[i][8] = dataList.get(patient.get(i)).PatientsNameV2.toString();
                result[i][9] = dataList.get(patient.get(i)).PatientsIDV2.toString();
                result[i][10] = dataList.get(patient.get(i)).PatientsBirthDateV2.toString();
                result[i][11] = dataList.get(patient.get(i)).PatientsSexV2.toString();
                result[i][12] = dataList.get(patient.get(i)).StudyInstanceUIDV2.toString();
                result[i][13] = dataList.get(patient.get(i)).StudyIDV2.toString();
                result[i][14] = dataList.get(patient.get(i)).NumberofStudyRelatedSeriesV2.toString();
                result[i][15] = dataList.get(patient.get(i)).NumberofStudyRelatedInstancesV2.toString();
            }


        new JTableExamples(result);



    }

    public static BufferedImage resize(BufferedImage img) {
        Image tmp = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}

class renderer extends DefaultTableCellRenderer {

    public renderer(Icon getIcon) {
        // TODO Auto-generated constructor stub

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