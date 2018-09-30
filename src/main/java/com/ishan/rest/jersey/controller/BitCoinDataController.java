package com.ishan.rest.jersey.controller;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.ishan.rest.jersey.model.BitCoinData;
import com.ishan.rest.jersey.service.BitCoinService;

@Component
@Path("/bitcoindata")
public class BitCoinDataController
{
    private BitCoinService bitCoinService;
    
    public BitCoinDataController(BitCoinService bitCoinService)
    {
        this.bitCoinService = bitCoinService;
    }
    
    @GET
    @Produces("application/json")
    public BitCoinData getCurrentData()
    {
        return BitCoinService.getCurrentData();
    }
    
    @GET
    @Produces("application/json")
    @Path("/overlastminutes/{timeSlot}")
    public Collection<BitCoinData> getDataOverLastMinutes(@PathParam("timeSlot") String timeSlot)
    {
        return BitCoinService.getDataForLastXMinutes(timeSlot);
    }
    
    @GET
    @Produces("application/json")
    @Path("/overlastminutes/{timeSlot}/currency/{currency}")
    public Collection<BitCoinData> getDataOverLastMinutes(@PathParam("timeSlot") String timeSlot, @PathParam("currency") String currency)
    {
        return BitCoinService.getDataForLastXMinutes(timeSlot,currency);
    }
    
    @GET
    @Produces("application/json")
    @Path("/average")
    public BitCoinData getAverageData()
    {
        return bitCoinService.getAverageData();
    }
}
