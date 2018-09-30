package com.ishan.rest.jersey.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Service;

import com.ishan.rest.jersey.model.BitCoinData;
import com.ishan.rest.jersey.util.HttpGetData;

@Service
public class BitCoinService
{
    public static Collection<BitCoinData> getDataForLastXMinutes(String minutes)
    {
        return getDataForLastXMinutes(minutes, "USD");
    }
    
    public static Collection<BitCoinData> getDataForLastXMinutes(String minutes, String currency)
    {
        if(Integer.parseInt(minutes) > 60)
        {
            throw new RuntimeException("Minutes must be less the 60");
        }
        
        List<BitCoinData> bDataList = new ArrayList<>();
        try
        {
            String baseUrl = "https://min-api.cryptocompare.com/data/histominute?fsym=BTC&tsym=";
            String middlePortion = "&limit=";
            String response = HttpGetData.getData(new URL(baseUrl + currency + middlePortion + minutes));
            JSONObject myResponse = new JSONObject(response);
            JSONArray dataArray = myResponse.getJSONArray("Data");
            for(int i = 0; i < dataArray.length(); i++)
            {
                BitCoinData bitData = new BitCoinData();
                JSONObject data = dataArray.getJSONObject(i);
                bitData.setUpdatedTime(data.getString("time"));
                bitData.setCurrency(currency);
                bitData.setCloseRate(data.getString("close"));
                bitData.setOpenRate(data.getString("open"));
                bitData.setAverageValue("");
                bDataList.add(bitData);
            }
        }
        catch(IOException | JSONException e)
        {
            e.printStackTrace();
        }
        return bDataList;
    }
    
    public static BitCoinData getCurrentData()
    {
        BitCoinData data = new BitCoinData();
        try
        {
            String baseUrl = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD";
            String response = HttpGetData.getData(new URL(baseUrl));
            JSONObject myResponse = new JSONObject(response);
            
            data.setCurrentRate(myResponse.getString("USD"));
            data.setCurrency("USD");
        
        }
        catch(IOException | JSONException e)
        {
            e.printStackTrace();
        }
        return data;
    }
    
    public BitCoinData getAverageData()
    {
        BitCoinData data = new BitCoinData();
        try
        {
            String baseUrl = "https://min-api.cryptocompare.com/data/dayAvg?fsym=BTC&tsym=USD";
            String response = HttpGetData.getData(new URL(baseUrl));
            JSONObject myResponse = new JSONObject(response);
            data.setAverageValue(myResponse.getString("USD"));
            data.setCurrency("USD");
            data.setOpenRate("");
            data.setCloseRate("");
            data.setUpdatedTime("");
            
        }
        catch(IOException | JSONException e)
        {
            e.printStackTrace();
        }
        return data;
    }
}
