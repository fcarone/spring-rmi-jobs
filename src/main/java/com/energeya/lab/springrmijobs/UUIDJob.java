package com.energeya.lab.springrmijobs;

import java.io.Serializable;
import java.util.UUID;

public class UUIDJob implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -720821895258070781L;
    private String UUIDJob;
    
    public void init()
    {
        UUIDJob = UUID.randomUUID().toString();
    }
    
    public String getUUID()
    {
        return UUIDJob;
    }
}
