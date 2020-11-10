package com.company;

import java.util.concurrent.TimeUnit;

public class StudyOpen {

    public void StudyOpenWeasis(String link) {

        try {

            //getscu icin
            Process process = new ProcessBuilder("Weasis.exe", link).start();
            //"open","/Applications/Chess.app"
            //Process process_mac = new ProcessBuilder("open","/Applications/Weasis.app", link).start();

            System.exit(0);

        } catch (Exception ex) {

        }
    }
}
