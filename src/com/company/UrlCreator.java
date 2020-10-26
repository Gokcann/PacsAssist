/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.net.MalformedURLException;

public class UrlCreator {

    //wado link olusturucu
    public String CreateURL(String url, String s) throws MalformedURLException {

        String h = "wado?requestType=WADO&studyUID=";
        String u = url+ h + s;

        return u;
    }

    //pacs connector link olusturucu
    public String CreateURLConnector(String ip, String port, String studyUID) {
        String first = "$dicom:get -w ";
        String link = "\"http://" + ip + ":" + port;
        String last = "/weasis-pacs-connector/manifest?studyUID=";
        String uid = studyUID + "\"";
        String send = first+link+last+uid;

        return send;
    }
}

