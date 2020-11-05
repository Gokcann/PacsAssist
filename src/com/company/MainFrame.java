package com.company;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

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
    public static String queryMod;
    Calendar cal;
    Date sontarih;

    public MainFrame() {
        initComponents();
    }

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
        jModalityCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jBugunTButton = new ColorToggleButton();
        jDunTButton = new ColorToggleButton();
        jBirAyTButton = new ColorToggleButton();
        jAltiAyTButton = new ColorToggleButton();
        jBirYilTButton = new ColorToggleButton();
        jHepsiTButton = new ColorToggleButton();

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

        jWebViewerButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jWebViewerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data-transfer.png"))); // NOI18N
        jWebViewerButton.setText("WEB");
        jWebViewerButton.setToolTipText("");
        jWebViewerButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jWebViewerButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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
                .addGap(4, 4, 4)
                .addComponent(jWebViewerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jWeasisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPatientID, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPatientSex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPatientBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        Yenile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        Yenile.setText("Yenile");
        Yenile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Yenile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
        jFiltCheck.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jFiltCheckStateChanged(evt);
            }
        });
        jFiltCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFiltCheckActionPerformed(evt);
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

        jBugunTButton.setText("Bugün");
        jBugunTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBugunTButtonActionPerformed(evt);
            }
        });

        jDunTButton.setText("Dün");
        jDunTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDunTButtonActionPerformed(evt);
            }
        });

        jBirAyTButton.setText("Son 1 Ay");
        jBirAyTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBirAyTButtonActionPerformed(evt);
            }
        });

        jAltiAyTButton.setText("Son 6 Ay");
        jAltiAyTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAltiAyTButtonActionPerformed(evt);
            }
        });

        jBirYilTButton.setText("Son 1 Yıl");
        jBirYilTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBirYilTButtonActionPerformed(evt);
            }
        });

        jHepsiTButton.setText("Hepsini Seç");
        jHepsiTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHepsiTButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jFiltCheck, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBugunTButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDunTButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBirAyTButton, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBirYilTButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHepsiTButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jAltiAyTButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jModalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFiltCheck)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jAltiAyTButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jModalityCombo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBugunTButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDunTButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBirYilTButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jHepsiTButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBirAyTButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
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
        actions.openWeb(argIP, webPort, patientId);
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
        queryMod = jModalityCombo.getSelectedItem().toString();
        //Calendar cal = Calendar.getInstance();
        //cal.add(Calendar.YEAR, -10);
        //Date sontarih = cal.getTime();
        if (toggleSelected()) {
            actions.filtre(jFiltCheck.isSelected(), sontarih, queryMod, toggleSelected(), jTable1.getModel());
        }
        else {
            cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, -10);
            sontarih = cal.getTime();
            actions.filtre(jFiltCheck.isSelected(), sontarih, queryMod, toggleSelected(), jTable1.getModel()); 
        }
               
        /*
         jModalityCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actions.filtre(jFiltCheck.isSelected(), sontarih, queryMod, toggleSelected());
            }
        } );
        */
    }//GEN-LAST:event_jModalityComboActionPerformed

    public boolean toggleSelected() {
        if (jHepsiTButton.isSelected() || jBirYilTButton.isSelected() || jAltiAyTButton.isSelected() || jBirAyTButton.isSelected() || jDunTButton.isSelected() || jBugunTButton.isSelected())  {
            return true;
        }else {
            return false;
        }
    }
    
    
    private void jBugunTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBugunTButtonActionPerformed
        jHepsiTButton.setSelected(false);
        jAltiAyTButton.setSelected(false);
        jBirYilTButton.setSelected(false);
        jBirAyTButton.setSelected(false);
        jDunTButton.setSelected(false);
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        sontarih = cal.getTime();
        queryMod = jModalityCombo.getSelectedItem().toString();

        actions.filtre(jFiltCheck.isSelected(), sontarih, queryMod, toggleSelected(), jTable1.getModel());
    }//GEN-LAST:event_jBugunTButtonActionPerformed

    private void jDunTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDunTButtonActionPerformed
        jHepsiTButton.setSelected(false);
        jAltiAyTButton.setSelected(false);
        jBirYilTButton.setSelected(false);
        jBirAyTButton.setSelected(false);
        jBugunTButton.setSelected(false);
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        sontarih = cal.getTime();
        queryMod = jModalityCombo.getSelectedItem().toString();

        actions.filtre(jFiltCheck.isSelected(), sontarih, queryMod, toggleSelected(), jTable1.getModel());
    }//GEN-LAST:event_jDunTButtonActionPerformed

    private void jBirAyTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBirAyTButtonActionPerformed

        jHepsiTButton.setSelected(false);
        jAltiAyTButton.setSelected(false);
        jBirYilTButton.setSelected(false);
        jDunTButton.setSelected(false);
        jBugunTButton.setSelected(false);
        cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        sontarih = cal.getTime();
        queryMod = jModalityCombo.getSelectedItem().toString();

        actions.filtre(jFiltCheck.isSelected(), sontarih, queryMod, toggleSelected(), jTable1.getModel());
    }//GEN-LAST:event_jBirAyTButtonActionPerformed

    private void jAltiAyTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAltiAyTButtonActionPerformed

        jHepsiTButton.setSelected(false);
        jBirYilTButton.setSelected(false);
        jBirAyTButton.setSelected(false);
        jDunTButton.setSelected(false);
        jBugunTButton.setSelected(false);
        cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -6);
        sontarih = cal.getTime();
        queryMod = jModalityCombo.getSelectedItem().toString();

        actions.filtre(jFiltCheck.isSelected(), sontarih, queryMod, toggleSelected(), jTable1.getModel());
    }//GEN-LAST:event_jAltiAyTButtonActionPerformed

    private void jBirYilTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBirYilTButtonActionPerformed

        jHepsiTButton.setSelected(false);
        jAltiAyTButton.setSelected(false);
        jBirAyTButton.setSelected(false);
        jDunTButton.setSelected(false);
        jBugunTButton.setSelected(false);
        cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -12);
        sontarih = cal.getTime();
        queryMod = jModalityCombo.getSelectedItem().toString();

        actions.filtre(jFiltCheck.isSelected(), sontarih, queryMod, toggleSelected(), jTable1.getModel());
        System.out.println("butona basildi");
        System.out.println(jBirYilTButton.isSelected());
    }//GEN-LAST:event_jBirYilTButtonActionPerformed

    private void jHepsiTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHepsiTButtonActionPerformed

        jBirYilTButton.setSelected(false);
        jAltiAyTButton.setSelected(false);
        jBirAyTButton.setSelected(false);
        jDunTButton.setSelected(false);
        jBugunTButton.setSelected(false);
        cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -20);
        sontarih = cal.getTime();
        queryMod = jModalityCombo.getSelectedItem().toString();

        actions.filtre(jFiltCheck.isSelected(), sontarih, queryMod, toggleSelected(), jTable1.getModel());
    }//GEN-LAST:event_jHepsiTButtonActionPerformed

    private void jFiltCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFiltCheckActionPerformed
        // TODO add your handling code here:
        queryMod = jModalityCombo.getSelectedItem().toString();
        cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -10);
        sontarih = cal.getTime();
        actions.filtre(jFiltCheck.isSelected(), sontarih, queryMod, toggleSelected(), jTable1.getModel());
    }//GEN-LAST:event_jFiltCheckActionPerformed

    private void jFiltCheckStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jFiltCheckStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jFiltCheckStateChanged

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

                    row[0] = jTable1.getSelectedRow();
                    if (jTable1.getValueAt(row[0], 6).equals(false)) {
                        jTable1.setValueAt(true, row[0], 6);
                        selected.add(jTable1.getValueAt(row[0], 4).toString());
                    } else {
                        jTable1.setValueAt(false, row[0], 6);
                        selected.remove(jTable1.getValueAt(row[0], 4).toString());
                    }
                    /*
                    row[0] = jTable1.getSelectedRow(); // select a row
                    String id = jTable1.getValueAt(row[0], 4).toString();
                    studyOpen.StudyOpenWeasis(urlCreator.CreateURLConnector(argIP, argPort, id));
                     */
                }
            }
        }
        );
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
    public static javax.swing.JToggleButton jAltiAyTButton;
    public static javax.swing.JToggleButton jBirAyTButton;
    public static javax.swing.JToggleButton jBirYilTButton;
    public static javax.swing.JToggleButton jBugunTButton;
    public static javax.swing.JToggleButton jDunTButton;
    public static javax.swing.JCheckBox jFiltCheck;
    public static javax.swing.JToggleButton jHepsiTButton;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JComboBox<String> jModalityCombo;
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
