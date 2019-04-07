package vorovque.bot.demo.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class HttpUtil {
    private static String sendGET(String adr) throws IOException {
        System.out.println("SENDING GET " + adr + " " + new Date().getTime());
        URL obj = new URL(adr);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "TorMOzilla");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return response.toString() + " ";
        } else {
            System.out.println("error while check transactions " + adr);
            System.out.println("retry");
            sendGET(adr);
        }
        return "0 ";
    }

    public static String d3ByRating() {
        try {
            System.out.println("get D3 posts by rating");
            return sendGET("https://d3.ru/api/posts/?sorting=rating&threshold_date=day"); //
        } catch (IOException e) {
            System.out.println("cant get d3 posts by rating");
            e.printStackTrace();
        }
        return "null";
    }

    public static String getD3Gif() {
        try {
            System.out.println("get D3 IMG posts by rating");
            return sendGET("https://d3.ru/api/domains/gif/posts/"); //?sorting=rating&threshold_date=day
        } catch (IOException e) {
            System.out.println("cant get d3 IMG posts by rating");
            e.printStackTrace();
        }
        return "null";
    }

    public File getFileByURL(String URL) { //TODO DELETE FILE AFTER DOWNLOAD
        File f = new File(URL.substring(URL.lastIndexOf("/") + 1, URL.length()));
        InputStream is = null;
        BufferedOutputStream outStream = null;

        try {
            URL url;
            byte[] buf;
            int byteRead, byteWritten = 0;
            url = new URL(URL);
            outStream = new BufferedOutputStream(new FileOutputStream(f));


            URLConnection conn = url.openConnection();
            is = conn.getInputStream();
            buf = new byte[1024];
            while ((byteRead = is.read(buf)) != -1) {
                outStream.write(buf, 0, byteRead);
                byteWritten += byteRead;
            }
            System.out.println("DOWNLOAD File size bytes "+byteWritten);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return f;

    }
}
