/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

//import static com.company.JTableExamples.resize;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Metasoft
 */
public class MainFrame extends javax.swing.JFrame {

    public static List selected = new ArrayList();
    public static String argPort;
    public static String argIP;
    public static String url;
    public static String patientId;
    public static String webPort;
    UrlCreator urlCreator = new UrlCreator();
    StudyOpen studyOpen = new StudyOpen();
    URL url3 = MainFrame.class.getResource("/Logo.png");
    Actions actions = new Actions();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

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

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jWeasisButton = new javax.swing.JButton();
        jWebViewerButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPatientName = new javax.swing.JLabel();
        jPatientID = new javax.swing.JLabel();
        jPatientSex = new javax.swing.JLabel();
        jPatientBirthDate = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Yenile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jFiltCheck = new javax.swing.JCheckBox();
        jBugunButton = new javax.swing.JButton();
        jDunButton = new javax.swing.JButton();
        jBirAyButton = new javax.swing.JButton();
        jAltiAyButton = new javax.swing.JButton();
        jBirYılButton = new javax.swing.JButton();
        jButunButton = new javax.swing.JButton();
        jModalityCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PacsAssist");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url3));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thumbnail", "Modality", "Study Date", "Yönlendiren", "Study Instance UID", "Seçilen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        jWeasisButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/next.png"))); // NOI18N
        jWeasisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWeasisButtonActionPerformed(evt);
            }
        });

        jWebViewerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data-transfer.png"))); // NOI18N
        jWebViewerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWebViewerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jWebViewerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jWeasisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jWeasisButton, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jWebViewerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 57, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hasta Bilgileri"));

        jPatientName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPatientName.setText("Hastanın Adı Soyadı     :");

        jPatientID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPatientID.setText("Hastanın TC Numarası :");

        jPatientSex.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPatientSex.setText("Hastanın Cinsiyeti        :");

        jPatientBirthDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPatientBirthDate.setText("Hastanın Yaşı              :");
        jPatientBirthDate.setMaximumSize(new java.awt.Dimension(187, 22));
        jPatientBirthDate.setMinimumSize(new java.awt.Dimension(187, 22));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPatientBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPatientSex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPatientID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPatientName, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPatientName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPatientID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPatientSex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPatientBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        Yenile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        Yenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YenileActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajax-loader.gif"))); // NOI18N
        jLabel1.setDisabledIcon(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Yenile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Yenile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jFiltCheck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFiltCheck.setText("Filtreleme");

        jBugunButton.setText("Bugün");
        jBugunButton.setMaximumSize(new java.awt.Dimension(75, 23));
        jBugunButton.setMinimumSize(new java.awt.Dimension(75, 23));
        jBugunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBugunButtonActionPerformed(evt);
            }
        });

        jDunButton.setText("Dün");
        jDunButton.setMaximumSize(new java.awt.Dimension(75, 23));
        jDunButton.setMinimumSize(new java.awt.Dimension(75, 23));
        jDunButton.setPreferredSize(new java.awt.Dimension(51, 40));
        jDunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDunButtonActionPerformed(evt);
            }
        });

        jBirAyButton.setText("Son 1 Ay");
        jBirAyButton.setPreferredSize(new java.awt.Dimension(75, 40));
        jBirAyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBirAyButtonActionPerformed(evt);
            }
        });

        jAltiAyButton.setText("Son 6 Ay");
        jAltiAyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAltiAyButtonActionPerformed(evt);
            }
        });

        jBirYılButton.setText("Son 1 Yıl");
        jBirYılButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBirYılButtonActionPerformed(evt);
            }
        });

        jButunButton.setText("Bütün Tarihler");
        jButunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButunButtonActionPerformed(evt);
            }
        });

        jModalityCombo.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jModalityCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "CT", "PX", "CX", "OT", "XC", "CR", "KO", "IO" }));
        jModalityCombo.setToolTipText("");
        jModalityCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModalityComboActionPerformed(evt);
            }
        });

        jLabel5.setText("Modality Filtresi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBugunButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDunButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFiltCheck, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBirAyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBirYılButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jAltiAyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jModalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFiltCheck)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jModalityCombo)
                    .addComponent(jBugunButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jAltiAyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jDunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBirYılButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBirAyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void YenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YenileActionPerformed
        String[][] result3 = null;
        try {
            result3 = baslangic();
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            new MainFrame(result3, url, argIP, argPort);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_YenileActionPerformed

    private void jWebViewerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWebViewerButtonActionPerformed
        actions.openWeb(argIP,webPort,patientId);
    }//GEN-LAST:event_jWebViewerButtonActionPerformed

    private void jWeasisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWeasisButtonActionPerformed
        // TODO add your handling code here:
        if (selected.size() > 0) {
            studyOpen.StudyOpenWeasis(urlCreator.CreateURLConnector(argIP, argPort, selected));
        }
        System.out.println("*************");
        System.out.println(selected.size());
    }//GEN-LAST:event_jWeasisButtonActionPerformed

    private void jModalityComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModalityComboActionPerformed

        String queryMod = jModalityCombo.getSelectedItem().toString();
        actions.selectedComboBox(queryMod,jFiltCheck.isSelected());
       
    }//GEN-LAST:event_jModalityComboActionPerformed

    private void jButunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButunButtonActionPerformed

        actions.tumZamanlarFiltre();
        
    }//GEN-LAST:event_jButunButtonActionPerformed

    private void jBirYılButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBirYılButtonActionPerformed

        actions.birYilFiltre(jFiltCheck.isSelected());
        
    }//GEN-LAST:event_jBirYılButtonActionPerformed

    private void jAltiAyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAltiAyButtonActionPerformed
        actions.altiAyFiltre(jFiltCheck.isSelected());
    }//GEN-LAST:event_jAltiAyButtonActionPerformed

    private void jBirAyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBirAyButtonActionPerformed
        actions.birAyFiltre(jFiltCheck.isSelected());
    }//GEN-LAST:event_jBirAyButtonActionPerformed

    private void jDunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDunButtonActionPerformed
        // TODO add your handling code here:
        actions.dunFiltre(jFiltCheck.isSelected());
    }//GEN-LAST:event_jDunButtonActionPerformed

    private void jBugunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBugunButtonActionPerformed
        actions.bugunFiltre(jFiltCheck.isSelected());
        
    }//GEN-LAST:event_jBugunButtonActionPerformed

    MainFrame(String[][] obj, String urlArgs, String argIP, String argPort) throws IOException {
        //gelen string dizisini Object tipine donustuyoruz tabloya eklemek iciin
        Object[][] data = new Object[obj.length][16];

        GetThumb getThumb = new GetThumb();

        for (int i = 0; i < obj.length; i++) {

            data[i][0] = getThumb.GetThumbnail(obj, i, urlArgs, argIP, argPort);
            //modalite turunu ve study id yi aliyoruz yazdirmak icin
            data[i][1] = obj[i][5];
            data[i][2] = obj[i][12];
            data[i][3] = false;

            //modalite turunu ve study id yi aliyoruz yazdirmak icin
            //TODO sadece 3 bilgi degil tum bilgiler alinip jtableda gosterilecek
            //TODO jtable kapatilabilen sutunlar yapilacak(mumkun olmayabilir)
            String isim = obj[i][8];
            String isim1 = isim.replace('^', ' ');
            jPatientName.setText("Hastanın Adı Soyadı     : " + isim1);
            jPatientID.setText("Hastanın TC Numarası : " + obj[i][9]);
            String birthdate = obj[i][10].toString();
            int a2 = birthdate.length();
            String bb = Integer.toString(a2);
            if (bb.equals("8")) {
                String yyyy = birthdate.substring(0, 4);
                String MM = birthdate.substring(4, 6);
                String dd = birthdate.substring(6, 8);
                int a = Integer.parseInt(dd);
                int b = Integer.parseInt(MM);
                int c = Integer.parseInt(yyyy);
                Date zaman = new Date();
                DateFormat sD = new SimpleDateFormat("dd");
                DateFormat sM = new SimpleDateFormat("MM");
                DateFormat sY = new SimpleDateFormat("yyyy");
                int x = Integer.parseInt(sD.format(zaman));
                int y = Integer.parseInt(sM.format(zaman));
                int z = Integer.parseInt(sY.format(zaman));
                int gun, ay, yil;
                if (x < a) {
                    gun = x - a + 30;
                    --y;
                } else {
                    gun = x - a;
                }
                if (y < b) {
                    ay = y - b + 12;
                    --z;
                } else {
                    ay = y - b;
                }
                yil = z - c;
                jPatientBirthDate.setText("Hastanın Yaşı              : " + yil);
            }
            String sex = obj[i][11];
            if (sex.equals("F")) {
                String sex1 = sex.replace("F", "K");
                jPatientSex.setText("Hastanın Cinsiyeti        : " + sex1);
            } else {
                String sex1 = sex.replace("M", "E");
                jPatientSex.setText("Hastanın Cinsiyeti        : " + sex1);
            }
            String a = obj[i][1].toString();
            if (a.length() != 0) {
                try {
                    String yyyy = a.substring(0, 4);
                    String MM = a.substring(4, 6);
                    String dd = a.substring(6, 8);
                    a = dd + "-" + MM + "-" + yyyy;
                    SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
                    Date ab = formater.parse(a);
                    data[i][2] = dd + "-" + MM + "-" + yyyy;
                    data[i][5] = ab;
                } catch (ParseException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            data[i][1] = obj[i][5] + "  -  " + obj[i][14];
            data[i][3] = obj[i][6];
            data[i][4] = obj[i][12];
            data[i][6] = false;

        }

        //TODO sutun isimleri duzenlenecek
        String[] columnNames = {"Thumbnail", "Modality", "Study Date", "Yonlendiren", "Study Instance UID", "boş tarih", "Seçilen"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return ImageIcon.class;
                    case 6:
                        return Boolean.class;
                    default:
                        return Object.class;
                }
            }
        };

        //jScrollPane1.setOpaque(false);
        //jScrollPane1.getViewport().setOpaque(false);
        jLabel1.setDisabledIcon(new ImageIcon(getClass().getResource("/null.png")));
        jLabel1.setEnabled(false);
        jTable1.setModel(model);
        //jTable1.setShowGrid(false);
        jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(25, 0));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getColumnModel().getColumn(6).setCellEditor(new CheckBoxEditor(new JCheckBox()));
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setRowHeight(100);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(2).setMinWidth(0);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(3).setMinWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(175);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(220);
            jTable1.getColumnModel().getColumn(0).setMinWidth(250);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(500);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(6).setMinWidth(50);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(100);
        }
        //DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        //.setHorizontalAlignment( JLabel.CENTER );
        //j.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

        final int[] row = new int[1];
        final int[] column = new int[1];
        final String[] commandString = new String[1];
        final Process[] process = new Process[1];

        //sadece tabloyu dinleyen click listener metodu
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events
/*
                    row[0] = jTable1.getSelectedRow(); // select a row
                    String id = jTable1.getValueAt(row[0], 4).toString();
                    studyOpen.StudyOpenWeasis(urlCreator.CreateURLConnector(argIP, argPort, id));
                     */
                }
            }
        });
    }

    public static String[][] baslangic() throws IOException {
        StudyQuery query = new StudyQuery();
        QueryProcess response = new QueryProcess();
        StudyData studyData = new StudyData();
        ArrayList<StudyData> dataList;
        List<Integer> patient = new ArrayList<Integer>();
        UrlCreator creator = new UrlCreator();
        //patient id ye gore query olusturup gelen json datasini parse ediyoruz ve study data tipindeki arraylistimize aliyoruz
        dataList = query.StudyQueryParse(response.QueryProcessMethod(url, patientId).toString());
        String[][] result = new String[dataList.size()][16];

        for (int i = 0; i < dataList.size(); i++) {
            //bu if blogunun gerekliligi tartismaya acik
            if (dataList.get(i).PatientsIDV2.equals(patientId)) {

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

        return result;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {

        //TODO kisillestirme icin belirli parametreler gelecek mesela pencere kapansin yada ekrani kaplasin vs gibi
        /*program buradan basliyor once gelen arg dizisi parse ediliyor
                orn arg; "15736993946" "http://192.168.12.44:8080/dcm4chee-arc/aets/DCM4CHEE/" "192.168.12.44" "11112"
                yukarida yer alan args dizisi .bat dosyasinda da mevcut
         */
        patientId = args[0];
        url = args[1];
        argIP = args[2];
        argPort = args[3];
        webPort = args[4];

        String[][] result2 = baslangic();

        /* UIManager.put("control", new Color(128, 128, 128));
        UIManager.put("info", new Color(128, 128, 128));
        UIManager.put("nimbusBase", new Color(18, 30, 49));
        UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
        UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
        UIManager.put("nimbusFocus", new Color(115, 164, 209));
        UIManager.put("nimbusGreen", new Color(176, 179, 50));
        UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
        UIManager.put("nimbusLightBackground", new Color(18, 30, 49));
        UIManager.put("nimbusOrange", new Color(191, 98, 4));
        UIManager.put("nimbusRed", new Color(169, 46, 34));
        UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
        UIManager.put("nimbusSelectionBackground", new Color(104, 93, 156));
        UIManager.put("text", new Color(230, 230, 230)); 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

        new MainFrame(baslangic(), url, argIP, argPort);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Yenile;
    private javax.swing.JButton jAltiAyButton;
    private javax.swing.JButton jBirAyButton;
    private javax.swing.JButton jBirYılButton;
    private javax.swing.JButton jBugunButton;
    private javax.swing.JButton jButunButton;
    private javax.swing.JButton jDunButton;
    private javax.swing.JCheckBox jFiltCheck;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> jModalityCombo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JLabel jPatientBirthDate;
    public static javax.swing.JLabel jPatientID;
    public static javax.swing.JLabel jPatientName;
    public static javax.swing.JLabel jPatientSex;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JButton jWeasisButton;
    private javax.swing.JButton jWebViewerButton;
    // End of variables declaration//GEN-END:variables
}
