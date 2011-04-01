package com.energeya.lab.springrmijobs;

public interface JobQueueManager
{

    void addJob(String uuid, Thread t);
    
    Boolean removeJob(String uuid);
    
    Integer countJobs();

    void killJob(String job);
    
}
