package com.energeya.lab.springrmijobs;

public class UUIDJobHolder
{

    private static ThreadLocal<UUIDJob> localUUID = new ThreadLocal<UUIDJob>();
    
    private UUIDJobHolder()
    {
        //
    }
    
    public static void setUUIDJob(UUIDJob uuidJob)
    {
        localUUID.set(uuidJob);
    }
    
    public static UUIDJob getUUIDJob()
    {
        return localUUID.get();
    }
    

}
