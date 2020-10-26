/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetThumb {

    public static ImageIcon GetThumbnail(String[][] data, Integer index, String urlArgs, String argIP, String argPort) throws IOException {

        UrlCreator urlCreator = new UrlCreator();
        ImageIcon icon = null;
        //obj nin 12. elemani study instance uid
        String s = data[index][12];
        //study instance uidye gore thumbnail goruntulerini veren linki olusturmak icin createurl metonuda gonderiyoruz
        URL url = new URL(urlCreator.CreateURL(urlArgs , s));
        //gelen url e get metoduyla baglanip gorseli okuyup bufferlıyoruz
        HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
        urlConnect.setRequestMethod("GET");
        urlConnect.setDoOutput(true);
        urlConnect.setReadTimeout(5000);

            /*burasi daha hizli bir serverda kullanilabilir
            try(InputStream inputStream = urlConnect.getInputStream()) {

                BufferedImage img = ImageIO.read(urlConnect.getInputStream());
                ImageIcon icon = new ImageIcon(resize(img));
                data[i][0] = icon;
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
             */

        //TODO try catch blogu eklenecek image io icin
        while (urlConnect.getResponseCode() != HttpURLConnection.HTTP_INTERNAL_ERROR) {
            BufferedImage img = ImageIO.read(urlConnect.getInputStream());
            if(img != null){
                icon = new ImageIcon(resize(img));
            }
            break;
        }

        return icon;
    }

    public static BufferedImage resize(BufferedImage img) {
        Image tmp = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
