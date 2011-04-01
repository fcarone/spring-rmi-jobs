package com.energeya.lab.springrmijobs;

public class JobQueueManagerImpl implements JobQueueManager
{
    
    public void addJob(String uuid, Thread t)
    {
        JobQueueHolder.addJob(uuid, t);
    }

    public Boolean removeJob(String uuid)
    {
        return JobQueueHolder.removeJob(uuid);
    }

    public Integer countJobs()
    {
        return JobQueueHolder.countJobs();
    }

    public void killJob(String job)
    {
        Thread t = JobQueueHolder.getJob(job);
        if (t != null && !t.isInterrupted())
        {
            t.interrupt();
        }
    }

}
