package com.energeya.lab.springrmijobs;

import com.energeya.lab.springrmijobs.UUIDJob;
import com.energeya.lab.springrmijobs.UUIDJobHolder;

public class ServerImpl implements Server
{

    @Override
    public String getCode()
    {
        UUIDJob uuidJob = UUIDJobHolder.getUUIDJob();
        try
        {
            Thread.sleep(9000L);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        if (uuidJob == null)
        {
            return "No UUID job";
        }
        return uuidJob.toString();
    }
    
}
