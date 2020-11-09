/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Metasoft
 */
public class responseBody {

    public static String Location;

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
}
