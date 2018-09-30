package com.ishan.rest.jersey.model;

public class BitCoinData
{
    String openRate;
    String closeRate;
    String currentRate;
    String currency;
    String updatedTime;
    String averageValue;
    
    public String getCurrentRate()
    {
        return currentRate;
    }
    
    public void setCurrentRate(String currentRate)
    {
        this.currentRate = currentRate;
    }
    
    public String getOpenRate()
    {
        return openRate;
    }
    
    public void setOpenRate(String openRate)
    {
        this.openRate = openRate;
    }
    
    public String getCloseRate()
    {
        return closeRate;
    }
    
    public void setCloseRate(String closeRate)
    {
        this.closeRate = closeRate;
    }
    
    public String getCurrency()
    {
        return currency;
    }
    
    public void setCurrency(String currency)
    {
        this.currency = currency;
    }
    
    public String getUpdatedTime()
    {
        return updatedTime;
    }
    
    public void setUpdatedTime(String updatedTime)
    {
        this.updatedTime = updatedTime;
    }
    
    public String getAverageValue()
    {
        return averageValue;
    }
    
    public void setAverageValue(String averageValue)
    {
        this.averageValue = averageValue;
    }
}
