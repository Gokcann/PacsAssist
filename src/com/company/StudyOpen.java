/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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