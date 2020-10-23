package com.company;

import java.io.File;
import java.io.IOException;

public class StudyOpen {

    public void StudyOpenWeasis(String link) {

        try {
        /*
        //getscu icin
        Process process = new ProcessBuilder("C:\\Program Files\\Weasis\\Weasis.exe", "$dicom:get -l \"C:/PacsAssist\"").start();
         */
            Process process = new ProcessBuilder("C:\\Program Files\\Weasis\\Weasis.exe", link).start();
            System.exit(0);

        }catch (Exception ex){

        }
    }
}
