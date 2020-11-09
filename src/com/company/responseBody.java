/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Metasoft
 */
public class responseBody {

    public static String location;
/*
    public static void bcd() {
        try {
            
            URL obj = new URL("http://192.168.12.132:8080/weasis-pacs-connector/IHEInvokeImageDisplay?requestType=STUDY&studyUID=1.2.840.20200723.082732.006.0.192168.010.10.17284&cdb");
            URLConnection conn = obj.openConnection();
            Location = conn.getHeaderField("Location");
            
            Map<String, List<String>> map = conn.getHeaderFields();
            //Object abc = "Location";
            //String abcd = map.get(abc).toString();
            //StringBuffer sb = new StringBuffer(abcd);
            //sb.delete(abcd.length() - 1, abcd.length());
            //sb.delete(0, 1);
            //System.out.println(sb.toString());
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                System.out.println("Key : " + entry.getKey()
                        + " ,Value : " + entry.getValue());
            }
            Process process3 = new ProcessBuilder("C:\\Program Files\\Weasis\\Weasis.exe",Location).start();
            System.exit(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    
        public String multisend = "";

    //wado link olusturucu
    public String CreateURL(String url, String s) throws MalformedURLException {

        String h = "wado?requestType=WADO&studyUID=";
        String u = url + h + s;

        return u;
    }

    //pacs connector link olusturucu
    public String CreateURLConnector(String ip, String port, List selected) throws IOException {

        if (selected.size() == 1) {
            //String firstly = "$dicom:close --all" + " , ";
            //String first = "$dicom:get -w ";
            String link = "\"http://" + ip + ":" + port;
            String last = "IHEInvokeImageDisplay?requestType=STUDY&studyUID=";
            String uid = selected.get(0) + "\"";
            String send = link + last + uid;
            URL obj = new URL(send);
            URLConnection conn = obj.openConnection();
            location = conn.getHeaderField("Location");
            return location;

        } else {
           
            for (int i = 0; i < selected.size() - 1; i++) {
                //String first = "$dicom:get -w ";
                String link = "\"http://" + ip + ":" + port;
                String last = "IHEInvokeImageDisplay?requestType=STUDY&studyUID=";
                String uid = selected.get(i) + "\"" + " , ";
                String send = link + last + uid;
                URL obj = new URL(send);
                URLConnection conn = obj.openConnection();
                location = conn.getHeaderField("Location");
                multisend = multisend + " , " + location;

            }
            //String first = "$dicom:get -w ";
            String link = "\"http://" + ip + ":" + port;
            String last = "IHEInvokeImageDisplay?requestType=STUDY&studyUID=";
            String uid = selected.get(selected.size() - 1) + "\"";
            String send = link + last + uid;
            URL obj = new URL(send);
            URLConnection conn = obj.openConnection();
            location = conn.getHeaderField("Location");
            multisend = multisend + location;

            System.out.println("*************");
            System.out.println(multisend);
            System.out.println("*************");
            return multisend;
        }

    }
}
