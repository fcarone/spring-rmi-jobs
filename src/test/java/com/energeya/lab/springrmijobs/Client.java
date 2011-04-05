package com.energeya.lab.springrmijobs;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "/spring-tests.xml" })
public class Client extends AbstractJUnit4SpringContextTests
{
    Server server;
    private JobQueueManager jobQueueManager;

    @Test
    public void test1() throws Exception
    {
        Runnable r = new Runnable() {

            @Override
            public void run()
            {
                server.getCode();
            }
            
        };
        Thread t = new Thread(r);
        t.start();
        Thread.sleep(5000);
        System.out.println("CLIENT: jobs running on the server " + jobQueueManager.countJobs());
        Thread.sleep(5000);
        System.out.println("CLIENT: jobs running on the server " + jobQueueManager.countJobs());
        Thread.sleep(5000);
    }

    /**
     * Get the RMI version of the manager
     */
    @Before
    public void setupTest()
    {
        this.server = (Server) applicationContext.getBean("serverRMI");
        this.jobQueueManager = (JobQueueManager) applicationContext.getBean("jobQueueManagerRMI");
    }

}
