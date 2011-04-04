package com.energeya.lab.springrmijobs;

import junit.framework.Assert;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class Client
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
                Assert.assertNull(UUIDJobHolder.getUUIDJob());
                server.getCode();
                Assert.assertNotNull(UUIDJobHolder.getUUIDJob());
                System.out.println("CLIENT: " + UUIDJobHolder.getUUIDJob().getUUID());
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
        this.server = (Server) clientCtx.getBean("server");
        this.jobQueueManager = (JobQueueManager) clientCtx.getBean("jobQueueManagerRMI");
    }
    
    ApplicationContext serverCtx,clientCtx;
    @Before
    public void setUp(){
        serverCtx = new  ClassPathXmlApplicationContext("/spring-services.xml");
        clientCtx = new  ClassPathXmlApplicationContext("/spring-client.xml");
    }

}
