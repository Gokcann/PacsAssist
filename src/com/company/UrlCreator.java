package com.company;

import static com.company.responseBody.location;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.swing.JOptionPane;

public class UrlCreator {

    public String multisend = "";
    public static String location;

    public String CreateURL(String url, String s) throws MalformedURLException {

        String h = "wado?requestType=WADO&studyUID=";
        String u = url + h + s;

        return u;
    }

    //pacs connector link olusturucu
    public String CreateURLConnector(String ip, String port, List selected) throws IOException {

        try {
        if (selected.size() == 1) {
            //String firstly = "$dicom:close --all" + " , ";
            //String first = "$dicom:get -w ";
            String link = "http://" + ip + ":" + port;
            String last = "/weasis-pacs-connector/IHEInvokeImageDisplay?requestType=STUDY&studyUID=";
            String uid = selected.get(0) + "&cdb";
            String send = link + last + uid;
            URL obj = new URL(send);
            URLConnection conn = obj.openConnection();
            location = conn.getHeaderField("Location");
            return location;

        } else {
           
            for (int i = 0; i < selected.size() - 1; i++) {
                //String first = "$dicom:get -w ";
                String link = "http://" + ip + ":" + port;
                String last = "/weasis-pacs-connector/IHEInvokeImageDisplay?requestType=STUDY&studyUID=";
                String uid = selected.get(i) + "&cdb";
                String send = link + last + uid;
                URL obj = new URL(send);
                URLConnection conn = obj.openConnection();
                location = conn.getHeaderField("Location") + " , ";
                multisend = multisend + location;

            }
            //String first = "$dicom:get -w ";
            String link = "http://" + ip + ":" + port;
            String last = "/weasis-pacs-connector/IHEInvokeImageDisplay?requestType=STUDY&studyUID=";
            String uid = selected.get(selected.size() - 1) + "&cdb";
            String send = link + last + uid;
            URL obj = new URL(send);
            URLConnection conn = obj.openConnection();
            location = conn.getHeaderField("Location");
            multisend = multisend + location;

            System.out.println("*************");
            System.out.println(multisend);
            System.out.println("*************");
            //return multisend;
        }
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Goruntu weasise aktarilamiyor; Location header failed!");
        }finally {
            
        }
            return multisend;
    }
}
