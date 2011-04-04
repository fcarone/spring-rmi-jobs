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

    public static UUIDJob initUUIDJob()
    {
        if (localUUID.get() == null)
        {
            localUUID.set(UUIDJob.create());
        }
        return localUUID.get();
    }

    public static UUIDJob getUUIDJob()
    {
        return localUUID.get();
    }

}
