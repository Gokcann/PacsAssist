/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.net.MalformedURLException;
import java.util.List;

public class UrlCreator {

        public String multisend = "";


    //wado link olusturucu
    public String CreateURL(String url, String s) throws MalformedURLException {

        String h = "wado?requestType=WADO&studyUID=";
        String u = url+ h + s;

        return u;
    }

    //pacs connector link olusturucu
    public String CreateURLConnector(String ip, String port, List selected) {


        if (selected.size() == 1) {
        String first = "$dicom:get -w ";
        String link = "\"http://" + ip + ":" + port;
        String last = "/weasis-pacs-connector/manifest?studyUID=";
        String uid = selected.get(0) + "\"";
        String send = first+link+last+uid;
        return send;

}
        else {
/*
        String s = selected.get(0).toString();
        for (int i=1;i<selected.size();i++) {
        s = s + "&" + "studyUID=" + selected.get(i);

        }
        String first = "$dicom:get -w ";
        String link = "\"http://" + ip + ":" + port;
        String last = "/weasis-pacs-connector/manifest?studyUID=";
        String uid = s + "\"";
        String send = first+link+last+uid;
        System.out.println("*************");
        System.out.println(send);
        System.out.println("*************");
        return send;
*/

        
        for (int i=0;i<selected.size()-1;i++) {
        String first = "$dicom:get -w ";
        String link = "\"http://" + ip + ":" + port;
        String last = "/weasis-pacs-connector/manifest?studyUID=";
        String uid = selected.get(i) + "\"" + " , ";
        String send = first+link+last+uid;
        multisend = multisend + send;

                    }
        String first = "$dicom:get -w ";
        String link = "\"http://" + ip + ":" + port;
        String last = "/weasis-pacs-connector/manifest?studyUID=";
        String uid = selected.get(selected.size()-1) + "\"";
        String send = first+link+last+uid;
        multisend = multisend + send;
        
        System.out.println("*************");
        System.out.println(multisend);
        System.out.println("*************");
        return multisend;
}




    }
}

