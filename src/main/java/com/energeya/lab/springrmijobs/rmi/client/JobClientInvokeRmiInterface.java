package com.energeya.lab.springrmijobs.rmi.client;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.energeya.lab.springrmijobs.UUIDJob;
import com.energeya.lab.springrmijobs.UUIDJobHolder;

/**
 * Generates random UUID for every RMI client invocation
 * 
 */
public class JobClientInvokeRmiInterface extends RmiProxyFactoryBean {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		UUIDJob uuidJob = new UUIDJob();
		uuidJob.init();
		System.out.println("CLIENT: " + uuidJob.getUUID());
		UUIDJobHolder.setUUIDJob(uuidJob);
		return super.invoke(invocation);
	}

}
