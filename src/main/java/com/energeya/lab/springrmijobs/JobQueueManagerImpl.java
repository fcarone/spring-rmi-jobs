package com.energeya.lab.springrmijobs;

public class JobQueueManagerImpl implements JobQueueManager
{
    
    @Override
	public void addJob(String uuid, Thread t)
    {
        JobQueueHolder.addJob(uuid, t);
    }

    @Override
	public Boolean removeJob(String uuid)
    {
        return JobQueueHolder.removeJob(uuid);
    }

    @Override
	public Integer countJobs()
    {
        return JobQueueHolder.countJobs();
    }

    @Override
	public void killJob(String job)
    {
        Thread t = JobQueueHolder.getJob(job);
        if (t != null && !t.isInterrupted())
        {
            t.interrupt();
        }
    }

}
