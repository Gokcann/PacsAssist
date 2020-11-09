package com.company;

import java.util.concurrent.TimeUnit;

public class StudyOpen {

    public void StudyOpenWeasis(String link) {

        try {
            /*
        //getscu icin
        Process process = new ProcessBuilder("C:\\Program Files\\Weasis\\Weasis.exe", "$dicom:get -l \"C:/PacsAssist\"").start();
             */
            //Process process2 = new ProcessBuilder("C:\\Program Files\\Weasis\\Weasis.exe", "$weasis:ui --quit").start();
            //TimeUnit.SECONDS.sleep(5);
            Process process = new ProcessBuilder("C:\\Program Files\\Weasis\\Weasis.exe", link).start();

            System.exit(0);

        } catch (Exception ex) {

        }
    }
}
