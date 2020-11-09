package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

public class QueryProcess {

    private static HttpURLConnection connection;

    public StringBuffer QueryProcessMethod(String urlArgs, String patientArgs) {

        // ********THIS IS FIRST METHOD*******
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            //URL url = new URL("http://192.168.12.44:8080/dcm4chee-arc/aets/DCM4CHEE/rs/studies");
            String myURL = urlArgs + "rs/studies?PatientID=" + patientArgs;
            URL url = new URL(myURL);
            //http://192.168.12.44:8080/dcm4chee-arc/aets/DCM4CHEE/rs/mwlitems
            //http://192.168.12.113:8080/dcm4chee-arc/aets/DCM4CHEE/rs/mwlitems

            connection = (HttpURLConnection) url.openConnection();
            //request
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            //System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            //System.out.println(responseContent.toString());
            //parse(responseContent.toString());

        } catch (MalformedURLException e) {
            //JOptionPane.showMessageDialog(null, "Baglanti Hatasi!!");
            e.printStackTrace();
            //System.exit(0);
        } catch (IOException e) {
            //JOptionPane.showMessageDialog(null, "Baglanti Hatasi!!");
            e.printStackTrace();
            //System.exit(0);
        } finally {
            connection.disconnect();

        }
        //return string buffer type response
        if(responseContent.toString().length() < 1){
            JOptionPane.showMessageDialog(null, "Baglanti Hatasi!!");
            System.exit(0);
            return responseContent;
        }else {
            return responseContent;
        }
        


        /*
        //can be used in other situations

        // *********THIS IS SECOND METHOD********
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://192.168.12.44:8080/dcm4chee-arc/aets/DCM4CHEE/rs/mwlitems")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

         */
    }
}
