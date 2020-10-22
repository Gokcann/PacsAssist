package com.company;

import com.sun.net.httpserver.HttpHandler;
import org.dcm4che3.tool.getscu.GetSCU;

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
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import java.io.*;

class JTableExamples{

    JFrame f;

    //Jtable constructor
    JTableExamples(String[][] obj,String urlArgs, String argIP, String argPort) throws IOException {
        //gelen string dizisini Object tipine donustuyoruz tabloya eklemek iciin
        Object[][] data = new Object[obj.length][16];

        for (int i=0;i<obj.length;i++) {
            //obj nin 12. elemani study instance uid
            String s = obj[i][12].toString();
            //study instance uidye gore thumbnail goruntulerini veren linki olusturmak icin createurl metonuda gonderiyoruz
            URL url = new URL(CreateURL(s,urlArgs));
            //gelen url e get metoduyla baglanip gorseli okuyup bufferlıyoruz
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            urlConnect.setRequestMethod("GET");
            urlConnect.setDoOutput(true);
            urlConnect.setReadTimeout(5000);

            /*burasi daha hizli bir serverda kullanilabilir
            try(InputStream inputStream = urlConnect.getInputStream()) {

                BufferedImage img = ImageIO.read(urlConnect.getInputStream());
                ImageIcon icon = new ImageIcon(resize(img));
                data[i][0] = icon;
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
             */

            //TODO try catch blogu eklenecek image io icin
            //
            while (urlConnect.getResponseCode() != HttpURLConnection.HTTP_INTERNAL_ERROR) {
                BufferedImage img = ImageIO.read(urlConnect.getInputStream());
                if(img != null){
                    ImageIcon icon = new ImageIcon(resize(img));
                    data[i][0] = icon;
                }
                break;
            }
            //modalite turunu ve study id yi aliyoruz yazdirmak icin
            //TODO sadece 3 bilgi degil tum bilgiler alinip jtableda gosterilecek
            //TODO jtable kapatilabilen sutunlar yapilacak(mumkun olmayabilir)
            data[i][1] = obj[i][5];
            data[i][2] = obj[i][12];
            //data[i][3] = obj[i][];
        }

        f = new JFrame();
        f.setTitle("JTable Example");
        //TODO sutun isimleri duzenlenecek
        String[] columnNames = { "Thumbnail", "Modality", "Date" };
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
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setSize(1000, 500);
        f.setVisible(true);

        final int[] row = new int[1];
        final int[] column = new int[1];
        final String[] commandString = new String[1];
        final Process[] process = new Process[1];

        //sadece tabloyu dinleyen click listener metodu
        j.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                File directoryPath = new File("C:\\PacsAssist");
                //list of all files and directories
                File filesList[] = directoryPath.listFiles();

                for(File file : filesList) {

                    file.delete();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (me.getClickCount() == 1) {     // to detect doble click events

                    row[0] = j.getSelectedRow(); // select a row
                    column[0] = j.getSelectedColumn(); // select a column

                    String id = j.getValueAt(row[0], 2).toString();
                    //getscu icin parametre dizisi olusturuluyor
                    //TODO getscu kalkacak onun yerine pacs connector stringlerine gore calisan metot gelecek
                    String[] command3 = new String[6];
                    command3[0] = "-c";
                    String link = "DCM4CHEE@" + argIP + ":" + argPort ;
                    command3[1] = link ;
                    command3[2] = "-m";
                    command3[3] = "StudyInstanceUID="+id;
                    command3[4] = "--directory";
                    command3[5] = "C:\\PacsAssist";
                    GetSCU.main(command3);

                    //auto open for directory
                    //goruntuAc(commandString);
                    try {
                        Process process = new ProcessBuilder("C:\\Program Files\\Weasis\\Weasis.exe", "$dicom:get -l \"C:/PacsAssist\"").start();
                        //System.exit(0);

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }

            }
        });

    }

    public String CreateURL(String s, String url) throws MalformedURLException {

        String h = "wado?requestType=WADO&studyUID=";
        String u = url+ h + s;

        return u;
    }

    public static void main(String[] args) throws IOException {
        //TODO kisillestirme icin belirli parametreler gelecek mesele pencere kapansin yada ekrani kaplasin vs gibi
        /*program buradan basliyor once gelen arg dizisi parse ediliyor
                orn arg; "15736993946" "http://192.168.12.44:8080/dcm4chee-arc/aets/DCM4CHEE/" "192.168.12.44" "11112"
                yukarida yer alan args dizisi .bat dosyasinda da mevcut
         */
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



        /*patient id ornekleri
            185174 *******  186062 ******* 27217  *******   242157  ******* 26   *******   223492   **********
        */

        for (int i = 0 ; i<dataList.size();i++) {
            if( dataList.get(i).PatientsIDV2.equals(patientId) ){
                //kisinin tum bilgilerini daha rahat kullanmak icin list yapisina aliyoruz
                //TODO bu list yapisi ortadan kaldirilacak fazlalik asagidaki kod blogu direkt datalist size uzaerinden islem gorebilir
                patient.add(i);

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
        }

        //jtable sinifinin icine kullanilacak parametreleri gonderiyoruz asagidaki metot baslayinca jframe cizimi basliyor
        new JTableExamples(result,url,argIP,argPort);




    }

    //thumbnailin yeniden boyutlandirilmasi
    public static BufferedImage resize(BufferedImage img) {
        Image tmp = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}

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


}