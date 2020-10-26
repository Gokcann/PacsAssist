package com.company;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;
/*
class JTableExamples{

    JFrame f;
    List selected = new ArrayList();

    //JTable constructor
    JTableExamples(String[][] obj,String urlArgs, String argIP, String argPort) throws IOException {

        f = new JFrame();
        f.setTitle("METASOFT  PACS-ASSIST");
        //gelen string dizisini Object tipine donustuyoruz tabloya eklemek iciin
        Object[][] data = new Object[obj.length][16];
        StudyOpen studyOpen = new StudyOpen();
        UrlCreator urlCreator = new UrlCreator();
        GetThumb getThumb = new GetThumb();

        for (int i=0;i<obj.length;i++) {

            data[i][0] = getThumb.GetThumbnail(obj , i , urlArgs , argIP , argPort);
            //modalite turunu ve study id yi aliyoruz yazdirmak icin
            data[i][1] = obj[i][5];
            data[i][2] = obj[i][12];
            data[i][3] = false;

        }

        String[] columnNames = { "Thumbnail", "Modality", "Date", "Secim" };
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                switch(column) {
                    case 0: return ImageIcon.class;
                    case 1: return Object.class;
                    case 2: return Object.class;
                    case 3: return Boolean.class;
                    default: return Object.class;
                }
            }
        };

        JTable j = new JTable(model);
        j.setDefaultEditor(Object.class, null);
        j.getColumnModel().getColumn(3).setCellEditor(new CheckBoxEditor(new JCheckBox()));
        j.setRowHeight(100);
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setSize(1000, 500);
        f.setVisible(true);

        final int[] row = new int[1];
        //sadece tabloyu dinleyen click listener metodu
        j.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                if (me.getClickCount() == 2) {     // to detect doble click events

                    row[0] = j.getSelectedRow(); // select a row
                    String id = j.getValueAt(row[0], 2).toString();
                    //studyOpen.StudyOpenWeasis(urlCreator.CreateURLConnector(argIP,argPort,id));

                }

            }
        });



    }
*/
/*

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

        public void itemStateChanged(ItemEvent e) {
            this.fireEditingStopped();
            System.out.println("Item Changed " + row + " value is: " + checkBox.isSelected());
            if( checkBox.isSelected() && (selected.indexOf(row) ==-1) ) {
                selected.add(row);
                for (int i =0;i<selected.size();i++) {
                    System.out.println("Selected:" + selected.get(i));
                }
            }
            if(!checkBox.isSelected()) {
                selected.remove(selected.indexOf(row));
                for (int i =0;i<selected.size();i++) {
                    System.out.println("Selected:" + selected.get(i));
                }
            }
        }

    }

*/

  //  public static void main(String[] args) throws IOException {
        //TODO kisillestirme icin belirli parametreler gelecek mesela pencere kapansin yada ekrani kaplasin vs gibi
        /*program buradan basliyor once gelen arg dizisi parse ediliyor
                orn arg; "15736993946" "http://192.168.12.44:8080/dcm4chee-arc/aets/DCM4CHEE/" "192.168.12.44" "11112"
                yukarida yer alan args dizisi .bat dosyasinda da mevcut
         */
/*
        String patientId = args[0];
        String url = args[1];
        String argIP = args[2];
        String argPort = args[3];

        StudyQuery query = new StudyQuery();
        QueryProcess response = new QueryProcess();
        StudyData studyData = new StudyData();
        ArrayList<StudyData> dataList;
        List<Integer> patient = new ArrayList<Integer>();
        //patient id ye gore query olusturup gelen json datasini parse ediyoruz ve study data tipindeki arraylistimize aliyoruz
        dataList=query.StudyQueryParse(response.QueryProcessMethod(url,patientId).toString());
        String[][] result =new String[dataList.size()][16];

        for (int i = 0 ; i<dataList.size();i++)  {
            //bu if blogunun gerekliligi tartismaya acik
            if( dataList.get(i).PatientsIDV2.equals(patientId) ){

                //kisinin tum bilgilerini daha rahat kullanmak icin list yapisina aliyoruz
                result[i][0] = dataList.get(i).SpecificCharacterSetV2;
                result[i][1] = dataList.get(i).StudyDateV2;
                result[i][2] = dataList.get(i).AccessionNumberV2;
                result[i][3] = dataList.get(i).RetrieveAETitleV2;
                result[i][4] = dataList.get(i).InstanceAvailabilityV2;
                result[i][5] = dataList.get(i).ModalitiesInStudyV2;
                result[i][6] = dataList.get(i).ReferringPhysiciansNameV2;
                result[i][7] = dataList.get(i).RetrieveURLV2;
                result[i][8] = dataList.get(i).PatientsNameV2;
                result[i][9] = dataList.get(i).PatientsIDV2;
                result[i][10] = dataList.get(i).PatientsBirthDateV2;
                result[i][11] = dataList.get(i).PatientsSexV2;
                result[i][12] = dataList.get(i).StudyInstanceUIDV2;
                result[i][13] = dataList.get(i).StudyIDV2;
                result[i][14] = dataList.get(i).NumberofStudyRelatedSeriesV2;

            }

        }

        //jtable sinifinin icine kullanilacak parametreleri gonderiyoruz asagidaki metot baslayinca jframe cizimi basliyor
        new JTableExamples(result,url,argIP,argPort);

    }

}
*/


/*
    //renderer classsi icon tipinde aldigi parametreyi render ederek jtable da kullanima hazir hale getiriyor
    class renderer extends DefaultTableCellRenderer {

        public renderer(Icon getIcon) {

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



}*/
