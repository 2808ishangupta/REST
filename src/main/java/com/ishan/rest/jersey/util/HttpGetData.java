package com.ishan.rest.jersey.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetData
{
    public static String getData(URL url) throws IOException
    {
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        StringBuffer response = new StringBuffer();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())))
        {
            String inputLine;
            while((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }
        }
        return response.toString();
    }
}
